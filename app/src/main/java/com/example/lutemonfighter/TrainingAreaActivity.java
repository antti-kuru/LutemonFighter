package com.example.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class TrainingAreaActivity extends AppCompatActivity {

    private ArrayList<Lutemon> lutemonStorage;
    private RecyclerView recyclerView;

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_area);
        tvTest = findViewById(R.id.tvTEst);
        lutemonStorage = Storage.getInstance().getLutemonsInTrainingArea();
        recyclerView = findViewById(R.id.rvChooseTrainedLutemon);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TrainingListAdapter(getApplicationContext(), lutemonStorage));


    }


    public void train(View view){

        for (Lutemon lutemon : Storage.getInstance().getMovingLutemons()){
            lutemon.setAttack(lutemon.getAttack()+2);
            lutemon.setExperience(lutemon.getExperience()+2);
            tvTest.setText(lutemon.getName() + " treenaa kovaa");
        }


        for (Lutemon lutemon : Storage.getInstance().getMovingLutemons()){

        }
        Storage.getInstance().getMovingLutemons().clear();

    }


}