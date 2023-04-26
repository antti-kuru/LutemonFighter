package com.example.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    public void fight(View view) {
        System.out.println("Not here");
        attacker = Storage.getInstance().getMovingLutemons().get(0);
        System.out.println("Here");
        defender = Storage.getInstance().getMovingLutemons().get(1);
        while (defender.getHealth() > 0) {
            int damage = attacker.getAttack() - defender.getDefence();
            defender.setHealth(defender.health - damage);
            if (defender.getHealth() > 0) {
                System.out.println(defender.getName() + "jäi henkiin " + defender.getHealth() + "/" + defender.getMaxHealth() + "elämäpisteellä.");
            }
            else {
                System.out.println(defender.getName() + "hävisi, ottelu loppui");
                break;
            }
            Lutemon temporary = attacker;
            attacker = defender;
            defender = temporary;
        }
        // Set lutemons health to max health
        attacker.setHealth(attacker.maxHealth);
        defender.setHealth(defender.maxHealth);

        Storage.getInstance().getMovingLutemons().clear();
    }


}