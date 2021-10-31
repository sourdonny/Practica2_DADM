package com.example.practica1_dadm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    public String nombre;
    public String pts;

    private TextView nombreJugador;
    private TextView puntuacion;
    MediaPlayer resultmusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultmusic = MediaPlayer.create(Result.this, R.raw.resultmusic);
        resultmusic.start();

        nombre = getIntent().getStringExtra("nombre");
        nombreJugador = (TextView)findViewById(R.id.textView6);
        nombreJugador.setText("JUGADOR: " + nombre);

        pts = getIntent().getStringExtra("puntos");
        puntuacion = (TextView)findViewById(R.id.textView4);
        puntuacion.setText("PUNTOS" + "\n" + pts);
    }

    public void VolverMenuPrincipal(View view){
        Intent menuPrincipal = new Intent(Result.this, MainActivity.class);
        resultmusic.stop();
        startActivity(menuPrincipal);
        finish();
    }

    public void VolverAJugar(View view){
        Intent menuPrincipal = new Intent(Result.this, Pregunta.class);
        resultmusic.stop();
        startActivity(menuPrincipal);
        finish();
    }


}