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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleMusic = MediaPlayer.create(MainActivity.this, R.raw.titlemusic);
        titleMusic.start();

        jugar = findViewById(R.id.jugarButton);
        ajustes = findViewById(R.id.ajustesButton);
        salir = findViewById(R.id.salirButton);

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

    }

    public void Jugar(View view){
        Intent introducirNombre = new Intent(this, Name.class);
        titleMusic.stop();
        startActivity(introducirNombre);
        finish();
    }

    public void Ajustes(View view){
        Intent ajustes = new Intent(this, Ajustes.class);
        startActivity(ajustes);
        finish();
    }

    public void Salir(View view){
        titleMusic.stop();
        finish();
    }
}