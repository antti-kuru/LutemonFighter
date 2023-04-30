package com.example.lutemonfighter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrainingListAdapter extends RecyclerView.Adapter<TrainingViewHolder> {

    protected Context context;
    protected ArrayList<Lutemon> lutemons;

    public TrainingListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public TrainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TrainingViewHolder(LayoutInflater.from(context).inflate(R.layout.training_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingViewHolder holder, int position) {
        holder.nameAndColor.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");

        // Check if user selects any lutemons to train
        holder.checkBox.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            if (holder.checkBox.isChecked()) {
                Storage.getInstance().addMovingLutemon(lutemons.get(pos));
            }
        });
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}