package com.example.lutemonfighter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BattleFieldListAdapter extends RecyclerView.Adapter<BattleFieldViewHolder> {

    protected Context context;
    protected ArrayList<Lutemon> lutemons = new ArrayList<>();

    public BattleFieldListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public BattleFieldViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BattleFieldViewHolder(LayoutInflater.from(context).inflate(R.layout.battlefield_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BattleFieldViewHolder holder, int position) {
        holder.lutemonNameAndColor.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");

        // Check if user selects any lutemons to battle
        holder.checkBox.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            if (holder.checkBox.isChecked()) {
                Storage.getInstance().addMovingLutemon(lutemons.get(pos));
            }
        });

    }
    @Override
    public int getItemCount () {
        return lutemons.size();
    }
}