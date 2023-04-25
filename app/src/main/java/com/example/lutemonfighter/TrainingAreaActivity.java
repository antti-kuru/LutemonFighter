package com.example.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TrainingAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_area);

        for (Lutemon lutemon : Storage.getInstance().getLutemonsInTrainingArea()){
            System.out.println(lutemon.getName());
        }

    }
}