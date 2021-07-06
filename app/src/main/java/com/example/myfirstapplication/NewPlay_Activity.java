package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class NewPlay_Activity<zeitliste2> extends AppCompatActivity {

    //Screen size
    private int screenWidth;
    private int screenHeight;
    //Images
    private ImageView csmiley;
    private ImageView dsmiley;
    private ImageView esmiley;
    private ImageView fsmiley;
    private ImageView gsmiley;
    private ImageView asmiley;
    private ImageView hsmiley;
    private ImageView c2smiley;
    private ImageView d2smiley;

    //Position X-Koordinate
    private float csmileyX;
    private float dsmileyX;
    private float esmileyX;
    private float fsmileyX;
    private float gsmileyX;
    private float asmileyX;
    private float hsmileyX;
    private float c2smileyX;
    private float d2smileyX;

    private Handler handlerCoordinator = new Handler();
    private Timer timerCoordinator = new Timer();

    private Handler handlerC = new Handler();
    private Timer timerC = new Timer();

    private Handler handlerD = new Handler();
    private Timer timerD = new Timer();

    private Handler handlerE = new Handler();
    private Timer timerE = new Timer();

    private Handler handlerF = new Handler();
    private Timer timerF = new Timer();

    private Handler handlerG = new Handler();
    private Timer timerG = new Timer();

    private Handler handlerA = new Handler();
    private Timer timerA = new Timer();

    private Handler handlerH = new Handler();
    private Timer timerH = new Timer();

    private Handler handlerC2 = new Handler();
    private Timer timerC2 = new Timer();

    private Handler handlerD2 = new Handler();
    private Timer timerD2 = new Timer();

    boolean ladbar = false;
    List<String> inhalt = new ArrayList<String>(){
        { //testarray
            add("cQ1625557393841");
            add("cQ1625557396106");
            add("cQ1625557398781");
            add("cQ1625557399580");
            add("cQ1625557402606");

        }
    };


    Long zeitZuBeginn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_new_play);

        zeitZuBeginn = System.currentTimeMillis();
        Intent intent = getIntent();
        String liedname = intent.getStringExtra("Lied");

        //loadFile(liedname); Problem mit nullpointer
        //generateBand(); selbes Problem aber bezug zu long dabei
        matchTonMitZeit();


        csmiley = (ImageView)findViewById(R.id.csmiley);
        dsmiley = (ImageView)findViewById(R.id.dsmiley);
        esmiley = (ImageView)findViewById(R.id.esmiley);
        fsmiley = (ImageView)findViewById(R.id.fsmiley);
        gsmiley = (ImageView)findViewById(R.id.gsmiley);
        asmiley = (ImageView)findViewById(R.id.asmiley);
        hsmiley = (ImageView)findViewById(R.id.hsmiley);
        c2smiley = (ImageView)findViewById(R.id.c2smiley);
        d2smiley = (ImageView)findViewById(R.id.d2smiley);

        //Get screen size
        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        //Move the smiley out of view on thr right end
        csmiley.setX(2000.0f);
        csmiley.setY(0.0f);

        dsmiley.setX(2000.0f);
        dsmiley.setY(0.0f);

        esmiley.setX(2000.0f);
        esmiley.setY(0.0f);

        fsmiley.setX(2000.0f);
        fsmiley.setY(0.0f);

        gsmiley.setX(2100.0f);
        gsmiley.setY(0.0f);

        asmiley.setX(2100.0f);
        asmiley.setY(0.0f);

        hsmiley.setX(2100.0f);
        hsmiley.setY(0.0f);

        c2smiley.setX(2100.0f);
        c2smiley.setY(0.0f);

        d2smiley.setX(2100.0f);
        d2smiley.setY(0.0f);

        /*
        //lässt die Smileys in endlosschleife über den Bildschirm wandern
        startTimerC();
        startTimerD();
        startTimerE();
        startTimerF();
        startTimerG();
        startTimerA();
        startTimerH();
        startTimerC2();
        startTimerD2();

         */

        Button playc = (Button) findViewById(R.id.CBtn);
        playc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playc(playc);


            }
        });

        Button playd = (Button) findViewById(R.id.DBtn);
        playd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playd(playd);


            }
        });

        Button playe = (Button) findViewById(R.id.EBtn);
        playe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playe(playe);
            }
        });

        Button playf = (Button) findViewById(R.id.FBtn);
        playf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playf(playf);
            }
        });

        Button playg = (Button) findViewById(R.id.GBtn);
        playg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playg(playg);
            }
        });

        Button playa = (Button) findViewById(R.id.ABtn);
        playa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playa(playa);
            }
        });

        Button playh = (Button) findViewById(R.id.HBtn);
        playh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playh(playh);
            }
        });

        Button playc2 = (Button) findViewById(R.id.C2Btn);
        playc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playc2(playc2);
            }
        });

        Button playd2 = (Button) findViewById(R.id.D2Btn);
        playd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playd2(playd2);
            }
        });






    }

    //Integer[] farbenliste = new Integer[inhalt.toArray().length];
    //hart kodiert zum Test
    Integer[] farbenliste = {1, 3, 4, 5, 1, 3, 4, 5, 1, 3, 4, 5, 3, 1, 3, 2, 5, 7, 8, 9, 5, 7, 8, 9};
    Long[] zeitliste = new Long[inhalt.toArray().length];

    //hart kodiert zum test...na, wer erkennt es?:)
    Long[] zeitliste2 = {0l, 1000l, 2000l, 3000l, 8000l, 9000l, 10000l, 11000l, 16000l, 17000l, 18000l, 19000l, 21000l, 23000l, 25000l, 27000l, 33000l, 34000l, 35000l, 36000l, 42000l, 43000l, 44000l, 45000l };


    /*
    public void loadFile(String liedname){
        Context context = this;

        File file = new File(context.getFilesDir(), liedname);
        if(!file.exists()) {
            Toast.makeText(getApplicationContext(),"Geh zurück und gib den Namen eines existierenden Files ein!",Toast.LENGTH_LONG).show();
        }
        else{
            ladbar = true;
            loadInhalt(liedname);
        }
    }

    private boolean getLadbar() {
        return ladbar;
    }

    public void loadInhalt(String name) {

        Log.d("444", "loadInhalt: vor buffered");
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

     */

