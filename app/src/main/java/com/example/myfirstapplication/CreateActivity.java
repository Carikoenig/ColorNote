package com.example.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);

        //Was das C1 auslöst:
        Button C1_Btn = (Button) findViewById(R.id.C1_Btn);
        C1_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bei CreateModus
                if(MainActivity.modus == 1) {

                }
                //bei PlayModus
                else if(MainActivity.modus >= 10){

                }
            }
        });
    }
}