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

    Timer timer;
    TextView tvFirst, tvSecond, tvThird, tvFourth, tvFifth;

    private ArrayList<Lutemon> lutemonStorage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_area);

        timer = new Timer();

        lutemonStorage = Storage.getInstance().getLutemonsInTrainingArea();
        recyclerView = findViewById(R.id.rvChooseTraining);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TrainingListAdapter(getApplicationContext(), lutemonStorage));

        tvFirst = findViewById(R.id.tvFirstEx);
        tvSecond = findViewById(R.id.tvSecondEx);
        tvThird = findViewById(R.id.tvThirdEx);
        tvFourth = findViewById(R.id.tvFourthEx);
        tvFifth = findViewById(R.id.tvFifthEx);


    }

    public void returnHome() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(TrainingAreaActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 8000);
    }

    public void letsTrain(View view) {

        // Create a list for the textviews
        TextView[] textViews = {tvFirst, tvSecond, tvThird, tvFourth, tvFifth};
        int index = 0;
        String trainingProgram;

        for (Lutemon lutemon : Storage.getInstance().getMovingLutemons()){
            lutemon.setAttack(lutemon.getAttack()+2);
            lutemon.setExperience(lutemon.getExperience()+2);

            // Creating the training program
            trainingProgram = lutemon.getName() + " juoksee juoksumatolla!\n";
            trainingProgram += lutemon.getName() + " tekee punnerruksia\n";
            trainingProgram += lutemon.getName() + " rutistaa vatsalihaksia\n";
            trainingProgram += lutemon.getName() + " vetää leukoja\n";
            trainingProgram += lutemon.getName() + " tekee kyykkyjä\n";
            trainingProgram += lutemon.getName() + " suoritti treenin ja sai 2 kokemuspistettä!\n";


            // Setting up our textviews
            textViews[index].setText(trainingProgram);
            textViews[index].setGravity(Gravity.CENTER);
            textViews[index].setTextColor(Color.parseColor("#00BFFF"));
            textViews[index].setTextSize(20);


            index++;
            // Check if user wants to train more lutemons than there are items in the list
            if (index > textViews.length) {
                break;
            }

        }


        Storage.getInstance().getMovingLutemons().clear();

        // Get user back to home page
        returnHome();

    }
}