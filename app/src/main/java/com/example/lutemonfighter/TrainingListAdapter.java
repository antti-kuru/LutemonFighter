package com.example.lutemonfighter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrainingListAdapter extends RecyclerView.Adapter<TrainingViewHolder> {
    protected Context context;
    protected ArrayList<Lutemon> lutemons = new ArrayList<>();

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
        holder.trainingMethod.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