/*
//Problem mit nullpointer exception in TonStartBerechnen???

    public void generateBand() {

        for(int i = 0; i < inhalt.toArray().length; i++) {
            String line = inhalt.get(i);
            String[] parts = new String[2];
            parts = line.split("Q");
            //bandlänge muss überarbeitet werden, da bandlänge eig aus dem Abstand zur vorherigen Länge entsteht
            //erstmal 2 Array erstellen, die passenden Daten sind schließlich auf denselben Positionen und können noch gematched werden
            int bandfarbe = getCol(parts[0]);
            farbenliste[i] = bandfarbe;
            long bandlänge = Long.parseLong(parts[1]);
            zeitliste[i] = bandlänge;
            //neue zeitliste mit richtigen Längen machen
            TonStartBerechnen();
            //wieder mit den Tonhöhen zusammenführen
            matchTonMitZeit();
        }
    }

    public void TonStartBerechnen(){
        //der erste Ton beginnt sofort, alle anderen haben ihren Onset versetzt um die Differenz zu Beginn des Programms
        zeitliste2[0] = Long.valueOf(0);
        for(int i = 1; i < zeitliste.length; i++){
            Long zeitlänge = zeitliste[i] - zeitliste[0];
            zeitliste2[i] = zeitlänge;
        }
    }

 */

    public void matchTonMitZeit(){
        for(int i = 0; i < zeitliste2.length; i++){
            int tonhöhe = farbenliste[i];
            long tonOnset = zeitliste2[i];
            sendSmiley(tonhöhe, tonOnset);
        }

    }
