package com.example.lutemonfighter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class TrainingViewHolder extends RecyclerView.ViewHolder {

    CheckBox checkBox;
    TextView lutemonNameAndColor2;


    ConstraintLayout constraintLayout;

    public TrainingViewHolder(@NonNull View itemView) {
        super(itemView);
        checkBox = itemView.findViewById(R.id.cbChooseLutemonsToTrain);
        lutemonNameAndColor2 = itemView.findViewById(R.id.txtLutemonAtTraining);
        //constraintLayout = itemView.findViewById(R.id.constraintLayout);
    }
}