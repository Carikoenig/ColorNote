package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchPlay(View v){
        //launch a new activity (specifically in this case the output mode) when clicking on the Play button
        Intent i = new Intent(this, PlayActivity.class);
        startActivity(i);
    }

    public void launchCreate(View v){
        //launch a new activity (specifically in this case the input mode) when clicking on the Create button
        Intent i = new Intent(this, CreateActivity.class);
        startActivity(i);
    }
}