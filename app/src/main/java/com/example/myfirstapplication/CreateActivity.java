package com.example.myfirstapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {
    //MediaPlayer player;  wir brauchen mehr als nur einen...



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);

        //Speicher der Aufnahme bis alles aufgenommen ist
        //int List[] neuesLied = new List[];

        //Was das Start auslöst:
        Button start_Btn = (Button) findViewById(R.id.rec_tBtn);
        start_Btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                //was am Ende der Aufnahme geschieht:
                if (getText(R.id.rec_tBtn).equals("end")) {

                }
            }
        });

        //Was das C1 auslöst:
        Button C1_Btn = (Button) findViewById(R.id.C1_Btn);
        C1_Btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                //bei CreateModus
                if(MainActivity.modus == 1) {
                    //ein neues Element wird zum Speicher hinzu gefügt
                    if(getText(R.id.rec_tBtn).equals("end")){
                        //neuesLied.
                    }
                }
                //bei PlayModus
                else if(MainActivity.modus >= 10){

                }
            }
        });
    }

    public void playc(View v) {
        final MediaPlayer cNoteMP = MediaPlayer.create(this, R.raw.cgross);
        cNoteMP.start();
        cNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

            public void onCompletion(MediaPlayer mp){
                mp.release();
            }
        });

    }

    public void playd(View v) {
        final MediaPlayer dNoteMP = MediaPlayer.create(this, R.raw.dgross);
        dNoteMP.start();
        dNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    public void playe(View v) {
        final MediaPlayer eNoteMP = MediaPlayer.create(this, R.raw.egross);
        eNoteMP.start();
        eNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    public void playf(View v) {
        final MediaPlayer fNoteMP = MediaPlayer.create(this, R.raw.fgross);
        fNoteMP.start();
        fNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    public void playg(View v) {
        final MediaPlayer gNoteMP = MediaPlayer.create(this, R.raw.ggross);
        gNoteMP.start();
        gNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });


    }

    public void playa(View v) {
        final MediaPlayer aNoteMP = MediaPlayer.create(this, R.raw.agross);
        aNoteMP.start();
        aNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });


    }

    public void playh(View v) {
        final MediaPlayer hNoteMP = MediaPlayer.create(this, R.raw.hgross);
        hNoteMP.start();
        hNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });


    }

    public void playc2(View v) {
        final MediaPlayer c2NoteMP = MediaPlayer.create(this, R.raw.c);
        c2NoteMP.start();
        c2NoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });


    }

    public void playd2(View v) {
        final MediaPlayer d2NoteMP = MediaPlayer.create(this, R.raw.d);
        d2NoteMP.start();
        d2NoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }



    }