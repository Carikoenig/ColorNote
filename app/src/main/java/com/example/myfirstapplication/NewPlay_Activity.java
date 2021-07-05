package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

public class NewPlay_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_new_play);

        TextView liednameTV = (TextView) findViewById(R.id.liednameTV);
        Intent intent = getIntent();
        String liedname = intent.getStringExtra("Lied");

        liednameTV.setText(liedname);

    }

}