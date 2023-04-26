package com.example.lutemonfighter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        holder.lutemonNameAndColor2.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
        System.out.println("Here");
       //holder.tvResult.setText(lutemons.get(position).getName());

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                if (holder.checkBox.isChecked()){
                    Storage.getInstance().addMovingLutemon(lutemons.get(pos));
                }
            }

        });

        holder.btnTrainLutemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Lutemon lutemon : Storage.getInstance().getMovingLutemons()){
                    TextView tv = new TextView(context);
                    tv.setText(lutemon.getName() + " treenaa kovaa");
                    tv.setText(lutemon.getName() + " vetää leukoja");
                    holder.constraintLayout.addView(tv);
                    notifyDataSetChanged();
                    System.out.println("MOI");
            }
        });



      //  holder.tvResult.setText(" suoritti treenin ja sai 2 kokemuspistettä!");

        //holder.btnTrainLutemon.setOnClickListener(view -> {
          //  holder.tvFirst.setText(lutemons.get(position).getName() + " juoksee juoksumatolla");
            //holder.tvSecond.setText(lutemons.get(position).getName() + " tekee punnerruksia");
            //holder.tvThird.setText(lutemons.get(position).getName() + " rutistaa vastalihaksia");
            //holder.tvFourth.setText(lutemons.get(position).getName() + " vetää leukoja");
            //holder.tvFifth.setText(lutemons.get(position).getName() + " tekee kyykkyjä");
            // holder.tvResult.setText(lutemons.get(position).getName() + " suoritti treenin ja sai 2 kokemuspistettä!");
        //});
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
