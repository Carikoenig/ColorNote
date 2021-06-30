package com.example.myfirstapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;


public class CreateActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_keyboard);


        Button start_Btn = (Button) findViewById(R.id.AufnahmeBtn);
        start_Btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                setFileToZero();

            }
        });

        Button speicherBtn = (Button) findViewById(R.id.ScpeicherBtn);
        speicherBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                makeAFile();
            }

        });

        Button deleteBtn = (Button) findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                deleteAFile();
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

    }





     /*   try {
            FileOutputStream fOut = openFileOutput("notenblatt.txt", MODE_PRIVATE);
            fOut.write(Integer.parseInt("test"));
            fOut.close();
            File fileDir = new File (getFilesDir(), "notenblatt.txt");
            Toast.makeText(getBaseContext(), "Testfile saved at "+fileDir, Toast.LENGTH_SHORT).show();

        }
        catch (IOException e){
            e.printStackTrace();
        }

    } */




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
        String NotezumSpeichern = "cQ"+timestr;
        sendNote(NotezumSpeichern);



        //Toast.makeText(getApplicationContext(),NotezumSpeichern,Toast.LENGTH_SHORT).show();
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
        String NotezumSpeichern = "dQ"+timestr;
        sendNote(NotezumSpeichern);

        //Toast.makeText(getApplicationContext(),NotezumSpeichern,Toast.LENGTH_SHORT).show();
        }

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
        String NotezumSpeichern = "eQ"+timestr;
        sendNote(NotezumSpeichern);

        //Toast.makeText(getApplicationContext(), NotezumSpeichern,Toast.LENGTH_SHORT).show();
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
        String NotezumSpeichern = "fQ"+timestr;
        sendNote(NotezumSpeichern);

        //Toast.makeText(getApplicationContext(),NotezumSpeichern,Toast.LENGTH_SHORT).show();
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
        String NotezumSpeichern = "gQ"+timestr;
        sendNote(NotezumSpeichern);

        //Toast.makeText(getApplicationContext(),NotezumSpeichern,Toast.LENGTH_SHORT).show();


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
        String NotezumSpeichern = "aQ"+timestr;
        sendNote(NotezumSpeichern);


        //Toast.makeText(getApplicationContext(),"a"+Long.toString(time),Toast.LENGTH_SHORT).show();


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
        String NotezumSpeichern = "hQ"+timestr;
        sendNote(NotezumSpeichern);

        //Toast.makeText(getApplicationContext(),"h"+Long.toString(time),Toast.LENGTH_SHORT).show();


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
        String NotezumSpeichern = "czQ"+timestr;
        sendNote(NotezumSpeichern);

       // Toast.makeText(getApplicationContext(),"cz"+Long.toString(time),Toast.LENGTH_SHORT).show();


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
        String NotezumSpeichern = "dzQ"+timestr;
        sendNote(NotezumSpeichern);
        //Toast.makeText(getApplicationContext(),"dz"+Long.toString(time),Toast.LENGTH_SHORT).show();
    }

    private String fileContents = "";

    public void setFileToZero() {
        this.fileContents = "";
    }

    public void sendNote(String notezumSpeichern){
        fileContents = fileContents + notezumSpeichern + "\n";

    }


    public void deleteAFile(){
        Context context = this;
        EditText liedname_et = (EditText)findViewById(R.id.NameAusfüll_ETXT);
        String liedname = liedname_et.getText().toString();
        String filename = null;
        if(!liedname.matches("")){
            try {
                filename = liedname + ".txt";
                File file = new File(context.getFilesDir(), filename);
                file.delete();
                Toast.makeText(getApplicationContext(),filename + " wurde aus den Dateien gelöscht!",Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),"Von diesem Lied existiert keine Datei!",Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
            //warum wirft es keine?
            /*catch(FileNotFoundException e){
                Toast.makeText(getApplicationContext(),"Von diesem Lied existiert keine Datei!",Toast.LENGTH_LONG).show();

            }
             */
        }
        else{
            Toast.makeText(getApplicationContext(),"Gib ein welches Lied gelöscht werden soll!",Toast.LENGTH_LONG).show();
        }


    }




    public void makeAFile() {

        Context context = this;
        EditText liedname_et = (EditText)findViewById(R.id.NameAusfüll_ETXT);
        String liedname = liedname_et.getText().toString();
        String filename = null;
        if(!liedname.matches("")){
            filename = liedname + ".txt";
        }
        else{
            Toast.makeText(getApplicationContext(),"Du musst erst einen Namen eingeben!",Toast.LENGTH_LONG).show();
        }
        //String fileContents = ";
        try (FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE)) {
            //Toast.makeText(getApplicationContext(),(fileContents.getBytes()).toString(),Toast.LENGTH_SHORT).show();
            fos.write(fileContents.getBytes());
            Toast.makeText(getApplicationContext(), liedname + " wurde gespeichert",Toast.LENGTH_SHORT).show();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }




    }