package com.example.cambridgescoreconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SelectLevel extends AppCompatActivity {

    String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_level);
        Intent intent = getIntent();
        message = intent.getStringExtra("level");
    }

    public void sendToComplete(View view) {
        Intent intentConverter = new Intent(this, ComplexConverter.class);
        intentConverter.putExtra("levelSecond", message);
        startActivity(intentConverter);
    }

    public void sendToBasic(View view) {
        Intent intentConverter = new Intent(this, BasicConverter.class);
        intentConverter.putExtra("levelSecond", message);
        startActivity(intentConverter);
    }
}