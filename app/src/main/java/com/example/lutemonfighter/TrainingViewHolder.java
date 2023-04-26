package com.example.lutemonfighter;

import android.view.View;
import android.widget.Button;
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
        checkBox = itemView.findViewById(R.id.cbChoose);
        lutemonNameAndColor2 = itemView.findViewById(R.id.txtLutemonNameAndColor2);
        //constraintLayout = itemView.findViewById(R.id.constraintLayout);
    }
}