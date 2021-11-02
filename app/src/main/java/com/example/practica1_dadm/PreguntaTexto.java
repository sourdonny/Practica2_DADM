package com.example.practica1_dadm;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practica1_dadm.database.entity.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PreguntaTexto extends Fragment {

    Button[] botones = new Button[4];
    Item item = new Item();
    private TextView pregunta;
    private TextView puntos;
    private ImageView imagen;
    List<Integer> respuestas = new ArrayList<>();
    protected int idCorrect;
    private int pregTotales = 0;
    private int pts = 0;
    ImageView[] imagenes = new ImageView[12];
    ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pregunta_texto, container, false);

        //imagenes[0] = ImageView.create(getActivity(), R.raw.blackcatcher);
        //////////////////////////////AQUI LAS IMAGENES/////////////




        ///////////////////////////////////////////////////////////


        idCorrect = 0;
        botones[0] = (Button) root.findViewById(R.id.respuesta1Button);
        botones[1] = (Button) root.findViewById(R.id.respuesta2Button);
        botones[2] = (Button) root.findViewById(R.id.respuesta3Button);
        botones[3] = (Button) root.findViewById(R.id.respuesta4Button);

        pregunta = (TextView) root.findViewById(R.id.tituloTextView);
        //puntos = (TextView) root.findViewById(R.id.puntosTextView);
        imagen = (ImageView) root.findViewById(R.id.tituloImageView);

        item = ((Pregunta)getActivity()).items.get(0);
        pregTotales = ((Pregunta)getActivity()).idxpreguntaActual;
        pts = ((Pregunta) getActivity()).puntos;

        respuestas.add(item.getRespuesta1());
        respuestas.add(item.getRespuesta2());
        respuestas.add(item.getRespuesta3());
        respuestas.add(item.getRespuesta4());

        idCorrect = config(item.getIdxPregunta(), respuestas);

        img = (ImageView) root.findViewById((R.id.personajeImageView));     // Aqui meto la imagen en el coso de imagenes del layout

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


        // Inflate the layout for this fragment
        return root;
    }

    public void Resolucion(int id){
        for(int i = 0; i < botones.length; i++){
            botones[i].setEnabled(false);
        }
        if(pregTotales < ((Pregunta)getActivity()).getNumPreguntas2()) {
            if (id == idCorrect) {
                ((Pregunta) getActivity()).acertado();
                botones[id].setBackgroundColor(Color.GREEN);
            } else {
                ((Pregunta) getActivity()).fallado();
                botones[id].setBackgroundColor(Color.RED);
            }
            pregTotales++;

            botones[id].postDelayed(new Runnable() {
                @Override
                public void run() {
                    idCorrect = config(item.getTitulo(), respuestas);
                    if(pregTotales == 4){
                        imagen.setAlpha(1f);
                    }
                }
            }, 2000);
            ((Pregunta) getActivity()).next();

        }else {
            if (id == idCorrect) {
                ((Pregunta) getActivity()).acertado();
                botones[id].setBackgroundColor(Color.GREEN);
            } else {
                ((Pregunta) getActivity()).fallado();
                botones[id].setBackgroundColor(Color.RED);
            }

            botones[id].postDelayed(new Runnable() {
                @Override
                public void run() {
                    idCorrect = config(item.getTitulo(), respuestas);
                    if(item.getIdxPregunta() == 4){
                        imagen.setAlpha(1f);
                    }
                }
            }, 2000);

            ((Pregunta) getActivity()).changeActivity();
        }

    }

    private int config(int preguntaActual, List<Integer> rspst){
        pregunta.setText(item.getTitulo());
        int rspstCorrect = item.getRespuestaCorrecta();
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

        switch (item.getIdxPregunta()){
            case 12:
                img = imagenes[0];
                break;
            case 13:
                img = imagenes[1];
                break;
            case 14:
                img = imagenes[9];
                break;
            case 15:
                img = imagenes[2];
                break;
            case 16:
                img = imagenes[3];
                break;
            case 17:
                img = imagenes[4];
                break;
            case 18:
                img = imagenes[5];
                break;
            case 19:
                img = imagenes[6];
                break;
            case 20:
                img = imagenes[7];
                break;
            case 21:
                img = imagenes[8];
                break;
        }

        return idxCorrect;
    }

}