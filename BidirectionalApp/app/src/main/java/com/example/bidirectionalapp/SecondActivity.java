package com.example.bidirectionalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    private TextView welcomeMessage;
    private Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        welcomeMessage = findViewById(R.id.welcomeMessage);
        returnButton = findViewById(R.id.returnButton);

        // Retrieve the name sent from MainActivity
        String name = getIntent().getStringExtra("USER_NAME");
        welcomeMessage.setText("Hello " + name + ", welcome to the Mobile 1 course");

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get current time
                String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

                // Prepare the result to send back to MainActivity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("TIME_MESSAGE", "Your message was returned at " + currentTime);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
