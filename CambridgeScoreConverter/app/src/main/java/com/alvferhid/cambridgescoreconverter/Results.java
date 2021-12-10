package com.example.cambridgescoreconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        results = findViewById(R.id.textViewResults);
        Intent intent = getIntent();
        String grades = intent.getStringExtra("grades");
        results.setText(grades);
    }
}