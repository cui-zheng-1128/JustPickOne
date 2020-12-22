package com.cuizheng.justpickone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView choicesRecyclerView;
    private List<String> choices;
    private List<Integer> choicesColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize choices list
        choices = new ArrayList<>();
        choicesColors = new ArrayList<>();

        // Create recycler view
        choicesRecyclerView = findViewById(R.id.choicesRecyclerView);
        ChoiceAdapter choiceAdapter = new ChoiceAdapter(choices, choicesColors);
        choicesRecyclerView.setAdapter(choiceAdapter);
        choicesRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        // Create add new choice button onClick listener
        EditText newChoiceText = findViewById(R.id.new_choice_text);
        Button addNewChoiceButton = findViewById(R.id.add_new_choice_button);
        addNewChoiceButton.setOnClickListener(v -> {
            if(!newChoiceText.getText().toString().isEmpty()){
                choices.add(newChoiceText.getText().toString());
                choicesColors.add(Color.WHITE);
                newChoiceText.getText().clear();
                choiceAdapter.notifyItemChanged(choices.size() - 1);
            }
        });

        // Create clear all button onClick listener
        Button clearAllButton = findViewById(R.id.clear_all_button);
        clearAllButton.setOnClickListener(v -> {
            if(choices.size() > 0){
                choices.clear();
                choicesColors.clear();
                choiceAdapter.notifyDataSetChanged();
            }
        });

        // Create choose button onClick listener
        Button chooseButton = findViewById(R.id.choose_button);
        chooseButton.setOnClickListener(v -> {
            if(choices.size() > 0){
                Collections.fill(choicesColors, Color.WHITE);
                int chosenItemIndex = new Random().nextInt(choices.size());
                choicesColors.set(chosenItemIndex, Color.RED);
                choiceAdapter.notifyDataSetChanged();
            }
        });
    }
}