package com.example.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    private Button buttonPlay;

    //0 -> Startbildschirm
    //1 -> Create
    //10 aufwärts -> Play (Stücke)
    public static int modus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);


    }
    /*
    //Show existingfiles leitet auf newPlay activity um
    public void launchPlay(View v){
        //launch a new activity (specifically in this case the output mode) when clicking on the Play button
        Intent gotoKeyboard1 = new Intent(this, Play_Activity.class);
        startActivity(gotoKeyboard1);
        modus = 10;
    }

     */

    public void launchCreate(View v){
        //launch a new activity (specifically in this case the input mode) when clicking on the Create button
        Intent gotoKeyboard = new Intent(this, CreateActivity.class);
        startActivity(gotoKeyboard);
        modus = 1;
    }


    public void launchHandbuch(View v){
        //launch the Handbuch activity
        Intent handbuch = new Intent(this, HandbActivity.class);
        startActivity(handbuch);
    }

    public void launchFrei(View v){
        //launch the FreiActivity
        Intent frei = new Intent(this, FreiActivity.class);
        startActivity(frei);
    }

    public void launchShowExistingFiles(View v){
        //launch the ExistingFilesActivity
        Intent existingFiles = new Intent(this, ShowExistingFiles_Activity.class);
        startActivity(existingFiles);
    }


}