/*
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

 */

    public void sendSmiley(int tonhöhe, long tonOnset){
        switch(tonhöhe){
            case 1:
                //TimeWatcher(tonOnset);
                timerCoordinator.schedule(new TimerTask(){
                    @Override
                    public void run(){
                        handlerCoordinator.post(new Runnable(){
                            @Override
                            public void run(){
                                if(zeitZuBeginn + tonOnset <= System.currentTimeMillis() && zeitZuBeginn + tonOnset + 150 > System.currentTimeMillis() ){
                                    startTimerC();

                                }
                            }
                        });
                    }
                }, 0, 100);

                break;
            case 2:
               // sendDWhenTime(tonOnset);
                timerCoordinator.schedule(new TimerTask(){
                    @Override
                    public void run(){
                        handlerCoordinator.post(new Runnable(){
                            @Override
                            public void run(){
                                if(zeitZuBeginn + tonOnset <= System.currentTimeMillis() && zeitZuBeginn + tonOnset + 150 > System.currentTimeMillis() ){
                                    startTimerD();

                                }
                            }
                        });
                    }
                }, 0, 100);

                break;
            case 3:
                //sendEWhenTime(tonOnset);
                timerCoordinator.schedule(new TimerTask(){
                    @Override
                    public void run(){
                        handlerCoordinator.post(new Runnable(){
                            @Override
                            public void run(){
                                if(zeitZuBeginn + tonOnset <= System.currentTimeMillis() && zeitZuBeginn + tonOnset + 150 > System.currentTimeMillis() ){
                                    startTimerE();

                                }
                            }
                        });
                    }
                }, 0, 100);
                break;
            case 4:
                //sendFWhenTime(tonOnset);
                timerCoordinator.schedule(new TimerTask(){
                    @Override
                    public void run(){
                        handlerCoordinator.post(new Runnable(){
                            @Override
                            public void run(){
                                if(zeitZuBeginn + tonOnset <= System.currentTimeMillis() && zeitZuBeginn + tonOnset + 150 > System.currentTimeMillis() ){
                                    startTimerF();

                                }
                            }
                        });
                    }
                }, 0, 100);
                break;
            case 5:
                //sendGWhenTime(tonOnset);
                timerCoordinator.schedule(new TimerTask(){
                    @Override
                    public void run(){
                        handlerCoordinator.post(new Runnable(){
                            @Override
                            public void run(){
                                if(zeitZuBeginn + tonOnset <= System.currentTimeMillis() && zeitZuBeginn + tonOnset + 150 > System.currentTimeMillis() ){
                                    startTimerG();

                                }
                            }
                        });
                    }
                }, 0, 100);
                break;
            case 6:
                //sendAWhenTime(tonOnset);
                timerCoordinator.schedule(new TimerTask(){
                    @Override
                    public void run(){
                        handlerCoordinator.post(new Runnable(){
                            @Override
                            public void run(){
                                if(zeitZuBeginn + tonOnset <= System.currentTimeMillis() && zeitZuBeginn + tonOnset + 150 > System.currentTimeMillis() ){
                                    startTimerA();

                                }
                            }
                        });
                    }
                }, 0, 100);
                break;
            case 7:
                //sendHWhenTime(tonOnset);
                timerCoordinator.schedule(new TimerTask(){
                    @Override
                    public void run(){
                        handlerCoordinator.post(new Runnable(){
                            @Override
                            public void run(){
                                if(zeitZuBeginn + tonOnset <= System.currentTimeMillis() && zeitZuBeginn + tonOnset + 150 > System.currentTimeMillis() ){
                                    startTimerH();

                                }
                            }
                        });
                    }
                }, 0, 100);
                break;
            case 8:
                //sendC2WhenTime(tonOnset);
                timerCoordinator.schedule(new TimerTask(){
                    @Override
                    public void run(){
                        handlerCoordinator.post(new Runnable(){
                            @Override
                            public void run(){
                                if(zeitZuBeginn + tonOnset <= System.currentTimeMillis() && zeitZuBeginn + tonOnset + 150 > System.currentTimeMillis() ){
                                    startTimerC2();

                                }
                            }
                        });
                    }
                }, 0, 100);
                break;
            case 9:
                //sendD2WhenTime(tonOnset);
                timerCoordinator.schedule(new TimerTask(){
                    @Override
                    public void run(){
                        handlerCoordinator.post(new Runnable(){
                            @Override
                            public void run(){
                                if(zeitZuBeginn + tonOnset <= System.currentTimeMillis() && zeitZuBeginn + tonOnset + 150 > System.currentTimeMillis() ){
                                    startTimerD2();

                                }
                            }
                        });
                    }
                }, 0, 100);
                break;
        }
    }

    /*
    //kann man timer mehrfach verwenden??? -> algemeinen timer für zeit überwachung nehmen, nicht jeder einzelnXD
    public void sendCWhenTime(Long onset){
        timerC.schedule(new TimerTask(){
           @Override
           public void run(){
               handlerC.post(new Runnable(){
                   @Override
                   public void run(){
                       if(zeitZuBeginn + onset >= System.currentTimeMillis()){
                           startTimerC();

                       }
                   }
               });
           }
        }, 0, 50);
    }

     */

