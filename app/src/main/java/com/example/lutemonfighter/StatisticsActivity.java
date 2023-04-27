package com.example.lutemonfighter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class StatisticsActivity extends AppCompatActivity {

    private Storage lutemonStorage;
    private RecyclerView rvHome;
    private RecyclerView rvTraining;
    private RecyclerView rvBattlefield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_statistics);

        lutemonStorage = Storage.getInstance();
        rvHome = findViewById(R.id.rvHomeStats);
        rvTraining = findViewById(R.id.rvTrainingStats);
        rvBattlefield = findViewById(R.id.rvBattlefieldStats);
        rvHome.setLayoutManager(new LinearLayoutManager(this));
        rvHome.setAdapter(new StatisticsListAdapter(getApplicationContext(), lutemonStorage.getLutemons()));
        rvTraining.setLayoutManager(new LinearLayoutManager(this));
        rvTraining.setAdapter(new StatisticsListAdapter(getApplicationContext(), lutemonStorage.getLutemonsInTrainingArea()));
        rvBattlefield.setLayoutManager(new LinearLayoutManager(this));
        rvBattlefield.setAdapter(new StatisticsListAdapter(getApplicationContext(), lutemonStorage.getLutemonsInBattleField()));

    }

}
