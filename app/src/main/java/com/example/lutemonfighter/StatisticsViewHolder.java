package com.example.lutemonfighter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StatisticsViewHolder extends RecyclerView.ViewHolder {

    ImageView lutemonPicture;
    TextView lutemonNameAndColor, lutemonAttack, lutemonDefence;
    TextView lutemonHealth, lutemonExperience, lutemonWins;
    TextView lutemonLosses, lutemonBattles, lutemonTrainings;

    public StatisticsViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonPicture = itemView.findViewById(R.id.imageDefaultIcon);
        lutemonNameAndColor = itemView.findViewById(R.id.statsNameAndColor);
        lutemonAttack = itemView.findViewById(R.id.statsAttack);
        lutemonDefence = itemView.findViewById(R.id.statsDefence);
        lutemonHealth = itemView.findViewById(R.id.statsHealthPoints);
        lutemonExperience = itemView.findViewById(R.id.statsExperiencePoints);
        lutemonWins = itemView.findViewById(R.id.statsBattlesWon);
        lutemonLosses = itemView.findViewById(R.id.statsBattlesLost);
        lutemonBattles = itemView.findViewById(R.id.statsBattlingSessions);
        lutemonTrainings = itemView.findViewById(R.id.statsTrainingSessions);
    }
}
