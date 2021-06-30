package com.example.myfirstapplication;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Property;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class PlayActivity extends AppCompatActivity {

    String filename = "ton";
    boolean ladbar = false;
    EditText input_etxt;
    ImageView iv;
    List<String> inhalt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_keyboard_play);

        inhalt.add("cQ2000");
        inhalt.add("dQ3000");
        inhalt.add("fQ6000");


        input_etxt = (EditText) findViewById(R.id.Input_etxt);

        Button play_btn = (Button) findViewById(R.id.Play_btn);
        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFile();
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

    public void loadFile(){
        String liedname = input_etxt.getText().toString();
        File file = new File(liedname + ".txt");
        if(input_etxt.getText().toString().isEmpty() || !file.exists()) {
            Toast.makeText(getApplicationContext(),"Du musst erst den Namen eines existierenden Files eingeben!",Toast.LENGTH_LONG).show();
        }
        else{
            ladbar = true;
            filename = liedname + ".txt";
            loadInhalt(filename);
        }
    }

    private boolean getLadbar() {
        return ladbar;
    }

    public void loadInhalt(String name) {
        try(BufferedReader input = new BufferedReader(new FileReader(name))) {
            boolean end = false;
            while(!end) {
                String line = input.readLine();
                inhalt.add(line);
                if(line == null) {
                    end = true;
                }
            }
            generateBand();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateBand() {
        for(int i = 0; i < inhalt.toArray().length; i++) {
            String line = inhalt.get(i);
            String[] parts = line.split("Q");
            int bandfarbe = getCol(parts[0]);
            long bandlänge = Long.parseLong(parts[1]);
            viewView(bandfarbe, bandlänge);
           // animate();
        }
    }

    private void viewView(int bandfarbe, long bandlänge) {
        if(bandfarbe == 1) {
            View view = (View) findViewById(R.id.changingView);
            Button btn = (Button) findViewById(R.id.C1_Btn);
            int col = btn.getDrawingCacheBackgroundColor();
            view.setBackgroundColor(col);
            try {
                wait(bandlänge);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

 /*   private void animate(View target, Property <View, Float> property, Long duration, TimeInterpolator interpolator) {
        val ani = ObjectAnimator.ofFloat(target, );
    }

 /*   public String loadNote() {
        Context context = this;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String note = br.readLine();
            Toast.makeText(getApplicationContext(), liedname + " wurde gespeichert",Toast.LENGTH_SHORT).show();
            return note;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    public void generateBand() {
        String note = "";
        while(note != null) {
            note = loadNote();
            if(note != null) {
                String[] block = note.split("Q");
                String col = getCol(block[0]);
                if (col.equals("fehler")) {
                    throw new IllegalStateException("Fehler beim Entschlüsseln des Files. Note " + note + " erhalten.");
                }
                long lon = Long.parseLong(block[1]);


                Canvas band = new Canvas();
                Paint color = new Paint();
                //
                color.setColor(34);
                //band.drawRect(0, 0, lon, map.getScaleY(), color);
                //map.draw(band);
            }
        }
    }*/

    private int getCol(String color) {
        if(color.equals("g")) {
            return 5 ;
        }
        else if(color.equals("a")) {
            return 6 ;
        }
        else if(color.equals("dz")) {
            return 9 ;
        }
        else if(color.equals("e")) {
            return 3 ;
        }
        else if(color.equals("c")) {
            return 1 ;
        }
        else if(color.equals("d")) {
            return 2 ;
        }
        else if(color.equals("cz")) {
            return 8 ;
        }
        else if(color.equals("h")) {
            return 7 ;
        }
        else if(color.equals("f")) {
            return 4 ;
        }
        else {
            return 0;
        }
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