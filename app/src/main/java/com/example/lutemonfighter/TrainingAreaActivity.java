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

        tvFirst = findViewById(R.id.tvFirstEx);
        tvSecond = findViewById(R.id.tvSecondEx);
        tvThird = findViewById(R.id.tvThirdEx);
        tvFourth = findViewById(R.id.tvFourthEx);
        tvFifth = findViewById(R.id.tvFifthEx);
        tvResult = findViewById(R.id.tvResult);


    }

    public void letsTrain(View view) {

        for (Lutemon lutemon : Storage.getInstance().getMovingLutemons()){
            lutemon.setAttack(lutemon.getAttack()+2);
            lutemon.setExperience(lutemon.getExperience()+2);
            tvFirst.setText(lutemon.getName() + " juoksee juoksumatolla!");


            tvSecond.setText(lutemon.getName() + " tekee punnerruksia");
            tvThird.setText(lutemon.getName() + " rutistaa vatsalihaksia");
            tvFourth.setText(lutemon.getName() + " vetää leukoja");
            tvFifth.setText(lutemon.getName() + " tekee kyykkyjä");
            tvResult.setText(lutemon.getName() + " suoritti treenin ja sai 2 kokemuspistettä!");
        }


        Storage.getInstance().getMovingLutemons().clear();
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
    }
}