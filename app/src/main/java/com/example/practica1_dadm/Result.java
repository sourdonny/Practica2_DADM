package com.example.practica1_dadm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;

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

        referenciasCompartidas();

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

    public void referenciasCompartidas(){
        SharedPreferences ajustes = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = ajustes.edit();
        String[] nombres = new String[6];
        int[] pregAcert = new int[6];

        for(int i = 0; i < 5; i++){
            nombres[i] = ajustes.getString("nombres" + i, "");
            pregAcert[i] = ajustes.getInt("acert" + i, -1);
        }

        nombres[5] = nombre;
        pregAcert[5] = acertadas;

        for(int i = 0; i < 5; i++){
            for(int j = i+1; j < 6; j++){
                if(pregAcert[i] < pregAcert[j]){
                    int aux = pregAcert[i];
                    pregAcert[i] = pregAcert[j];
                    pregAcert[j] = aux;
                    String s = nombres[i];
                    nombres[i] = nombres[j];
                    nombres[j] = s;
                }
            }
        }

        for(int i = 0; i < 5; i++){
            editor.putInt("acert" + i, pregAcert[i]);
            editor.putString("nombres" + i, nombres[i]);
            editor.commit();
        }

    }


}