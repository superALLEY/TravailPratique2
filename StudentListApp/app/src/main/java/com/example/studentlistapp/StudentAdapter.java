package com.example.studentlistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class StudentAdapter extends BaseAdapter {

    private Context context;
    private String[] studentNames;
    private int[] studentScores;

    public StudentAdapter(Context context, String[] studentNames, int[] studentScores) {
        this.context = context;
        this.studentNames = studentNames;
        this.studentScores = studentScores;
    }

    @Override
    public int getCount() {
        return studentNames.length;
    }

    @Override
    public Object getItem(int position) {
        return studentNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_student, parent, false);
        }

        TextView studentNameTextView = convertView.findViewById(R.id.studentNameTextView);
        TextView studentScoreTextView = convertView.findViewById(R.id.studentScoreTextView);

        studentNameTextView.setText(studentNames[position]);
        studentScoreTextView.setText(String.valueOf(studentScores[position]));

        return convertView;
    }
}
