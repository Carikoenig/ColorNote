package com.example.myfirstapplication;

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
        setContentView(R.layout.activity_keyboard_create);

        /*final MediaPlayer cNoteMP = MediaPlayer.create(this, R.raw.cnote);

        Button playCNote = (Button) this.findViewById(R.id.CBtn);

        playCNote.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cNoteMP.start();
            }
        });

        final MediaPlayer dNoteMP = MediaPlayer.create(this, R.raw.dnote);

        Button playDNote = (Button) this.findViewById(R.id.DBtn);

        playCNote.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dNoteMP.start();
            }
        }); */
    }

    public void playc(View v) {
        final MediaPlayer cNoteMP = MediaPlayer.create(this, R.raw.cnote);
        cNoteMP.start();
        cNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

            public void onCompletion(MediaPlayer mp){
                mp.release();
            }
        });

    }

    public void playd(View v) {
        final MediaPlayer dNoteMP = MediaPlayer.create(this, R.raw.dnote);
        dNoteMP.start();
        dNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    public void playe(View v) {
        final MediaPlayer eNoteMP = MediaPlayer.create(this, R.raw.enote);
        eNoteMP.start();
        eNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    public void playf(View v) {
        final MediaPlayer fNoteMP = MediaPlayer.create(this, R.raw.fnote);
        fNoteMP.start();
        fNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    public void playg(View v) {
        final MediaPlayer gNoteMP = MediaPlayer.create(this, R.raw.gnote);
        gNoteMP.start();
        gNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });


    }

    public void playa(View v) {
        final MediaPlayer aNoteMP = MediaPlayer.create(this, R.raw.anote);
        aNoteMP.start();
        aNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });


    }

    public void playh(View v) {
        final MediaPlayer hNoteMP = MediaPlayer.create(this, R.raw.hnote);
        hNoteMP.start();
        hNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });


    }

    public void playc2(View v) {
        final MediaPlayer c2NoteMP = MediaPlayer.create(this, R.raw.c2note);
        c2NoteMP.start();
        c2NoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });


    }

    public void playd2(View v) {
        final MediaPlayer d2NoteMP = MediaPlayer.create(this, R.raw.c2note);
        d2NoteMP.start();
        d2NoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }



    }