package com.example.hoon.quiz;

import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;



public class MainActivity extends AppCompatActivity {

    static int AUDIO_ID_1;
    static int AUDIO_ID_2;
    MediaPlayer mediaPlayer;
    LinearLayout layout;
    LinearLayout layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout)findViewById(R.id.audio1);
        String tag = (String)layout.getTag();
        AUDIO_ID_1 = getResources().getIdentifier(tag,"raw",getPackageName());

        layout2 = (LinearLayout)findViewById(R.id.audio2);
        tag = (String)layout2.getTag();
        AUDIO_ID_2 = getResources().getIdentifier(tag,"raw",getPackageName());
    }

    public void play(View view) throws Exception
    {
        KillMedia();
        mediaPlayer = new MediaPlayer();
        AssetFileDescriptor afd;
        if(view.getId() == R.id.audio1)
        {
            afd = getResources().openRawResourceFd(AUDIO_ID_1);
            mediaPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getDeclaredLength());
            layout.setBackgroundColor(Color.GRAY);
            layout2.setBackgroundColor(Color.WHITE);
        }
        else if(view.getId() == R.id.audio2)
        {
            afd = getResources().openRawResourceFd(AUDIO_ID_2);
            mediaPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getDeclaredLength());
            layout.setBackgroundColor(Color.WHITE);
            layout2.setBackgroundColor(Color.GRAY);
        }
        mediaPlayer.prepare();
        mediaPlayer.start();
    }

    private void KillMedia()
    {
        if(mediaPlayer != null)
        {
            try {
                mediaPlayer.release();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
