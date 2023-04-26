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
    Button btnTrainLutemon;
    TextView lutemonNameAndColor2;
    TextView tvFirst;
    TextView tvSecond;
    TextView tvThird;
    TextView tvFourth;
    TextView tvFifth;
    TextView tvResult;

    ConstraintLayout constraintLayout;

    public TrainingViewHolder(@NonNull View itemView) {
        super(itemView);
        tvFirst = itemView.findViewById(R.id.tvFirstEx);
        tvSecond = itemView.findViewById(R.id.tvSecondEx);
        tvThird = itemView.findViewById(R.id.tvThirdEx);
        tvFourth = itemView.findViewById(R.id.tvFourthEx);
        tvFifth = itemView.findViewById(R.id.tvFifthEx);
        tvResult = itemView.findViewById(R.id.tvResult);
        btnTrainLutemon = itemView.findViewById(R.id.btnTrainLutemon);

        checkBox = itemView.findViewById(R.id.cbChoose);
        lutemonNameAndColor2 = itemView.findViewById(R.id.txtLutemonNameAndColor2);
        constraintLayout = itemView.findViewById(R.id.constrainLayout);
    }
}