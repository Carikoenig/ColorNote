package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class ShowExistingFiles_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_show_existing_files);

        TextView liedübersichtTV = (TextView) findViewById(R.id.LiederübersichtTVIEW);
        //war test: String liedübersichtString = "lalala \n blablabla \n lskfejhslykjdhflksfhglkusdjfhglkuhslfkugjlskjfgblksjfbglkasjfblkgjsbflkjgbslfkjlyskjfg ösfghösjkdhfg sökfjh aösjfkhgök södfjhgöskdjfhg södfjgh ösdfjhgöskdjfhgölskdjhg söfjkdghösdjfhg ösdfljkgsdjgö";

        liedübersichtTV.setText(makeFileList());

        Button spielen = (Button) findViewById(R.id.spielenBtn);
        EditText ausgewaeltesLiedET = (EditText) findViewById(R.id.editTxtLiedname);

        spielen.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        String ausgewaeltesLied = ausgewaeltesLiedET.getText().toString();
                        Intent intent = new Intent(ShowExistingFiles_Activity.this, NewPlay_Activity.class);
                        intent.putExtra("Lied", ausgewaeltesLied);
                        startActivity(intent);
                        /*geht immer ins else???
                        if(isItAFile(ausgewaeltesLied)){

                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Gib einen existierenden Namen ein!",Toast.LENGTH_SHORT).show();
                        }
                        */

                    }
                }
        );
    }

    public String makeFileList (){
        //getFilesDir returns the path of the files directory
        String pfadvonfiles = getFilesDir().getPath();
        File dir_file = new File(pfadvonfiles);

        File[] filelist = dir_file.listFiles();
        String existierendeFiles = "";
        for (File f: filelist){
            String name = f.getName();
            existierendeFiles = existierendeFiles  + name + "    ";
        }

        return existierendeFiles;
    }

    public boolean isItAFile(String gesucht){
        String pfadvonfiles = getFilesDir().getPath();
        File dir_file = new File(pfadvonfiles);
        File[] filelist = dir_file.listFiles();
        boolean found = false;
        for(File f: filelist){
            String name = f.getName();
            if(name == gesucht){
                found = true;
            }
        }
        return found;

    }
}