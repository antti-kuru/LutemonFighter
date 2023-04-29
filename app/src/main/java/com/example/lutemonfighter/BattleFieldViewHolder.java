package com.example.lutemonfighter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BattleFieldViewHolder extends RecyclerView.ViewHolder {
    CheckBox checkBox;
    TextView lutemonNameAndColor;

    public BattleFieldViewHolder(@NonNull View itemView) {
        super(itemView);
        checkBox = itemView.findViewById(R.id.cbChooseLutemonsToBattle);
        lutemonNameAndColor = itemView.findViewById(R.id.txtLutemonsAtBattlefield);
    }
}

