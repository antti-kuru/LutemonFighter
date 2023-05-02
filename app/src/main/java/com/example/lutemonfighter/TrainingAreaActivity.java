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

public class TrainingAreaActivity extends AppCompatActivity {

    private Timer timer;
    private TrainingArea trainingArea;
    private String trainingProgram;
    private TextView tvTrainingProgram;
    private ArrayList<Lutemon> lutemonStorage;
    private RecyclerView rvTrainingArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_area);

        timer = new Timer();
        trainingArea = new TrainingArea();

        lutemonStorage = Storage.getInstance().getLutemonsInTrainingArea();
        rvTrainingArea = findViewById(R.id.rvChooseTraining);

        rvTrainingArea.setLayoutManager(new LinearLayoutManager(this));
        rvTrainingArea.setAdapter(new TrainingListAdapter(getApplicationContext(), lutemonStorage));

        tvTrainingProgram = findViewById(R.id.tvTrainingProgram);

    }


    // For bringing user automatically back to home page after training
    public void returnHome() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(TrainingAreaActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 7000); // 7 000 ms = 7 s
    }

    // For lutemons to train
    public void trainLutemons(View view) {
        trainingProgram = trainingArea.train();

        // Setting up our textview
        tvTrainingProgram.setText(trainingProgram);
        tvTrainingProgram.setGravity(Gravity.CENTER);
        tvTrainingProgram.setTextColor(Color.parseColor("#00B4BD"));
        tvTrainingProgram.setTextSize(20);

        Storage.getInstance().getMovingLutemons().clear();

        // Get user back to home page
        returnHome();
    }
}