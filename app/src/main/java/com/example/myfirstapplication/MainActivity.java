package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;

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