package com.example.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
    }

    // When creating new lutemons
    public void switchToAddLutemon(View view) {
        Intent intent = new Intent(this, AddLutemonActivity.class);
        startActivity(intent);

    }

    // When moving lutemons from one place to another
    public void switchToMoveLutemon(View view) {
        Intent intent = new Intent(this, ListLutemonActivity.class);
        startActivity(intent);

    }

    // When moving lutemons to the training area
    public void switchToTrainingArea(View view) {
        Intent intent = new Intent(this, TrainingAreaActivity.class);
        startActivity(intent);

    }

    // When moving lutemons to the battlefield
    public void switchToBattleField(View view) {
        Intent intent = new Intent(this, BattleFieldActivity.class);
        startActivity(intent);

    }

    // When checking the stats of created lutemons
    public void SwitchToViewStatistics(View view) {
        Intent intent = new Intent(this, StatisticsActivity.class);
        startActivity(intent);
    }

    public void saveLutemons(View view) {
        Storage.getInstance().saveLutemons(context);
    }

    public void loadLutemons(View view) {
        Storage.getInstance().loadLutemons(context);
    }

}