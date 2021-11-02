package com.example.practica1_dadm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {

    MediaPlayer titleMusic;
    Button jugar;
    Button ajustes;
    Button salir;
    Button ranking;
    String numPreguntas;
    int numPreguntas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numPreguntas = getIntent().getStringExtra("numPreguntas");
        numPreguntas2 = getIntent().getIntExtra("numPreguntas", 5);
        titleMusic = MediaPlayer.create(MainActivity.this, R.raw.titlemusic);

        if(!titleMusic.isPlaying()){
            titleMusic.start();
        }

        jugar = findViewById(R.id.jugarButton);
        ajustes = findViewById(R.id.ajustesButton);
        salir = findViewById(R.id.salirButton);
        ranking = findViewById(R.id.rankingButton);

        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jugar(view);
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Salir(view);
            }
        });

        ajustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ajustes(view);
            }
        });

        ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ranking(view);
            }
        });
    }

    public void Jugar(View view){
        Intent introducirNombre = new Intent(this, Name.class);
        introducirNombre.putExtra("numPreguntas", numPreguntas);
        introducirNombre.putExtra("numPreguntas2", numPreguntas2);
        startActivity(introducirNombre);
    }

    public void Ajustes(View view){
        Intent ajustes = new Intent(this, Ajustes.class);
        startActivity(ajustes);
        //finish();
    }

    public void Salir(View view){
        titleMusic.stop();
        finish();
    }

    public void Ranking(View view){
        Intent ranking = new Intent(this, Ranking.class);
        startActivity(ranking);
    }
}