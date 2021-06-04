package com.example.myfirstapplication;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myfirstapplication.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateActivity extends AppCompatActivity {
    //MediaPlayer player;  wir brauchen mehr als nur einen...



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_keyboard);

        //Speicher der Aufnahme bis alles aufgenommen ist
        //int List[] neuesLied = new List[];

        //Was das Start auslöst:
        Button start_Btn = (Button) findViewById(R.id.rec_tBtn);
        start_Btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                makeAFile();
                //was am Ende der Aufnahme geschieht:
                if (getText(R.id.rec_tBtn).equals("end")) {

                }
            }
        });

        Button playc = (Button) findViewById(R.id.C1_Btn);
        playc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playc(playc);


            }
        });

        Button playd = (Button) findViewById(R.id.D1_Btn);
        playd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playd(playd);


            }
        });

        Button playe = (Button) findViewById(R.id.E_Btn);
        playe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playe(playe);
            }
        });

        Button playf = (Button) findViewById(R.id.F_Btn);
        playf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playf(playf);
            }
        });

        Button playg = (Button) findViewById(R.id.G_Btn);
        playg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playg(playg);
            }
        });

        Button playa = (Button) findViewById(R.id.A_Btn);
        playa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playa(playa);
            }
        });

        Button playh = (Button) findViewById(R.id.H_Btn);
        playh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playh(playh);
            }
        });

        Button playc2 = (Button) findViewById(R.id.C2_Btn);
        playc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playc2(playc2);
            }
        });

        Button playd2 = (Button) findViewById(R.id.D2_Btn);
        playd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playd2(playd2);
            }
        });









/*        //Was das C1 auslöst:
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
*/    }


    public void makeAFile() {
        File Notenblatt = new File(CreateActivity.this.getFilesDir(), "notenblatt.txt");
        if (!Notenblatt.exists()){
            Notenblatt.mkdir();
        }
        try {
            FileOutputStream fOut = openFileOutput("notenblatt.txt", MODE_PRIVATE);
            fOut.write(Integer.parseInt("test"));
            fOut.close();
            File fileDir = new File (getFilesDir(), "notenblatt.txt");
            Toast.makeText(getBaseContext(), "Testfile saved at "+fileDir, Toast.LENGTH_SHORT).show();

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }




    public void playc(View v) {
        Long time = System.currentTimeMillis();
        final MediaPlayer cNoteMP = MediaPlayer.create(this, R.raw.cgross);
        cNoteMP.start();
        cNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

            public void onCompletion(MediaPlayer mp){
                mp.release();
            }
        });

        String timestr = Long.toString(time);
        String NotezumSpeichern = "c"+timestr;
        //fOut.write(NotezumSpeichern.getBytes());



        Toast.makeText(getApplicationContext(),NotezumSpeichern,Toast.LENGTH_SHORT).show();
    }

    public void playd(View v) {
        Long time = System.currentTimeMillis();
        final MediaPlayer dNoteMP = MediaPlayer.create(this, R.raw.dgross);
        dNoteMP.start();
        dNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

        String timestr = Long.toString(time);
        String NotezumSpeichern = "d"+timestr;

        Toast.makeText(getApplicationContext(),NotezumSpeichern,Toast.LENGTH_SHORT).show();    }

    public void playe(View v) {
        Long time = System.currentTimeMillis();
        final MediaPlayer eNoteMP = MediaPlayer.create(this, R.raw.egross);
        eNoteMP.start();
        eNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
        String timestr = Long.toString(time);
        String NotezumSpeichern = "e"+timestr;

        Toast.makeText(getApplicationContext(), NotezumSpeichern,Toast.LENGTH_SHORT).show();
    }

    public void playf(View v) {
        Long time = System.currentTimeMillis();
        final MediaPlayer fNoteMP = MediaPlayer.create(this, R.raw.fgross);
        fNoteMP.start();
        fNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

        String timestr = Long.toString(time);
        String NotezumSpeichern = "f"+timestr;

        Toast.makeText(getApplicationContext(),NotezumSpeichern,Toast.LENGTH_SHORT).show();
    }

    public void playg(View v) {
        Long time = System.currentTimeMillis();
        final MediaPlayer gNoteMP = MediaPlayer.create(this, R.raw.ggross);
        gNoteMP.start();
        gNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

        String timestr = Long.toString(time);
        String NotezumSpeichern = "g"+timestr;

        Toast.makeText(getApplicationContext(),NotezumSpeichern,Toast.LENGTH_SHORT).show();


    }

    public void playa(View v) {
        Long time = System.currentTimeMillis();
        final MediaPlayer aNoteMP = MediaPlayer.create(this, R.raw.agross);
        aNoteMP.start();
        aNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

        String timestr = Long.toString(time);
        String NotezumSpeichern = "a"+timestr;


        Toast.makeText(getApplicationContext(),"a"+Long.toString(time),Toast.LENGTH_SHORT).show();


    }

    public void playh(View v) {
        Long time = System.currentTimeMillis();
        final MediaPlayer hNoteMP = MediaPlayer.create(this, R.raw.hgross);
        hNoteMP.start();
        hNoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

        String timestr = Long.toString(time);
        String NotezumSpeichern = "h"+timestr;

        Toast.makeText(getApplicationContext(),"h"+Long.toString(time),Toast.LENGTH_SHORT).show();


    }

    public void playc2(View v) {
        Long time = System.currentTimeMillis();
        final MediaPlayer c2NoteMP = MediaPlayer.create(this, R.raw.c);
        c2NoteMP.start();
        c2NoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

        String timestr = Long.toString(time);
        String NotezumSpeichern = "cz"+timestr;

        Toast.makeText(getApplicationContext(),"cz"+Long.toString(time),Toast.LENGTH_SHORT).show();


    }

    public void playd2(View v) {
        Long time = System.currentTimeMillis();
        final MediaPlayer d2NoteMP = MediaPlayer.create(this, R.raw.d);
        d2NoteMP.start();
        d2NoteMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

        String timestr = Long.toString(time);
        String NotezumSpeichern = "dz"+timestr;

        Toast.makeText(getApplicationContext(),"dz"+Long.toString(time),Toast.LENGTH_SHORT).show();
    }

    public void fileSpeichern(View v) throws IOException {
        //fOut.close();
        String hi = "hi";

    }


    }