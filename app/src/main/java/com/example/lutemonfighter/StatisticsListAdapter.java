package com.example.lutemonfighter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StatisticsListAdapter extends RecyclerView.Adapter<StatisticsViewHolder> {

    protected Context context;
    protected ArrayList<Lutemon> lutemons = new ArrayList<>();

    public StatisticsListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public StatisticsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StatisticsViewHolder(LayoutInflater.from(context).inflate(R.layout.statistics_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StatisticsViewHolder holder, int position) {
        holder.lutemonNameAndColor.setText(lutemons.get(position).getName() + "(" + lutemons.get(position).getColor() + ")");
        holder.lutemonAttack.setText("Hyökkäys: " + lutemons.get(position).getAttack());
        holder.lutemonDefense.setText("Puolustus: " + lutemons.get(position).getDefence());
        holder.lutemonHealth.setText("Elämäpisteet: " + lutemons.get(position).getHealth() + "/" + lutemons.get(position).getMaxHealth());
        holder.lutemonExperience.setText("Kokemuspisteet: " + lutemons.get(position).getExperience());
        holder.lutemonWins.setText("Voitot: " + lutemons.get(position).getWins());
        holder.lutemonLosses.setText("Häviöt: " + (lutemons.get(position).getFights() - lutemons.get(position).getWins()));
        holder.lutemonBattles.setText("Ottelut: " + lutemons.get(position).getFights());
        holder.lutemonTrainings.setText("Treenikerrat: " + lutemons.get(position).getTrainingSessions());
        // holder.lutemonPicture.setImageResource(lutemons.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
