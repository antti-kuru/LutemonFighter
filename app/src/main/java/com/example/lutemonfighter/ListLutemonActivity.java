package com.example.lutemonfighter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListLutemonActivity extends AppCompatActivity {

    private Storage lutemonStorage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lutemons);

        lutemonStorage = Storage.getInstance();
        recyclerView = findViewById(R.id.rvLutemonList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(), lutemonStorage.getLutemons()));

    }




    public void moveLutemons(View view) {

        RadioGroup rg = findViewById(R.id.radioGroup2);

        switch(rg.getCheckedRadioButtonId()){

            case R.id.rbTrainingArea:
                for (Lutemon l : Storage.getInstance().getMovingLutemons()){
                    Storage.getInstance().addLutemonToTrainingArea(l);
                }

            case R.id.rbFightingArea:
                for (Lutemon l : Storage.getInstance().getMovingLutemons()){
                    Storage.getInstance().addLutemonToBattleField(l);
                }

        }




        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
