package com.cuizheng.justpickone;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChoiceAdapter extends RecyclerView.Adapter<ChoiceAdapter.ChoiceViewHolder> {

    private List<String> choices;
    private List<Integer> choicesColors;

    public ChoiceAdapter(List<String> choices, List<Integer> choicesColors) {
        this.choices = choices;
        this.choicesColors = choicesColors;
    }

    @NonNull
    @Override
    public ChoiceAdapter.ChoiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_choice, parent, false);
        return new ChoiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChoiceAdapter.ChoiceViewHolder holder, int position) {
        holder.choiceNameText.setText(choices.get(position));
        holder.choiceCard.setBackgroundColor(choicesColors.get(position));
    }

    @Override
    public int getItemCount() {
        return choices.size();
    }

    public class ChoiceViewHolder extends RecyclerView.ViewHolder {

        TextView choiceNameText;
        CardView choiceCard;
        View itemView;

        public ChoiceViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            choiceNameText = itemView.findViewById(R.id.choice_name_text);
            choiceCard = itemView.findViewById(R.id.choice_card);
        }
    }
}