/* //ist jz schon sendSmiley drin
    public void TimeWatcher(Long onset){
        timerCoordinator.schedule(new TimerTask(){
            @Override
            public void run(){
                handlerCoordinator.post(new Runnable(){
                    @Override
                    public void run(){
                        if(zeitZuBeginn + onset <= System.currentTimeMillis()){
                            startTimerC();

                        }
                    }
                });
            }
        }, 0, 50);
    }

 */

    public void startTimerC(){
        //Start the timer...gibt Problem wenn ichs auf vorgebautem timerC aufrufe("timer already canceled...in move c nicht canceln oder sleep?")
        // oder immer eigenen timer einbauen
        Handler handlerCC = new Handler();
        Timer timerCC = new Timer();
        timerCC.schedule(new TimerTask(){
            @Override
            public void run(){
                handlerCC.post(new Runnable(){
                    @Override
                    public void run(){
                        moveCSmiley(timerCC);
                    }
                });
            }
        }, 0, 10);
    }

    public void startTimerD(){
        Handler handlerDD = new Handler();
        Timer timerDD = new Timer();
        timerDD.schedule(new TimerTask(){
        @Override
        public void run(){
            handlerDD.post(new Runnable(){
                @Override
                public void run(){
                    moveDSmiley(timerDD);
                }
            });
        }
    }, 0, 10);

    }
    public void startTimerE(){
        Handler handlerEE = new Handler();
        Timer timerEE = new Timer();
        timerEE.schedule(new TimerTask(){
        @Override
        public void run(){
            handlerEE.post(new Runnable(){
                @Override
                public void run(){
                    moveESmiley(timerEE);
                }
            });
        }
    }, 0, 10);


    }
    public void startTimerF(){
        Handler handlerFF = new Handler();
        Timer timerFF = new Timer();
        timerFF.schedule(new TimerTask(){
        @Override
        public void run(){
            handlerFF.post(new Runnable(){
                @Override
                public void run(){
                    moveFSmiley(timerFF);
                }
            });
        }
    }, 0, 10);

    }
    public void startTimerG(){
        Handler handlerGG = new Handler();
        Timer timerGG = new Timer();
        timerGG.schedule(new TimerTask(){
        @Override
        public void run(){
            handlerGG.post(new Runnable(){
                @Override
                public void run(){
                    moveGSmiley(timerGG);
                }
            });
        }
    }, 0, 10);

    }
    public void startTimerA(){
        Handler handlerAA = new Handler();
        Timer timerAA = new Timer();
        timerAA.schedule(new TimerTask(){
        @Override
        public void run(){
            handlerAA.post(new Runnable(){
                @Override
                public void run(){
                    moveASmiley(timerAA);
                }
            });
        }
    }, 0, 10);

    }
    public void startTimerH(){
        Handler handlerHH = new Handler();
        Timer timerHH = new Timer();
        timerHH.schedule(new TimerTask(){
        @Override
        public void run(){
            handlerHH.post(new Runnable(){
                @Override
                public void run(){
                    moveHSmiley(timerHH);
                }
            });
        }
    }, 0, 10);

    }

    public void startTimerC2(){
        Handler handlerCC2 = new Handler();
        Timer timerCC2 = new Timer();
        timerCC2.schedule(new TimerTask(){
            @Override
            public void run(){
                handlerCC2.post(new Runnable(){
                    @Override
                    public void run(){
                        moveC2Smiley(timerCC2);
                    }
                });
            }
        }, 0, 10);

    }

    public void startTimerD2(){
        Handler handlerDD2 = new Handler();
        Timer timerDD2 = new Timer();
        timerDD2.schedule(new TimerTask(){
            @Override
            public void run(){
                handlerDD2.post(new Runnable(){
                    @Override
                    public void run(){
                        moveD2Smiley(timerDD2);
                    }
                });
            }
        }, 0, 10);
    }




    public void moveCSmiley(Timer timerCC){
        //move to the left
        csmileyX = csmileyX - 5;

        if(csmileyX < 0){
            csmileyX = 2000.0f;
            csmiley.setX(csmileyX);
            //den timer stoppen sobald über screen seite hinaus-> gibt probleme
            timerCC.cancel();
        }
        csmiley.setX(csmileyX);
        csmiley.setY(0.0f);
    }

    public void moveDSmiley(Timer timerDD){
        //move to the left
        dsmileyX = dsmileyX - 5;
        if(dsmiley.getX() + dsmiley.getWidth() < 0){
            dsmileyX = 2000.0f;
            dsmiley.setX(dsmileyX);
            timerDD.cancel();
            //den timer stoppen sobald über screen seite hinaus

        }
        dsmiley.setX(dsmileyX);
        dsmiley.setY(0.0f);

    }

    public void moveESmiley(Timer timerEE){
        //move to the left
        esmileyX = esmileyX - 5;
        if(esmiley.getX() + esmiley.getWidth() < 0){
            esmileyX = 2000.0f;
            esmiley.setX(esmileyX);
            timerEE.cancel();
            //den timer stoppen sobald über screen seite hinaus

        }
        esmiley.setX(esmileyX);
        esmiley.setY(0.0f);
    }

    public void moveFSmiley(Timer timerFF){
        //move to the left
        fsmileyX = fsmileyX - 5;
        if(fsmiley.getX() + fsmiley.getWidth() < 0){
            fsmileyX = 2000.0f;
            fsmiley.setX(fsmileyX);
            timerFF.cancel();
            //den timer stoppen sobald über screen seite hinaus

        }
        fsmiley.setX(fsmileyX);
        fsmiley.setY(0.0f);
    }

    public void moveGSmiley(Timer timerGG){
        //move to the left
        gsmileyX = gsmileyX - 5;
        if(gsmiley.getX() + gsmiley.getWidth() < 0){
            gsmileyX = 2000.0f;
            timerGG.cancel();
            //den timer stoppen sobald über screen seite hinaus

        }
        gsmiley.setX(gsmileyX);
        gsmiley.setY(0.0f);
    }

    public void moveASmiley(Timer timerAA){
        //move to the left
        asmileyX = asmileyX - 5;
        if(asmiley.getX() + asmiley.getWidth() < 0){
            asmileyX = 2000.0f;
            timerAA.cancel();
            //den timer stoppen sobald über screen seite hinaus

        }
        asmiley.setX(asmileyX);
        asmiley.setY(0.0f);
    }

    public void moveHSmiley(Timer timerHH){
        //move to the left
        hsmileyX = hsmileyX - 5;
        if(hsmiley.getX() + hsmiley.getWidth() < 0){
            hsmileyX = 2000.0f;
            timerHH.cancel();
            //den timer stoppen sobald über screen seite hinaus

        }
        hsmiley.setX(hsmileyX);
        hsmiley.setY(0.0f);
    }

    public void moveC2Smiley(Timer timerCC2){
        //move to the left
        c2smileyX = c2smileyX - 5;
        if(c2smiley.getX() + c2smiley.getWidth() < 0){
            c2smileyX = 2000.0f;
            timerCC2.cancel();
            //den timer stoppen sobald über screen seite hinaus

        }
        c2smiley.setX(c2smileyX);
        c2smiley.setY(0.0f);
    }

    public void moveD2Smiley(Timer timerDD2){
        //move to the left
        d2smileyX = d2smileyX - 5;
        if(d2smiley.getX() + d2smiley.getWidth() < 0){
            d2smileyX = 2000.0f;
            timerDD2.cancel();
            //den timer stoppen sobald über screen seite hinaus

        }
        d2smiley.setX(d2smileyX);
        d2smiley.setY(0.0f);
    }

    //teilweise ist bei den move Funktionen noch ein Unterschied darin, ob nach veränderung von X vor dem canceln noch gesettet wird auf x...
    //weiteres Problem: überlappen der timer wenn man sie mehrfach benutzt?
    //grundlegendes Problem...es gibt nur ein bild von einer note...also kann man auch nur eine auf einmal spielen, was wenn mehrmals dieselbe hintereinander kommt?
    //_> mehrere Bilder von derselben Note haben und dann quasi aus einem pool abgreifen wenn andere schon in benutzung???

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