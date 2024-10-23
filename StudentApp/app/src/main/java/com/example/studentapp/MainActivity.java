package com.example.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText firstNameInput, lastNameInput, yearOfBirthInput, specialtyInput;
    private Button sendStudentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameInput = findViewById(R.id.firstNameInput);
        lastNameInput = findViewById(R.id.lastNameInput);
        yearOfBirthInput = findViewById(R.id.yearOfBirthInput);
        specialtyInput = findViewById(R.id.specialtyInput);
        sendStudentButton = findViewById(R.id.sendStudentButton);

        sendStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameInput.getText().toString();
                String lastName = lastNameInput.getText().toString();
                int yearOfBirth = Integer.parseInt(yearOfBirthInput.getText().toString());
                String specialty = specialtyInput.getText().toString();

                // Create Student object
                Student student = new Student(firstName, lastName, yearOfBirth, specialty);

                // Send Student object to SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("STUDENT", student);
                startActivity(intent);
            }
        });
    }
}
