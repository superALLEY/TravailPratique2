package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private int[] correctAnswers = {0, 1, 2, 0, 1};  // Correct answer indices for each question
    private TextView resultTextView;
    private Button modifyAnswersButton;
    private int modificationsLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = findViewById(R.id.resultTextView);
        modifyAnswersButton = findViewById(R.id.modifyAnswersButton);

        Intent intent = getIntent();
        int[] userAnswers = intent.getIntArrayExtra("ANSWERS");
        modificationsLeft = intent.getIntExtra("MODIFICATIONS_LEFT", 3);

        // Display the results
        displayResults(userAnswers);

        modifyAnswersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (modificationsLeft > 0) {
                    // Allow the user to modify their answers
                    Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                    intent.putExtra("MODIFICATIONS_LEFT", modificationsLeft - 1);
                    startActivity(intent);
                } else {
                    modifyAnswersButton.setEnabled(false);
                    resultTextView.setText("No more modifications allowed.");
                }
            }
        });
    }

    private void displayResults(int[] userAnswers) {
        StringBuilder result = new StringBuilder();
        int score = 0;

        for (int i = 0; i < correctAnswers.length; i++) {
            if (userAnswers[i] == correctAnswers[i]) {
                result.append("Question ").append(i + 1).append(": Correct\n");
                score++;
            } else {
                result.append("Question ").append(i + 1).append(": Incorrect\n");
            }
        }

        result.append("\nScore: ").append(score).append("/5\n");
        result.append("Modifications left: ").append(modificationsLeft);

        resultTextView.setText(result.toString());
    }
}
