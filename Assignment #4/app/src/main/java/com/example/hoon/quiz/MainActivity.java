package com.example.hoon.quiz;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.CharBuffer;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button1;
    Button button2;
    Button button3;
    Button button4;

    File outputFile;
    OutputStreamWriter writer;
    InputStreamReader reader;
    BufferedReader Breader;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = "mysdfile.txt";

        File sdCard = Environment.getExternalStorageDirectory();
        File directory = new File(sdCard.getAbsolutePath() + "/MyFile");
        directory.mkdir();

        outputFile = new File(directory, name);

        editText = (EditText)findViewById(R.id.extData);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String line = "";
                try {
                    FileInputStream fIn = new FileInputStream(outputFile);
                    reader = new InputStreamReader(fIn);
                    Breader = new BufferedReader(reader);
                    while ((line = Breader.readLine()) != null)
                    {
                        editText.append(line+"\n");
                    }
                    Toast.makeText(getApplicationContext(),"Done reading SD +'"+name+"'",Toast.LENGTH_SHORT).show();
                    reader.close();
                    Breader.close();
                } catch(java.io.IOException e) {}
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fOut = new FileOutputStream(outputFile);
                    writer = new OutputStreamWriter(fOut);
                    writer.write(editText.getText().toString());
                    Toast.makeText(getApplicationContext(),"Done writing SD +'"+name+"'",Toast.LENGTH_SHORT).show();
                    writer.close();
                } catch(java.io.IOException e) {}
            }
        });
    }
}
