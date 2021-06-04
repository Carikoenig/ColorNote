package com.example.myfirstapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;

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


    /*public void play(View view) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.cnote);
           /* player.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                @Override
                public void onCompletion(MediaPlayer mp){
                    stopPlayer();
                }
            });
        }
    }*/


}