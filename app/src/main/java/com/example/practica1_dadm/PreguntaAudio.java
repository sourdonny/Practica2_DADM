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
    MediaPlayer audios[] = new MediaPlayer[10];
    Button play_pause;
    FragmentManager fm;

    int posicion = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pregunta_audio, container, false);

        play_pause = (Button) view.findViewById(R.id.playButton);
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

        // Inflate the layout for this fragment
        return view;
    }

    public void PlayPausa(View view){
        if(audios[posicion].isPlaying()){
            audios[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.pressed_playaudio_button_effect);
        } else {
            audios[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pressed_pauseaudio_button_effect);
        }
    }
}
