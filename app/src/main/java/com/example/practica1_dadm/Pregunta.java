package com.example.practica1_dadm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practica1_dadm.database.AppDatabase;
import com.example.practica1_dadm.database.dao.ItemDAO;
import com.example.practica1_dadm.database.entity.Item;
import com.example.practica1_dadm.repository.ItemRepositoryImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Pregunta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);

        MediaPlayer gameMusic = MediaPlayer.create(Pregunta.this, R.raw.questionmusic);
        gameMusic.start();

        AppDatabase db = AppDatabase.GetInstance(this.getApplicationContext());
        ItemDAO dao = db.itemDAO();
        ItemRepositoryImpl repo = new ItemRepositoryImpl(dao);

        Item item = new Item();
        item.setTitulo("Item 1");
        item.setIdxPregunta(2);
        repo.InsertItem(item);

        List<Item> items = repo.getAllItems();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.preguntaFrameLayout, new PreguntaTexto());
        ft.commit();
    }

    /*
    AppDatabase db = AppDatabase.GetInstance(this.getApplicationContext());
    ItemDAO dao = db.itemDAO();

    public String nombreJugador;
    protected int idCorrect;
    protected int idxpreguntaActual;
    Button [] botones = new Button[4];
    int[] preguntas = new int[5];

    List<Integer> rspst1 = new ArrayList<>();
    List<Integer> rspst2 = new ArrayList<>();
    List<Integer> rspst3 = new ArrayList<>();
    List<Integer> rspst4 = new ArrayList<>();
    List<Integer> rspst5 = new ArrayList<>();
    List[] respuestas = new List[5];


    MediaPlayer GameMusic;
    public int pts = 0;

    private TextView pregunta;
    private TextView puntos;
    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);

        GameMusic = MediaPlayer.create(Pregunta.this, R.raw.questionmusic);
        GameMusic.start();

        nombreJugador = getIntent().getStringExtra("nombre");

        pregunta = (TextView)findViewById(R.id.tituloTextView);
        puntos = (TextView)findViewById(R.id.puntosTextView);
        imagen = (ImageView) findViewById(R.id.preguntaImageView);
        imagen.setAlpha(0f);

        pts = 0;
        idCorrect = 0;
        idxpreguntaActual = 0;
        botones[0] = findViewById(R.id.respuesta1Button);
        botones[1] = findViewById(R.id.respuesta4Button);
        botones[2] = findViewById(R.id.respuesta2Button);
        botones[3] = findViewById(R.id.respuesta3Button);

        preguntas[0] = R.string.pregunta1;
        preguntas[1] = R.string.pregunta2;
        preguntas[2] = R.string.pregunta3;
        preguntas[3] = R.string.pregunta4;
        preguntas[4] = R.string.pregunta5;

        rspst1.add((int) R.string.respuesta11);
        rspst1.add(R.string.respuesta12);
        rspst1.add(R.string.respuesta13);
        rspst1.add(R.string.respuesta14);

        rspst2.add(R.string.respuesta21);
        rspst2.add(R.string.respuesta22);
        rspst2.add(R.string.respuesta23);
        rspst2.add(R.string.respuesta24);

        rspst3.add(R.string.respuesta31);
        rspst3.add(R.string.respuesta32);
        rspst3.add(R.string.respuesta33);
        rspst3.add(R.string.respuesta34);

        rspst4.add(R.string.respuesta41);
        rspst4.add(R.string.respuesta42);
        rspst4.add(R.string.respuesta43);
        rspst4.add(R.string.respuesta44);

        rspst5.add(R.string.respuesta51);
        rspst5.add(R.string.respuesta52);
        rspst5.add(R.string.respuesta53);
        rspst5.add(R.string.respuesta54);

        respuestas[0] = rspst1;
        respuestas[1] = rspst2;
        respuestas[2] = rspst3;
        respuestas[3] = rspst4;
        respuestas[4] = rspst5;

        idCorrect = config(preguntas[idxpreguntaActual],respuestas[idxpreguntaActual]);

        botones[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resolucion(0);
            }
        });

        botones[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resolucion(1);
            }
        });

        botones[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resolucion(2);
            }
        });

        botones[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resolucion(3);
            }
        });
    }

    public void Resolucion(int id){
        for(int i = 0; i < botones.length; i++){
            botones[i].setEnabled(false);
        }
        if(idxpreguntaActual != preguntas.length - 1) {
            if (id == idCorrect) {
                pts += 10;
                botones[id].setBackgroundColor(Color.GREEN);
            } else {
                botones[id].setBackgroundColor(Color.RED);
            }
            idxpreguntaActual++;
            botones[id].postDelayed(new Runnable() {
                @Override
                public void run() {
                    idCorrect = config(preguntas[idxpreguntaActual], respuestas[idxpreguntaActual]);
                    if(idxpreguntaActual == 4){
                        imagen.setAlpha(1f);
                    }
                }
            }, 2000);
        }else {
            if (id == idCorrect) {
                pts += 10;
                botones[id].setBackgroundColor(Color.GREEN);
            } else {
                botones[id].setBackgroundColor(Color.RED);
            }
            botones[id].postDelayed(new Runnable() {
                @Override
                public void run() {
                    idCorrect = config(preguntas[idxpreguntaActual], respuestas[idxpreguntaActual]);
                    if(idxpreguntaActual == 4){
                        imagen.setAlpha(1f);
                    }
                }
            }, 2000);
            puntos.setText("" + pts);
            Intent result = new Intent(Pregunta.this, Result.class);
            result.putExtra("puntos", "PATATA");
            result.putExtra("nombre", nombreJugador);
            GameMusic.stop();

            startActivity(result);
            finish();
        }
        puntos.setText("" + pts);
    }

    private int config(int preguntaActual, List<Integer>  rspst){
        pregunta.setText(preguntaActual);
        int rspstCorrect = rspst.get(0);
        int idxCorrect = 0;
        Collections.shuffle(rspst);

        for(int i = 0; i<rspst.size(); i++){
            botones[i].setText(rspst.get(i));
            if(rspstCorrect == rspst.get(i)){
                idxCorrect = i;
            }
            botones[i].setBackgroundColor(Color.WHITE);
            //botones[i].setBackgroundColor(Color.alpha(0));
            botones[i].setEnabled(true);
        }

        return idxCorrect;
    }
    */
}