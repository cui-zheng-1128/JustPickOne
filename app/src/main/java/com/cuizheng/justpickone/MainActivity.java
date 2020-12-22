package com.cuizheng.justpickone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView choicesRecyclerView;
    private List<String> choices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize choices list
        choices = new ArrayList<>();

        // Create recycler view
        choicesRecyclerView = findViewById(R.id.choicesRecyclerView);
        ChoiceAdapter choiceAdapter = new ChoiceAdapter(choices);
        choicesRecyclerView.setAdapter(choiceAdapter);
        choicesRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        // Create button onClick listener
        EditText newChoiceText = findViewById(R.id.new_choice_text);
        Button addNewChoiceButton = findViewById(R.id.add_new_choice_button);
        addNewChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choices.add(newChoiceText.getText().toString());
                newChoiceText.clearComposingText();
                choiceAdapter.notifyItemChanged(choices.size() - 1);
            }
        });
    }
}