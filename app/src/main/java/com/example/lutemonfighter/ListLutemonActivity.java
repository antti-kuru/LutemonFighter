package com.example.lutemonfighter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
