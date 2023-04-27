package com.example.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class BattleFieldActivity extends AppCompatActivity {

    private ArrayList<Lutemon> lutemonStorage;
    private RecyclerView recyclerView;

    private Lutemon attacker;
    private Lutemon defender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_field);

        lutemonStorage = Storage.getInstance().getLutemonsInBattleField();
        recyclerView = findViewById(R.id.rvBattle);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TrainingListAdapter(getApplicationContext(), lutemonStorage));
    }

    // For two lutemons to fight each other
    public void fight(View view) {
        // Get chosen lutemons
        attacker = Storage.getInstance().getMovingLutemons().get(0);
        defender = Storage.getInstance().getMovingLutemons().get(1);

        // While loop controlling the battle
        System.out.println("Let the battle begin");

        // Each iteration we check if the lutemon, that's going to take the next hit, has
        // enough health points left
        while (defender.getHealth() > 0) {
            int damage = attacker.getAttack() - defender.getDefence();

            // Display stats for the attacker
            System.out.println("1: " + attacker.getName() + "(" + attacker.getColor() + ") att: " + attacker.getAttack() + "; def: " + attacker.getDefence() + "; exp: " + attacker.getExperience() + "; health: " + attacker.getHealth() + "/" + attacker.getMaxHealth());
            // And stats for the defender
            System.out.println("2: " + defender.getName() + "(" + defender.getColor() + ") att: " + defender.getAttack() + "; def: " + defender.getDefence() + "; exp: " + defender.getExperience() + "; health: " + defender.getHealth() + "/" + defender.getMaxHealth());

            // Generate a random number from 1-10 and check if it's greater than 8, leaving a
            // 20 % change for the super attack that does +2 damage
            if ((int)(Math.random() * 10) + 1 > 8) {
                System.out.println(attacker.getName() + "(" + attacker.getColor() + ") käyttää superiskun.");
                defender.setHealth(defender.health - (damage + 2));
            }
            else {
                System.out.println(attacker.getName() + "(" + attacker.getColor() + ") iskee puolustajaa.");
                defender.setHealth(defender.health - damage);
            }

            // After each attack we also check if the defending lutemon stays alive
            if (defender.getHealth() > 0) {
                System.out.println(defender.getName() + "(" + defender.getColor() + ") jäi henkiin " + defender.getHealth() + "/" + defender.getMaxHealth() + "elämäpisteellä.");
            }
            // If there is not enough health for the defender, it faints / loses
            else {
                System.out.println(defender.getName() + "(" + defender.getColor() + ") menetti elämäpisteet ja hävisi ottelun.");
                System.out.println("The Battle is over.");
                break;
            }

            // After each round we switch places
            Lutemon temporary = attacker;
            attacker = defender;
            defender = temporary;
        }
        // Regenerate lutemons to max health
        attacker.setHealth(attacker.maxHealth);
        defender.setHealth(defender.maxHealth);

        // Give the winning lutemon +2 xp and attack points
        attacker.setAttack(attacker.getAttack() + 2);
        attacker.setExperience(attacker.getExperience() + 2);

        Storage.getInstance().getMovingLutemons().clear();

        // Get user back to main page
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}