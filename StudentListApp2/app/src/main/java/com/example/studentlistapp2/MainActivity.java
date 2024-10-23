package com.example.studentlistapp2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView studentListView;
    private String[] studentNames = {"Thomas", "André", "Jacques", "Pierre"};
    private int[] studentScores = {94, 70, 60, 45};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentListView = findViewById(R.id.studentListView);

        // Create and set the adapter
        StudentAdapter adapter = new StudentAdapter(this, studentNames, studentScores);
        studentListView.setAdapter(adapter);

        // Set long click listener for the ListView items
        studentListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Change the background color of the long-clicked item to blue
                view.setBackgroundColor(Color.BLUE);
                return true; // Return true to indicate that the long-click event has been handled
            }
        });
    }
}
