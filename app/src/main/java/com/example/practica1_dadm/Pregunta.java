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
import com.example.practica1_dadm.database.entity.DatabaseItem;
import com.example.practica1_dadm.database.entity.Item;
import com.example.practica1_dadm.repository.ItemRepositoryImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Pregunta extends AppCompatActivity {

    int numPreguntas2;
    List<Item> items;
    public int idxpreguntaActual = 1;
    public int preguntasAcertadas = 0;
    public int preguntasFalladas = 0;
    int puntos;
    public String nombreJugador;
    MediaPlayer gameMusic;
    private TextView acertadas;
    private TextView falladas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);

        gameMusic = MediaPlayer.create(Pregunta.this, R.raw.questionmusic);
        //gameMusic.start();

        acertadas = (TextView) findViewById(R.id.textAcertadas);
        falladas = (TextView) findViewById(R.id.textFalladas);
        nombreJugador = getIntent().getStringExtra("nombre");
        numPreguntas2 = getIntent().getIntExtra("numPreguntas", 5);
        acertadas.setText(preguntasAcertadas + "/" + numPreguntas2);
        falladas.setText(preguntasFalladas + "/" + numPreguntas2);

        AppDatabase db = AppDatabase.GetInstance(this.getApplicationContext());
        ItemDAO dao = db.itemDAO();
        ItemRepositoryImpl repo = new ItemRepositoryImpl(dao);

        //repo = GeneratePreguntas(repo);
        idxpreguntaActual = 1;

        items = repo.getAllItems();

        Collections.shuffle(items);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        switch(items.get(0).getTipoPregunta()) {
            case 0:
                ft.replace(R.id.preguntaFrameLayout, new PreguntaTexto());
                break;
            case 1:
                ft.replace(R.id.preguntaFrameLayout, new PreguntaAudio());
                break;
        }
        ft.commit();
    }

    public void next(){
        acertadas.setText(preguntasAcertadas + "/" + numPreguntas2);
        falladas.setText(preguntasFalladas + "/" + numPreguntas2);
        FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
        idxpreguntaActual++;
        items.remove(0);
        switch(items.get(0).getTipoPregunta()) {
            case 0:
                fts.replace(R.id.preguntaFrameLayout, new PreguntaTexto());
                break;

            case 1:
                fts.replace(R.id.preguntaFrameLayout, new PreguntaAudio());
                break;
        }
        fts.commit();
    }

    public void acertado(){
        preguntasAcertadas++;
    }

    public void fallado(){
        preguntasFalladas++;
    }

    public int getNumPreguntas2(){
        return numPreguntas2;
    }

