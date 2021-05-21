package com.example.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //0 -> Startbildschirm
    //1 -> Create
    //10 aufwärts -> Play (Stücke)
    public static int modus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchPlay(View v){
        //launch a new activity (specifically in this case the output mode) when clicking on the Play button
        Intent gotoKeyboard = new Intent(this, CreateActivity.class);
        startActivity(gotoKeyboard);
        modus = 10;
    }

    public void launchCreate(View v){
        //launch a new activity (specifically in this case the input mode) when clicking on the Create button
        Intent gotoKeyboard = new Intent(this, CreateActivity.class);
        startActivity(gotoKeyboard);
        modus = 1;
    }

}