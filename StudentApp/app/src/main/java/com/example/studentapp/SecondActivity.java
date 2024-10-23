package com.example.studentapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView resultMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        resultMessage = findViewById(R.id.resultMessage);

        // Retrieve the Student object from the Intent
        Student student = (Student) getIntent().getSerializableExtra("STUDENT");

        // Calculate age and generate messages based on age
        int age = student.getAge();
        StringBuilder message = new StringBuilder();

        message.append("Hello ").append(student.getFirstName()).append(" ").append(student.getLastName()).append(", ")
                .append("Welcome to the Mobile 1 course!\n\n");

        message.append("Your specialty is ").append(student.getSpecialty()).append(".\n");

        if (age > 18) {
            message.append("You are eligible to vote.\n");
        }
        if (age > 15) {
            message.append("You can participate in individual sports.\n");
        }
        if (age > 17) {
            message.append("You can rent a car on campus.\n");
        }
        if (age > 21) {
            message.append("You can apply for a student bank loan.\n");
        }

        // Display the message
        resultMessage.setText(message.toString());
    }
}
