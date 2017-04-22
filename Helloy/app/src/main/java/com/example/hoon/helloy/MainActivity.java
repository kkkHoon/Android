package com.example.hoon.helloy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    RadioGroup radio;
    RadioButton man_button;
    RadioButton woman_button;
    CheckBox sms_box;
    CheckBox mail_box;

    String spam_str;
    String gender_str;
    String name_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.editName);
        radio = (RadioGroup)findViewById(R.id.radio);
        man_button = (RadioButton)findViewById(R.id.Mr);
        woman_button = (RadioButton)findViewById(R.id.Ms);
        sms_box = (CheckBox)findViewById(R.id.sms);
        mail_box = (CheckBox)findViewById(R.id.mail);

        spam_str = "";
        gender_str = "";
        name_str = "";

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(name_check())
                    warning("Please insert your name");
                else if(gender_check())
                    warning("Please check your gender type");
                else
                {
                    name_str = editText.getText().toString();

                    if(man_button.isChecked())
                        gender_str = "남";
                    else
                        gender_str = "여";

                    if(sms_box.isChecked() && mail_box.isChecked())
                        spam_str = "SMS & e-mail";
                    else if(sms_box.isChecked())
                        spam_str = "SMS";
                    else if(mail_box.isChecked())
                        spam_str = "e-mail";
                    else
                        spam_str = "Nothing";

                    Bundle bundle = new Bundle();
                    bundle.putString("name",name_str);
                    bundle.putString("gender",gender_str);
                    bundle.putString("spam",spam_str);
                    Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean name_check()
    {
        return editText.getText().toString().isEmpty();
    }
    private boolean gender_check()
    {
        if(radio.getCheckedRadioButtonId() == -1)
            return true;
        else
            return false;
    }
    private void warning(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }

}
