package com.example.hoon.helloy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    Button button;
    TextView name;
    TextView gender;
    TextView spam;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);


        button = (Button)findViewById(R.id.BackButton);
        name = (TextView)findViewById(R.id.name_blank);
        gender = (TextView)findViewById(R.id.gender_blank);
        spam = (TextView)findViewById(R.id.spam_blank);

        Intent intent = getIntent();
        if(intent != null)
        {
            bundle = intent.getExtras();
            name.setText(bundle.getString("name"));
            gender.setText(bundle.getString("gender"));
            spam.setText(bundle.getString("spam"));
        }
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
