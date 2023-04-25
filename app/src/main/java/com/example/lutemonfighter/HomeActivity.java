package com.example.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class HomeActivity extends AppCompatActivity {

    private Context context;
    private EditText lutemonName;
    private RadioGroup rg;
    private String color;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = this;
        lutemonName = findViewById(R.id.editTextLutemonName);
        rg = findViewById(R.id.radioGroup);
    }


    public void createLutemon(View view){

        switch (rg.getCheckedRadioButtonId()){

            case R.id.rbWhite:
                color = "Valkoinen";
                Lutemon lutemon = new White(color, lutemonName.getText().toString());
                break;
            case R.id.rbGreen:

                break;
            case R.id.rbPink:
                break;

            case R.id.rbOrange:
                break;

            case R.id.rbBlack:
                break;

        }

        Storage.getInstance().addLutemon(lutemon);
    }
}