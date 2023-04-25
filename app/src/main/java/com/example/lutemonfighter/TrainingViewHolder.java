package com.example.lutemonfighter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrainingViewHolder extends RecyclerView.ViewHolder {

    CheckBox checkBox;
    TextView trainingMethod;

    public TrainingViewHolder(@NonNull View itemView) {
        super(itemView);
        checkBox = itemView.findViewById(R.id.cbChoose);
        trainingMethod = itemView.findViewById(R.id.txtLutemonNameAndColor2);
    }
}