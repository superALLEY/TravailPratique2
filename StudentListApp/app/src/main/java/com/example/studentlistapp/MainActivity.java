package com.example.studentlistapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView studentListView;
    private String[] studentNames = {"Thomas", "André", "Jacques", "Pierre"};
    private int[] studentScores = {94, 70, 60, 45};

    private String[] messages = {
            "Excellent Thomas, you passed the course!",
            "Well done André, you passed the course!",
            "Passable, Jacques, but you still passed the course.",
            "Sorry Pierre, you failed the course."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentListView = findViewById(R.id.studentListView);

        // Create and set the adapter
        StudentAdapter adapter = new StudentAdapter(this, studentNames, studentScores);
        studentListView.setAdapter(adapter);

        // Set click listener for the ListView items
        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Display a toast with the message based on the student's score
                Toast.makeText(MainActivity.this, messages[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
