package com.example.lutemonfighter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {

    CheckBox checkBox;
    TextView lutemonNameAndColor;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        checkBox = itemView.findViewById(R.id.cbChooseLutemon);
        lutemonNameAndColor = itemView.findViewById(R.id.txtLutemonNameAndColor);
    }
}
