package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup[] questionGroups = new RadioGroup[5];
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RadioGroups for the questions
        questionGroups[0] = findViewById(R.id.questionGroup1);
        questionGroups[1] = findViewById(R.id.questionGroup2);
        questionGroups[2] = findViewById(R.id.questionGroup3);
        questionGroups[3] = findViewById(R.id.questionGroup4);
        questionGroups[4] = findViewById(R.id.questionGroup5);

        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] answers = new int[5];

                for (int i = 0; i < 5; i++) {
                    int selectedId = questionGroups[i].getCheckedRadioButtonId();
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    answers[i] = questionGroups[i].indexOfChild(selectedRadioButton);
                }

                // Send answers to ResultActivity
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("ANSWERS", answers);
                intent.putExtra("MODIFICATIONS_LEFT", 3);
                startActivity(intent);
            }
        });
    }
}
