package com.example.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class TrainingAreaActivity extends AppCompatActivity {

    private Storage lutemonStorage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_area);

        lutemonStorage = Storage.getInstance();
        recyclerView = findViewById(R.id.rvChooseTrainedLutemon);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TrainingListAdapter(getApplicationContext(), lutemonStorage.getLutemons()));
    }
}