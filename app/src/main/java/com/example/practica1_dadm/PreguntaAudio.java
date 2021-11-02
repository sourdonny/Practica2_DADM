package com.example.practica1_dadm;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.practica1_dadm.database.entity.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PreguntaAudio extends Fragment {

    MediaPlayer audioQuestion;
    MediaPlayer audios[] = new MediaPlayer[10];
    Button play_pause;
    FragmentManager fm;

    Button[] botones = new Button[4];
    Item item = new Item();
    private TextView pregunta;
    private TextView puntos;
    private ImageView imagen;
    List<Integer> respuestas = new ArrayList<>();
    protected int idCorrect;
    private int pregTotales = 0;
    private int pts = 0;

    int posicion = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pregunta_audio, container, false);

        play_pause = (Button) root.findViewById(R.id.playButton);
        audios[0] = MediaPlayer.create(getActivity(), R.raw.blackcatcher);
        audios[1] = MediaPlayer.create(getActivity(), R.raw.shinebakugo);
        audios[2] = MediaPlayer.create(getActivity(), R.raw.kageyamabaka);
        audios[3] = MediaPlayer.create(getActivity(), R.raw.longhopephilia);
        audios[4] = MediaPlayer.create(getActivity(), R.raw.mayday);
        audios[5] = MediaPlayer.create(getActivity(), R.raw.again);
        audios[6] = MediaPlayer.create(getActivity(), R.raw.gurenge);
        audios[7] = MediaPlayer.create(getActivity(), R.raw.zawarudo);
        audios[8] = MediaPlayer.create(getActivity(), R.raw.giornostheme);
        audios[9] = MediaPlayer.create(getActivity(), R.raw.departure);

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

        play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayPausa(view);
            }
        });

        // Inflate the layout for this fragment
        return root;
    }

    public void PlayPausa(View view){
        if(audioQuestion.isPlaying()){
            audioQuestion.pause();
            //((Pregunta) getActivity()).pararMusic();
            play_pause.setBackgroundResource(R.drawable.pressed_playaudio_button_effect);
        } else {
            audioQuestion.start();
            //((Pregunta) getActivity()).pararMusic();
            play_pause.setBackgroundResource(R.drawable.pressed_pauseaudio_button_effect);
        }
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
            }, 20000);
            audioQuestion.stop();
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
                        imagen.setAlpha(0f);
                    }
                }
            }, 20000);

            audioQuestion.stop();
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
                audioQuestion = audios[0];
                break;
            case 13:
                audioQuestion = audios[1];
                break;
            case 14:
                audioQuestion = audios[9];
                break;
            case 15:
                audioQuestion = audios[2];
                break;
            case 16:
                audioQuestion = audios[3];
                break;
            case 17:
                audioQuestion = audios[4];
                break;
            case 18:
                audioQuestion = audios[5];
                break;
            case 19:
                audioQuestion = audios[6];
                break;
            case 20:
                audioQuestion = audios[7];
                break;
            case 21:
                audioQuestion = audios[8];
                break;
        }

        return idxCorrect;
    }
}
