package com.example.hoon.hello;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText Age;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // main xml layout을 inflation할 수 있다.

        button = (Button)findViewById(R.id.add);
        Name = (EditText)findViewById(R.id.name);
        Age = (EditText)findViewById(R.id.age);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(),activity_new.class);
                intent.putExtra("name",Name.getText().toString());
                intent.putExtra("age",Age.getText().toString());
                startActivity(intent);
            }
        });

    }

}
