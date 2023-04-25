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
        context = this;
    }

    public void switchToAddLutemon(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    }
    public void switchToMoveLutemon(View view){
        Intent intent = new Intent(this, ListLutemonActivity.class);
        startActivity(intent);

    }
    public void switchToTrainingArea(View view){
        Intent intent = new Intent(this, TrainingAreaActivity.class);
        startActivity(intent);

    }
    public void switchToBattleField(View view){
        Intent intent = new Intent(this, BattleFieldActivity.class);
        startActivity(intent);

    }




}