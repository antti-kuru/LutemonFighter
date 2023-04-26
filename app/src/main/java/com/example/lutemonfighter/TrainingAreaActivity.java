package com.example.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class TrainingAreaActivity extends AppCompatActivity {
    TextView tvFirst, tvSecond, tvThird, tvFourth, tvFifth, tvResult;

    private ArrayList<Lutemon> lutemonStorage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_area);

        lutemonStorage = Storage.getInstance().getLutemonsInTrainingArea();
        recyclerView = findViewById(R.id.rvChooseTraining);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TrainingListAdapter(getApplicationContext(), lutemonStorage));

        tvFirst = findViewById(R.id.tvFirstRound);
        tvSecond = findViewById(R.id.tvSecondRound);
        tvThird = findViewById(R.id.tvThirdRound);
        tvFourth = findViewById(R.id.tvFourthEx);
        tvFifth = findViewById(R.id.tvFifthEx);
        tvResult = findViewById(R.id.tvResult);


    }

    public void letsTrain(View view) {

        for (Lutemon lutemon : Storage.getInstance().getMovingLutemons()){
            lutemon.setAttack(lutemon.getAttack()+2);
            lutemon.setExperience(lutemon.getExperience()+2);
            tvFirst.setText(lutemon.getName() + " juoksee juoksumatolla!");


            tvSecond.setText("Lutemon tekee punnerruksia");
            tvThird.setText("Lutemon rutistaa vatsalihaksia");
            tvFourth.setText("Lutemon vetää leukoja");
            tvFifth.setText("Lutemon tekee kyykkyjä");
            tvResult.setText("Lutemon suoritti treenin ja sai 2 kokemuspistettä!");
        }


        Storage.getInstance().getMovingLutemons().clear();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}