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
    private TextView tvFirst, tvSecond, tvThird, tvFourth, tvFifth;
    private StringBuilder sb;
    private ArrayList<Lutemon> lutemonStorage;
    private RecyclerView rvTrainingArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_area);

        timer = new Timer();

        lutemonStorage = Storage.getInstance().getLutemonsInTrainingArea();
        rvTrainingArea = findViewById(R.id.rvChooseTraining);

        rvTrainingArea.setLayoutManager(new LinearLayoutManager(this));
        rvTrainingArea.setAdapter(new TrainingListAdapter(getApplicationContext(), lutemonStorage));

        tvFirst = findViewById(R.id.tvFirstEx);
        tvSecond = findViewById(R.id.tvSecondEx);
        tvThird = findViewById(R.id.tvThirdEx);
        tvFourth = findViewById(R.id.tvFourthEx);
        tvFifth = findViewById(R.id.tvFifthEx);

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
    public void train(View view) {

        // Create a list for the textviews
        TextView[] textViews = {tvFirst, tvSecond, tvThird, tvFourth, tvFifth};
        int i = 0; // For iterating through the list of textviews

        // StringBuilder for handling a multiline textview
        sb = new StringBuilder();

        for (Lutemon lutemon : Storage.getInstance().getMovingLutemons()) {

            // Creating the training program
            sb.setLength(0); // Resetting the StringBuilder
            sb.append(lutemon.getName()).append(" juoksee juoksumatolla!\n");
            sb.append(lutemon.getName()).append(" tekee punnerruksia\n");
            sb.append(lutemon.getName()).append(" rutistaa vatsalihaksia\n");
            sb.append(lutemon.getName()).append(" vetää leukoja\n");
            sb.append(lutemon.getName()).append(" tekee kyykkyjä\n");
            sb.append(lutemon.getName()).append(" suoritti treenin ja sai 2 kokemuspistettä!\n");

            String trainingProgram = sb.toString();

            // Setting up our textviews
            textViews[i].setText(trainingProgram);
            textViews[i].setGravity(Gravity.CENTER);
            textViews[i].setTextColor(Color.parseColor("#00B4BD"));
            textViews[i].setTextSize(20);

            // After training, lutemon gains 2 xp, +2 attack and one completed training session
            lutemon.setExperience(lutemon.getExperience() + 2);
            lutemon.setAttack(lutemon.getAttack() + 2);
            lutemon.setTrainingSessions(lutemon.getTrainingSessions() + 1);

            i++;
            // Check if user wants to train more lutemons than there are items in the list
            if (i > textViews.length) {
                sb.setLength(0);
                sb.append("Salille mahtuu vain 5 lutemonia kerrallaan!\n");
                break;
            }

        }

        Storage.getInstance().getMovingLutemons().clear();

        // Get user back to home page
        returnHome();

    }
}