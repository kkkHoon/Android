package com.example.hoon.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class activity_new extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent passedIntent = getIntent();
        if(passedIntent != null)
        {
            String outName = passedIntent.getStringExtra("name");
            String outAge = passedIntent.getStringExtra("age");
            Toast.makeText(getApplicationContext(),"Student info : "+outName+","+outAge,Toast.LENGTH_LONG).show();
        }
        Button button = (Button)findViewById(R.id.end);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}
