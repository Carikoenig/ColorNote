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

      /*  buttonPlay = (Button) findViewById(R.id.play_Btn);
        buttonPlay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                launchPlay(v);
            }
        });
        */

    }

    public void launchPlay(View v){
        //launch a new activity (specifically in this case the output mode) when clicking on the Play button
        Intent gotoKeyboard1 = new Intent(this, Play_Activity.class);
        startActivity(gotoKeyboard1);
        modus = 10;
    }

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


}