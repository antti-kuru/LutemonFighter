package com.example.lutemonfighter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {

    protected Context context;
    protected ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }


    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        holder.lutemonNameAndColor.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");

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
