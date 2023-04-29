package com.example.lutemonfighter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrainingViewHolder extends RecyclerView.ViewHolder {

    CheckBox checkBox;
    TextView nameAndColor;

    public TrainingViewHolder(@NonNull View itemView) {
        super(itemView);
        checkBox = itemView.findViewById(R.id.cbChooseLutemonsToTrain);
        nameAndColor = itemView.findViewById(R.id.txtLutemonsAtTrainingArea);
    }
}