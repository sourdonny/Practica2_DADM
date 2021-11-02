package com.example.practica1_dadm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    public String nombre = "Default Name";
    public int acertadas = 0;
    public int numPreguntas2 = 0;

    private TextView nombreJugador;
    private TextView puntuacion;
    MediaPlayer resultmusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultmusic = MediaPlayer.create(Result.this, R.raw.resultmusic);
        resultmusic.start();

        nombreJugador = (TextView)findViewById(R.id.textView4);
        puntuacion = (TextView)findViewById(R.id.textView);
        nombre = getIntent().getStringExtra("nombre");
        acertadas = getIntent().getIntExtra("preguntasAcertadas", 5);
        numPreguntas2 = getIntent().getIntExtra("numPreguntas2", 5);
        nombreJugador.setText("JUGADOR: \n" + nombre);
        puntuacion.setText(acertadas + "/" + numPreguntas2);
    }

    public void VolverMenuPrincipal(View view){
        Intent menuPrincipal = new Intent(Result.this, MainActivity.class);
        resultmusic.stop();
        startActivity(menuPrincipal);
        finish();
    }

    public void VolverAJugar(View view){
        Intent menuPrincipal = new Intent(Result.this, Name.class);
        resultmusic.stop();
        startActivity(menuPrincipal);
        finish();
    }


}