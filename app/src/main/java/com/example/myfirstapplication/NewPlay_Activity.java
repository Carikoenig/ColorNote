package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class NewPlay_Activity extends AppCompatActivity {

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
    List<String> inhalt;
    Integer[] farbenliste = new Integer[inhalt.toArray().length];
    Long[] zeitliste = new Long[inhalt.toArray().length];
    Long[] zeitliste2 = new Long[inhalt.toArray().length];
    Long zeitZuBeginn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_new_play);

        zeitZuBeginn = System.currentTimeMillis();
        Intent intent = getIntent();
        String liedname = intent.getStringExtra("Lied");

        loadFile(liedname);


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

        gsmiley.setX(2000.0f);
        gsmiley.setY(0.0f);

        asmiley.setX(2000.0f);
        asmiley.setY(0.0f);

        hsmiley.setX(2000.0f);
        hsmiley.setY(0.0f);

        c2smiley.setX(2000.0f);
        c2smiley.setY(0.0f);

        d2smiley.setX(2000.0f);
        d2smiley.setY(0.0f);

        startTimerC();
        startTimerD();
        startTimerE();
        startTimerF();
        startTimerG();
        startTimerA();
        startTimerH();
        startTimerC2();
        startTimerD2();






    }

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
        zeitliste2[0] = 0l;
        for(int i = 1; i < zeitliste.length; i++){
            Long zeitlänge = zeitliste[i] - zeitliste[0];
            zeitliste2[i] = zeitlänge;
        }
    }

    public void matchTonMitZeit(){
        for(int i = 0; i < zeitliste2.length; i++){
            int tonhöhe = farbenliste[i];
            long tonOnset = zeitliste2[i];
            sendSmiley(tonhöhe, tonOnset);
        }

    }

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

    public void sendSmiley(int tonhöhe, long tonOnset){
        switch(tonhöhe){
            case 1:
                sendCWhenTime(tonOnset);
                break;
            case 2:
               // sendDWhenTime(tonOnset);
                break;
            case 3:
                //sendEWhenTime(tonOnset);
                break;
            case 4:
                //sendFWhenTime(tonOnset);
                break;
            case 5:
                //sendGWhenTime(tonOnset);
                break;
            case 6:
                //sendAWhenTime(tonOnset);
                break;
            case 7:
                //sendHWhenTime(tonOnset);
                break;
            case 8:
                //sendC2WhenTime(tonOnset);
                break;
            case 9:
                //sendD2WhenTime(tonOnset);
                break;
        }
    }

    //kann man timer mehrfach verwenden???
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

    public void startTimerC(){
        //Start the timer
        timerC.schedule(new TimerTask(){
            @Override
            public void run(){
                handlerC.post(new Runnable(){
                    @Override
                    public void run(){
                        moveCSmiley();
                    }
                });
            }
        }, 0, 5);
    }

    public void startTimerD(){
        timerD.schedule(new TimerTask(){
        @Override
        public void run(){
            handlerD.post(new Runnable(){
                @Override
                public void run(){
                    moveDSmiley();
                }
            });
        }
    }, 0, 5);

    }
    public void startTimerE(){
        timerE.schedule(new TimerTask(){
        @Override
        public void run(){
            handlerE.post(new Runnable(){
                @Override
                public void run(){
                    moveESmiley();
                }
            });
        }
    }, 0, 5);


    }
    public void startTimerF(){
        timerF.schedule(new TimerTask(){
        @Override
        public void run(){
            handlerF.post(new Runnable(){
                @Override
                public void run(){
                    moveFSmiley();
                }
            });
        }
    }, 0, 5);

    }
    public void startTimerG(){
        timerG.schedule(new TimerTask(){
        @Override
        public void run(){
            handlerG.post(new Runnable(){
                @Override
                public void run(){
                    moveGSmiley();
                }
            });
        }
    }, 0, 5);

    }
    public void startTimerA(){
        timerA.schedule(new TimerTask(){
        @Override
        public void run(){
            handlerA.post(new Runnable(){
                @Override
                public void run(){
                    moveASmiley();
                }
            });
        }
    }, 0, 5);

    }
    public void startTimerH(){
        timerH.schedule(new TimerTask(){
        @Override
        public void run(){
            handlerH.post(new Runnable(){
                @Override
                public void run(){
                    moveHSmiley();
                }
            });
        }
    }, 0, 5);

    }

    public void startTimerC2(){
        timerC2.schedule(new TimerTask(){
            @Override
            public void run(){
                handlerC2.post(new Runnable(){
                    @Override
                    public void run(){
                        moveC2Smiley();
                    }
                });
            }
        }, 0, 5);

    }

    public void startTimerD2(){
        timerD2.schedule(new TimerTask(){
            @Override
            public void run(){
                handlerD2.post(new Runnable(){
                    @Override
                    public void run(){
                        moveD2Smiley();
                    }
                });
            }
        }, 0, 5);
    }




    public void moveCSmiley(){
        //move to the left
        csmileyX = csmileyX - 5;

        if(csmiley.getX() + csmiley.getWidth() < 0){
            csmileyX = 2000.0f;
            csmiley.setX(csmileyX);
            //den timer stoppen sobald über screen seite hinaus
            timerC.cancel();
        }
        csmiley.setX(csmileyX);
        csmiley.setY(0.0f);
    }

    public void moveDSmiley(){
        //move to the left
        dsmileyX = dsmileyX - 5;
        if(dsmiley.getX() + dsmiley.getWidth() < 0){
            dsmileyX = 2000.0f;
            dsmiley.setX(dsmileyX);
            timerD.cancel();
            //den timer stoppen sobald über screen seite hinaus

        }
        dsmiley.setX(dsmileyX);
        dsmiley.setY(0.0f);

    }

    public void moveESmiley(){
        //move to the left
        esmileyX = esmileyX - 5;
        if(esmiley.getX() + esmiley.getWidth() < 0){
            esmileyX = 2000.0f;
            esmiley.setX(esmileyX);
            timerE.cancel();
            //den timer stoppen sobald über screen seite hinaus

        }
        esmiley.setX(esmileyX);
        esmiley.setY(0.0f);
    }

    public void moveFSmiley(){
        //move to the left
        fsmileyX = fsmileyX - 5;
        if(fsmiley.getX() + fsmiley.getWidth() < 0){
            fsmileyX = 2000.0f;
            fsmiley.setX(fsmileyX);
            timerF.cancel();
            //den timer stoppen sobald über screen seite hinaus

        }
        fsmiley.setX(fsmileyX);
        fsmiley.setY(0.0f);
    }

    public void moveGSmiley(){
        //move to the left
        gsmileyX = gsmileyX - 5;
        if(gsmiley.getX() + gsmiley.getWidth() < 0){
            gsmileyX = 2000.0f;
            timerG.cancel();
            //den timer stoppen sobald über screen seite hinaus

        }
        gsmiley.setX(gsmileyX);
        gsmiley.setY(0.0f);
    }

    public void moveASmiley(){
        //move to the left
        asmileyX = asmileyX - 5;
        if(asmiley.getX() + asmiley.getWidth() < 0){
            asmileyX = 2000.0f;
            timerA.cancel();
            //den timer stoppen sobald über screen seite hinaus

        }
        asmiley.setX(asmileyX);
        asmiley.setY(0.0f);
    }

    public void moveHSmiley(){
        //move to the left
        hsmileyX = hsmileyX - 5;
        if(hsmiley.getX() + hsmiley.getWidth() < 0){
            hsmileyX = 2000.0f;
            timerH.cancel();
            //den timer stoppen sobald über screen seite hinaus

        }
        hsmiley.setX(hsmileyX);
        hsmiley.setY(0.0f);
    }

    public void moveC2Smiley(){
        //move to the left
        c2smileyX = c2smileyX - 5;
        if(c2smiley.getX() + c2smiley.getWidth() < 0){
            c2smileyX = 2000.0f;
            timerC2.cancel();
            //den timer stoppen sobald über screen seite hinaus

        }
        c2smiley.setX(c2smileyX);
        c2smiley.setY(0.0f);
    }

    public void moveD2Smiley(){
        //move to the left
        d2smileyX = d2smileyX - 5;
        if(d2smiley.getX() + d2smiley.getWidth() < 0){
            d2smileyX = 2000.0f;
            timerD2.cancel();
            //den timer stoppen sobald über screen seite hinaus

        }
        d2smiley.setX(d2smileyX);
        d2smiley.setY(0.0f);
    }

    //teilweise ist bei den move Funktionen noch ein Unterschied darin, ob nach veränderung von X vor dem canceln noch gesettet wird auf x...
    //weiteres Problem: überlappen der timer wenn man sie mehrfach benutzt?

}