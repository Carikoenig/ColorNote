package com.example.myfirstapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CreateActivity extends AppCompatActivity {



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
}