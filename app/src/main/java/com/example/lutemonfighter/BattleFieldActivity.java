package com.example.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class BattleFieldActivity extends AppCompatActivity {
    Timer timer;

    private ArrayList<Lutemon> lutemonStorage;
    private RecyclerView recyclerView;

    TextView tvBattleLog;

    // String to help making a multiline textview
    private String battleLog;

    private Lutemon attacker;
    private Lutemon defender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_field);

        timer = new Timer();

        lutemonStorage = Storage.getInstance().getLutemonsInBattleField();
        recyclerView = findViewById(R.id.rvBattle);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TrainingListAdapter(getApplicationContext(), lutemonStorage));

        // Set up our textview containing the Battle Log
        tvBattleLog = findViewById(R.id.tvBattleLog);
        tvBattleLog.setGravity(Gravity.CENTER);
        tvBattleLog.setTextColor(Color.parseColor("#00BFFF"));
        tvBattleLog.setTextSize(14);
    }

    public void returnHome() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(BattleFieldActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 8000);
    }


    // For two lutemons to fight each other
    public void fight(View view) {

        // Check if user chose more or less than two lutemons
         if (Storage.getInstance().getMovingLutemons().size() != 2) {
            tvBattleLog.setText("Taisteluun tarvitaan kaksi lutemonia,\n hyökkääjä ja puolustaja!\n");
            Storage.getInstance().getMovingLutemons().clear();
            return;
        }

        // Get chosen lutemons
        attacker = Storage.getInstance().getMovingLutemons().get(0);
        defender = Storage.getInstance().getMovingLutemons().get(1);

        // While loop controlling the battle
        battleLog = "Let the battle begin!\n";


        // Each iteration we check if the lutemon, that's going to take the next hit, has
        // enough health points left
        while (defender.getHealth() > 0) {
            int damage = defender.defence(attacker);

            // Display stats for the attacker
            battleLog += ("1: " + attacker.getName() + "(" + attacker.getColor() + ") att: " + attacker.getAttack() + "; def: " + attacker.getDefence() + "; exp: " + attacker.getExperience() + "; health: " + attacker.getHealth() + "/" + attacker.getMaxHealth() + "\n");
            // And stats for the defender
            battleLog += ("2: " + defender.getName() + "(" + defender.getColor() + ") att: " + defender.getAttack() + "; def: " + defender.getDefence() + "; exp: " + defender.getExperience() + "; health: " + defender.getHealth() + "/" + defender.getMaxHealth() + "\n");

            // Generate a random number from 1-10 and check if it's greater than 8, leaving a
            // 20 % change for the super attack that does +2 damage
            if ((int)(Math.random() * 10) + 1 > 8) {
                battleLog += (attacker.getName() + "(" + attacker.getColor() + ") käyttää superiskun.\n");
                // Leaving no chance for the defending lutemon to avoid incoming super attack
                defender.setHealth(defender.getHealth() - (damage + 2));
            }
            else {
                battleLog += (attacker.getName() + "(" + attacker.getColor() + ") iskee puolustajaa.\n");
                // Create a small probability for the lutemon to avoid incoming regural attack
                if ((int)(Math.random() * 10) + 1 > 9) {
                    battleLog += (defender.getName() + "(" + defender.getColor() + ") väisti iskun ja selvisi ilman vahinkoa.\n");
                }
                else {
                    defender.setHealth(defender.getHealth() - damage);
                }
            }

            // After each attack we also check if the defending lutemon stays alive
            if (defender.getHealth() > 0) {
                battleLog += (defender.getName() + "(" + defender.getColor() + ") jäi henkiin " + defender.getHealth() + "/" + defender.getMaxHealth() + "elämäpisteellä.\n");
            }
            // If there is not enough health for the defender, it faints / loses
            else {
                battleLog += (defender.getName() + "(" + defender.getColor() + ") menetti elämäpisteet ja hävisi ottelun.\n");
                battleLog += ("The Battle is over.\n");
                break;
            }

            // After each round we switch places
            Lutemon temporary = attacker;
            attacker = defender;
            defender = temporary;
        }

        // Display the battle log to user
        tvBattleLog.setText(battleLog);

        // Give both lutemons +1 battling sessions
        attacker.setFights(attacker.getFights() + 1);
        defender.setFights(defender.getFights() + 1);

        // Give the winner a win
        attacker.setWins(attacker.getWins() + 1);

        // Regenerate lutemons to max health
        attacker.setHealth(attacker.maxHealth);
        defender.setHealth(defender.maxHealth);

        // Give the winning lutemon +2 xp and attack points
        attacker.setAttack(attacker.getAttack() + 2);
        attacker.setExperience(attacker.getExperience() + 2);

        Storage.getInstance().getMovingLutemons().clear();

        // Get user back to main page
        returnHome();
    }

}