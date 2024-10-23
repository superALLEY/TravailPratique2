package com.example.unidirectionalapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView welcomeMessage = findViewById(R.id.welcomeMessage);

        // Retrieve the name sent from MainActivity
        String name = getIntent().getStringExtra("USER_NAME");
        if (name == null) {
            name = "Guest"; // Default name if none provided
        }

        // Set the welcome message using a string resource
        welcomeMessage.setText(getString(R.string.welcome_message, name));
    }
}
