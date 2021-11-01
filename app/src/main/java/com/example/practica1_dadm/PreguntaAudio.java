package com.example.practica1_dadm;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

public class PreguntaAudio extends Fragment {

    MediaPlayer audioQuestion;
    Button play_pause;
    FragmentManager fm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pregunta_audio, container, false);

        //audioQuestion = MediaPlayer.create(PreguntaAudio.this, R.raw.resultmusic);
        play_pause = (Button) view.findViewById(R.id.playButton);

        // Inflate the layout for this fragment
        return view;
    }

    public void Play(View v){

    }
}
