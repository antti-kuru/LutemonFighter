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
    private ArrayList<Lutemon> lutemonStorage;
    private RecyclerView recyclerView;
    private TextView tvBattleLog;
    private Timer timer;
    private Fight fight;

    // String for making a multiline textview
    private String battleLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_field);

        timer = new Timer();
        fight = new Fight();

        lutemonStorage = Storage.getInstance().getLutemonsInBattleField();
        recyclerView = findViewById(R.id.rvBattle);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new BattleFieldListAdapter(getApplicationContext(), lutemonStorage));

        // Set up the textview
        tvBattleLog = findViewById(R.id.tvBattleLog);
        tvBattleLog.setGravity(Gravity.CENTER);
        tvBattleLog.setTextColor(Color.parseColor("#00B4BD"));
        tvBattleLog.setTextSize(14);
    }

    // For bringing user to home page after battling
    public void returnHome(int time) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(BattleFieldActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, time);
    }

    public void startFight(View view) {
        // Check if user selected more or less than two lutemons
        if (Storage.getInstance().getMovingLutemons().size() != 2) {
            tvBattleLog.setText("Taisteluun tarvitaan kaksi lutemonia,\n hyökkääjä ja puolustaja!\n");
            Storage.getInstance().getMovingLutemons().clear();
            returnHome(3000);
            return;
        } else {
            battleLog = fight.fight();
            tvBattleLog.setText(battleLog);
            returnHome(8000);
        }
    }

}