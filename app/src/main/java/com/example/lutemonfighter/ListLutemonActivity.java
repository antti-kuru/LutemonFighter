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
    private RecyclerView rvTrainingArea;
    private RecyclerView rvBattleField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lutemons);

        lutemonStorage = Storage.getInstance();

        recyclerView = findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(), lutemonStorage.getLutemons()));

        rvTrainingArea = findViewById(R.id.rvLutemonTrainingArea);
        rvTrainingArea.setLayoutManager(new LinearLayoutManager(this));
        rvTrainingArea.setAdapter(new LutemonListAdapter(getApplicationContext(), lutemonStorage.getLutemonsInTrainingArea()));

        rvBattleField = findViewById(R.id.rvLutemonBattleField);
        rvBattleField.setLayoutManager(new LinearLayoutManager(this));
        rvBattleField.setAdapter(new LutemonListAdapter(getApplicationContext(), lutemonStorage.getLutemonsInBattleField()));

    }


    public void moveLutemons(View view) {

        RadioGroup rg = findViewById(R.id.rgMoveLutemons);

        switch (rg.getCheckedRadioButtonId()) {

            /* To avoid duplicates we first remove the lutemon from every list and then add it to
            the destination chosen by the user */
            case R.id.rbTrainingArea:
                for (Lutemon l : Storage.getInstance().getMovingLutemons()) {
                    Storage.getInstance().getLutemons().remove(l);
                    Storage.getInstance().getLutemonsInBattleField().remove(l);
                    Storage.getInstance().getLutemonsInTrainingArea().remove(l);
                    Storage.getInstance().addLutemonToTrainingArea(l);

                }
                break;
            case R.id.rbFightingArea:
                for (Lutemon l : Storage.getInstance().getMovingLutemons()) {
                    Storage.getInstance().getLutemons().remove(l);
                    Storage.getInstance().getLutemonsInTrainingArea().remove(l);
                    Storage.getInstance().getLutemonsInBattleField().remove(l);
                    Storage.getInstance().addLutemonToBattleField(l);
                }
                break;
            case R.id.rbHome:
                for (Lutemon l : Storage.getInstance().getMovingLutemons()) {
                    Storage.getInstance().getLutemonsInTrainingArea().remove(l);
                    Storage.getInstance().getLutemonsInBattleField().remove(l);
                    Storage.getInstance().getLutemons().remove(l);
                    Storage.getInstance().addLutemon(l);
                }
                break;
        }
        Storage.getInstance().getMovingLutemons().clear();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