/*public void pararMusic(){
        if(gameMusic.isPlaying()){
            gameMusic.pause();
        } else {
            gameMusic.start();
        }
    }*/

    public ItemRepositoryImpl GeneratePreguntas(ItemRepositoryImpl repo){

        Item item = new Item();
        item.setIdxPregunta(0);
        item.setTitulo(R.string.pregunta1);
        item.setRespuesta1(R.string.respuesta11);
        item.setRespuesta2(R.string.respuesta12);
        item.setRespuesta3(R.string.respuesta13);
        item.setRespuesta4(R.string.respuesta14);
        item.setRespuestaCorrecta(R.string.respuesta11);
        item.setTipoPregunta(0);
        repo.InsertItem(item);

        item.setIdxPregunta(1);
        item.setTitulo(R.string.pregunta2);
        item.setRespuesta1(R.string.respuesta21);
        item.setRespuesta2(R.string.respuesta22);
        item.setRespuesta3(R.string.respuesta23);
        item.setRespuesta4(R.string.respuesta24);
        item.setRespuestaCorrecta(R.string.respuesta21);
        item.setTipoPregunta(0);
        repo.InsertItem(item);

        item.setIdxPregunta(2);
        item.setTitulo(R.string.pregunta3);
        item.setRespuesta1(R.string.respuesta31);
        item.setRespuesta2(R.string.respuesta32);
        item.setRespuesta3(R.string.respuesta33);
        item.setRespuesta4(R.string.respuesta34);
        item.setRespuestaCorrecta(R.string.respuesta31);
        item.setTipoPregunta(0);
        repo.InsertItem(item);

        item.setIdxPregunta(3);
        item.setTitulo(R.string.pregunta4);
        item.setRespuesta1(R.string.respuesta41);
        item.setRespuesta2(R.string.respuesta42);
        item.setRespuesta3(R.string.respuesta43);
        item.setRespuesta4(R.string.respuesta44);
        item.setRespuestaCorrecta(R.string.respuesta41);
        item.setTipoPregunta(0);
        repo.InsertItem(item);

        item.setIdxPregunta(4);
        item.setTitulo(R.string.pregunta5);
        item.setRespuesta1(R.string.respuesta51);
        item.setRespuesta2(R.string.respuesta52);
        item.setRespuesta3(R.string.respuesta53);
        item.setRespuesta4(R.string.respuesta54);
        item.setRespuestaCorrecta(R.string.respuesta51);
        item.setTipoPregunta(0);
        repo.InsertItem(item);

        item.setIdxPregunta(5);
        item.setTitulo(R.string.pregunta6);
        item.setRespuesta1(R.string.respuesta61);
        item.setRespuesta2(R.string.respuesta62);
        item.setRespuesta3(R.string.respuesta63);
        item.setRespuesta4(R.string.respuesta64);
        item.setRespuestaCorrecta(R.string.respuesta61);
        item.setTipoPregunta(0);
        repo.InsertItem(item);

        item.setIdxPregunta(6);
        item.setTitulo(R.string.pregunta7);
        item.setRespuesta1(R.string.respuesta71);
        item.setRespuesta2(R.string.respuesta72);
        item.setRespuesta3(R.string.respuesta73);
        item.setRespuesta4(R.string.respuesta74);
        item.setRespuestaCorrecta(R.string.respuesta71);
        item.setTipoPregunta(0);
        repo.InsertItem(item);

        item.setIdxPregunta(7);
        item.setTitulo(R.string.pregunta8);
        item.setRespuesta1(R.string.respuesta81);
        item.setRespuesta2(R.string.respuesta82);
        item.setRespuesta3(R.string.respuesta83);
        item.setRespuesta4(R.string.respuesta84);
        item.setRespuestaCorrecta(R.string.respuesta81);
        item.setTipoPregunta(0);
        repo.InsertItem(item);

        item.setIdxPregunta(8);
        item.setTitulo(R.string.pregunta9);
        item.setRespuesta1(R.string.respuesta91);
        item.setRespuesta2(R.string.respuesta92);
        item.setRespuesta3(R.string.respuesta93);
        item.setRespuesta4(R.string.respuesta94);
        item.setRespuestaCorrecta(R.string.respuesta91);
        item.setTipoPregunta(0);
        repo.InsertItem(item);

        item.setIdxPregunta(9);
        item.setTitulo(R.string.pregunta10);
        item.setRespuesta1(R.string.respuesta101);
        item.setRespuesta2(R.string.respuesta102);
        item.setRespuesta3(R.string.respuesta103);
        item.setRespuesta4(R.string.respuesta104);
        item.setRespuestaCorrecta(R.string.respuesta101);
        item.setTipoPregunta(0);
        repo.InsertItem(item);

        item.setIdxPregunta(10);
        item.setTitulo(R.string.pregunta11);
        item.setRespuesta1(R.string.respuesta111);
        item.setRespuesta2(R.string.respuesta112);
        item.setRespuesta3(R.string.respuesta113);
        item.setRespuesta4(R.string.respuesta114);
        item.setRespuestaCorrecta(R.string.respuesta111);
        item.setTipoPregunta(0);
        repo.InsertItem(item);

        item.setIdxPregunta(11);
        item.setTitulo(R.string.pregunta12);
        item.setRespuesta1(R.string.respuesta121);
        item.setRespuesta2(R.string.respuesta122);
        item.setRespuesta3(R.string.respuesta123);
        item.setRespuesta4(R.string.respuesta124);
        item.setRespuestaCorrecta(R.string.respuesta121);
        item.setTipoPregunta(0);
        repo.InsertItem(item);

        item.setIdxPregunta(12);
        item.setTitulo(R.string.pregunta13);
        item.setRespuesta1(R.string.respuesta131);
        item.setRespuesta2(R.string.respuesta132);
        item.setRespuesta3(R.string.respuesta133);
        item.setRespuesta4(R.string.respuesta134);
        item.setRespuestaCorrecta(R.string.respuesta131);
        item.setTipoPregunta(1);
        repo.InsertItem(item);

        item.setIdxPregunta(13);
        item.setTitulo(R.string.pregunta14);
        item.setRespuesta1(R.string.respuesta141);
        item.setRespuesta2(R.string.respuesta142);
        item.setRespuesta3(R.string.respuesta143);
        item.setRespuesta4(R.string.respuesta144);
        item.setRespuestaCorrecta(R.string.respuesta141);
        item.setTipoPregunta(1);
        repo.InsertItem(item);

        item.setIdxPregunta(14);
        item.setTitulo(R.string.pregunta15);
        item.setRespuesta1(R.string.respuesta151);
        item.setRespuesta2(R.string.respuesta152);
        item.setRespuesta3(R.string.respuesta153);
        item.setRespuesta4(R.string.respuesta154);
        item.setRespuestaCorrecta(R.string.respuesta151);
        item.setTipoPregunta(1);
        repo.InsertItem(item);

        item.setIdxPregunta(15);
        item.setTitulo(R.string.pregunta15);
        item.setRespuesta1(R.string.respuesta161);
        item.setRespuesta2(R.string.respuesta162);
        item.setRespuesta3(R.string.respuesta163);
        item.setRespuesta4(R.string.respuesta164);
        item.setRespuestaCorrecta(R.string.respuesta161);
        item.setTipoPregunta(1);
        repo.InsertItem(item);

        item.setIdxPregunta(16);
        item.setTitulo(R.string.pregunta17);
        item.setRespuesta1(R.string.respuesta171);
        item.setRespuesta2(R.string.respuesta172);
        item.setRespuesta3(R.string.respuesta173);
        item.setRespuesta4(R.string.respuesta174);
        item.setRespuestaCorrecta(R.string.respuesta171);
        item.setTipoPregunta(1);
        repo.InsertItem(item);

        item.setIdxPregunta(17);
        item.setTitulo(R.string.pregunta18);
        item.setRespuesta1(R.string.respuesta181);
        item.setRespuesta2(R.string.respuesta182);
        item.setRespuesta3(R.string.respuesta183);
        item.setRespuesta4(R.string.respuesta184);
        item.setRespuestaCorrecta(R.string.respuesta181);
        item.setTipoPregunta(1);
        repo.InsertItem(item);

        item.setIdxPregunta(18);
        item.setTitulo(R.string.pregunta19);
        item.setRespuesta1(R.string.respuesta191);
        item.setRespuesta2(R.string.respuesta192);
        item.setRespuesta3(R.string.respuesta193);
        item.setRespuesta4(R.string.respuesta194);
        item.setRespuestaCorrecta(R.string.respuesta191);
        item.setTipoPregunta(1);
        repo.InsertItem(item);

        item.setIdxPregunta(19);
        item.setTitulo(R.string.pregunta20);
        item.setRespuesta1(R.string.respuesta201);
        item.setRespuesta2(R.string.respuesta202);
        item.setRespuesta3(R.string.respuesta203);
        item.setRespuesta4(R.string.respuesta204);
        item.setRespuestaCorrecta(R.string.respuesta201);
        item.setTipoPregunta(1);
        repo.InsertItem(item);

        item.setIdxPregunta(20);
        item.setTitulo(R.string.pregunta21);
        item.setRespuesta1(R.string.respuesta211);
        item.setRespuesta2(R.string.respuesta212);
        item.setRespuesta3(R.string.respuesta213);
        item.setRespuesta4(R.string.respuesta214);
        item.setRespuestaCorrecta(R.string.respuesta211);
        item.setTipoPregunta(1);
        repo.InsertItem(item);

        item.setIdxPregunta(21);
        item.setTitulo(R.string.pregunta22);
        item.setRespuesta1(R.string.respuesta221);
        item.setRespuesta2(R.string.respuesta222);
        item.setRespuesta3(R.string.respuesta223);
        item.setRespuesta4(R.string.respuesta224);
        item.setRespuestaCorrecta(R.string.respuesta221);
        item.setTipoPregunta(1);
        repo.InsertItem(item);

/*
        for(int i = 1; i < 15; i++){

            String pg = "pregunta" + i;
            String rs1 = "respuesta" + i + "1";
            String rs2 = "respuesta" + i + "2";
            String rs3 = "respuesta" + i + "3";
            String rs4 = "respuesta" + i + "4";
            String tipo = "tipoPregunta" + i;

            item.setIdxPregunta(0);
            item.setTitulo(R.string.pregunta1);
            item.setRespuesta1(R.string.respuesta11);
            item.setRespuesta2(R.string.respuesta12);
            item.setRespuesta3(R.string.respuesta13);
            item.setRespuesta4(R.string.respuesta14);
            item.setRespuestaCorrecta(R.string.respuesta11);
            item.setTipoPregunta(R.integer.tipoPregunta1);
            repo.InsertItem(item);
        }*/

        return repo;
    }

    public void changeActivity(){
        Intent result = new Intent(Pregunta.this, Result.class);
        result.putExtra("numPreguntas2", numPreguntas2);
        result.putExtra("preguntasAcertadas", preguntasAcertadas);
        result.putExtra("nombre", nombreJugador);
        //GameMusic.stop();

        startActivity(result);
        finish();
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
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            botones[id].postDelayed(new Runnable() {
                @Override
                public void run() {
                    idCorrect = config(preguntas[idxpreguntaActual], respuestas[idxpreguntaActual]);
                    if(idxpreguntaActual == 4){
                        imagen.setAlpha(1f);
                    }
                }
            }, 2000);
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        }else {
            if (id == idCorrect) {
                pts += 10;
                botones[id].setBackgroundColor(Color.GREEN);
            } else {
                botones[id].setBackgroundColor(Color.RED);
            }
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            botones[id].postDelayed(new Runnable() {
                @Override
                public void run() {
                    idCorrect = config(preguntas[idxpreguntaActual], respuestas[idxpreguntaActual]);
                    if(idxpreguntaActual == 4){
                        imagen.setAlpha(1f);
                    }
                }
            }, 2000);
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            puntos.setText("" + pts);
            Intent result = new Intent(Pregunta.this, Result.class);
            result.putExtra("puntos", "puntos");
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