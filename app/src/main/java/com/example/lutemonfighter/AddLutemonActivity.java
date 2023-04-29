package com.example.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddLutemonActivity extends AppCompatActivity {

    private Context context;
    private EditText lutemonName;
    private RadioGroup rg, rgIcons;
    private String color;
    private int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        context = this;
        lutemonName = findViewById(R.id.editTextLutemonName);
        rg = findViewById(R.id.rgChooseColor);
        rgIcons = findViewById(R.id.rgIcons);

    }


    public void createLutemon(View view) {

        switch (rgIcons.getCheckedRadioButtonId()) {

            case R.id.rbCrab:
                image = R.drawable.crab_icon;
                break;

            case R.id.rbFrog:
                image = R.drawable.frog_icon;
                break;

            case R.id.rbMonkey:
                image = R.drawable.monkey_icon;
                break;

            case R.id.rbPig:
                image = R.drawable.pig_icon;
                break;

            case R.id.rbPlatypus:
                image = R.drawable.platypus_icon;
                break;
        }

        switch (rg.getCheckedRadioButtonId()) {

            case R.id.rbWhite:
                color = "Valkoinen";
                White white = new White(color, lutemonName.getText().toString(), image);
                Storage.getInstance().addLutemon(white);
                break;
            case R.id.rbGreen:
                color = "Vihreä";
                Green green = new Green(color, lutemonName.getText().toString(), image);
                Storage.getInstance().addLutemon(green);
                break;

            case R.id.rbPink:
                color = "Pinkki";
                Pink pink = new Pink(color, lutemonName.getText().toString(), image);
                Storage.getInstance().addLutemon(pink);
                break;

            case R.id.rbOrange:
                color = "Oranssi";
                Orange orange = new Orange(color, lutemonName.getText().toString(), image);
                Storage.getInstance().addLutemon(orange);
                break;

            case R.id.rbBlack:
                color = "Musta";
                Black black = new Black(color, lutemonName.getText().toString(), image);
                Storage.getInstance().addLutemon(black);
                break;
        }


        // Switching back to the main page
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        Storage.getInstance().listLutemons();

    }


}