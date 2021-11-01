package com.example.practica1_dadm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class Ajustes extends AppCompatActivity {

    //Audio
    MediaPlayer mp;
    SeekBar volumenSB;
    AudioManager am;

    //Número de preguntas
    Button button5;
    Button button10;
    Button button15;
    int numPreguntas = 0;

    Button menuPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        volumenSB = findViewById(R.id.volumenSeekBar);
        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        button5 = findViewById(R.id.fiveQuestionsButton);
        button10 = findViewById(R.id.tenQuestionsButton);
        button15 = findViewById(R.id.fifteenQuestionsButton);

        menuPrincipal = findViewById(R.id.menuPrincipalButton2);

        button5.setBackgroundResource(R.drawable.fivebuttonspressedbox);

        //Volumen
        int maxVolume = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        //Volumen actual
        int currentVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);

        volumenSB.setMax(maxVolume);
        volumenSB.setProgress(currentVolume);

        volumenSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numPreguntas = 5;
                button5.setBackgroundResource(R.drawable.fivebuttonspressedbox);
                button10.setBackgroundResource(R.drawable.tenbuttonsbox);
                button15.setBackgroundResource(R.drawable.fifteenbuttonsbox);
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numPreguntas = 10;
                button5.setBackgroundResource(R.drawable.fivebuttonbox);
                button10.setBackgroundResource(R.drawable.tenbuttonpressedbox);
                button15.setBackgroundResource(R.drawable.fifteenbuttonsbox);
            }
        });

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numPreguntas = 15;
                button5.setBackgroundResource(R.drawable.fivebuttonbox);
                button10.setBackgroundResource(R.drawable.tenbuttonsbox);
                button15.setBackgroundResource(R.drawable.fifteenbuttonpressedbox);
            }
        });

        menuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuPrincipal = new Intent(Ajustes.this, MainActivity.class);
                menuPrincipal.putExtra("numPreguntas", numPreguntas);
                startActivity(menuPrincipal);
                finish();
            }
        });
    }
}