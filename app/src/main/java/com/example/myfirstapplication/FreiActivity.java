package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FreiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_frei);

        Button playc = (Button) findViewById(R.id.CBut);
        playc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playc(playc);


            }
        });

        Button playcis = (Button) findViewById(R.id.cis);
        playcis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playcis(playcis);


            }
        });

        Button playd = (Button) findViewById(R.id.DBut);
        playd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playd(playd);


            }
        });

        Button playdis = (Button) findViewById(R.id.dis);
        playdis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playdis(playdis);


            }
        });

        Button playe = (Button) findViewById(R.id.EBut);
        playe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playe(playe);
            }
        });

        Button playf = (Button) findViewById(R.id.FBut);
        playf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playf(playf);
            }
        });

        Button playfis = (Button) findViewById(R.id.fis);
        playfis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playfis(playfis);


            }
        });

        Button playg = (Button) findViewById(R.id.GBut);
        playg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playg(playg);
            }
        });

        Button playgis = (Button) findViewById(R.id.gis);
        playgis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playgis(playgis);


            }
        });

        Button playa = (Button) findViewById(R.id.ABut);
        playa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playa(playa);
            }
        });


        Button playb = (Button) findViewById(R.id.bnote);
        playb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playb(playb);


            }
        });


        Button playh = (Button) findViewById(R.id.HBut);
        playh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playh(playh);
            }
        });

        Button playc2 = (Button) findViewById(R.id.C2But);
        playc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playc2(playc2);
            }
        });

        Button playcis2 = (Button) findViewById(R.id.cis2);
        playcis2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playcis2(playcis2);


            }
        });

        Button playd2 = (Button) findViewById(R.id.D2But);
        playd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playd2(playd2);
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

    public void playcis(View v) {
        final MediaPlayer cisNoteMP = MediaPlayer.create(this, R.raw.cis);
        cisNoteMP.start();
        cisNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

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

    public void playdis(View v) {
        final MediaPlayer disNoteMP = MediaPlayer.create(this, R.raw.dis);
        disNoteMP.start();
        disNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

            public void onCompletion(MediaPlayer mp){
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

    public void playfis(View v) {
        final MediaPlayer fisNoteMP = MediaPlayer.create(this, R.raw.fis);
        fisNoteMP.start();
        fisNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

            public void onCompletion(MediaPlayer mp){
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

    public void playgis(View v) {
        final MediaPlayer gisNoteMP = MediaPlayer.create(this, R.raw.gis);
        gisNoteMP.start();
        gisNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

            public void onCompletion(MediaPlayer mp){
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

   public void playb(View v) {
        final MediaPlayer bNoteMP = MediaPlayer.create(this, R.raw.ais);
        bNoteMP.start();
        bNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

            public void onCompletion(MediaPlayer mp){
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

    public void playcis2(View v) {
        final MediaPlayer cis2NoteMP = MediaPlayer.create(this, R.raw.cis2);
        cis2NoteMP.start();
        cis2NoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

            public void onCompletion(MediaPlayer mp){
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