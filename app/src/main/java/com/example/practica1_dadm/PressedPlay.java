package com.example.practica1_dadm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PressedPlay extends AppCompatActivity {

    Button siguienteButton;
    Fragment introductionFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressed_play);

        //introductionFragment = new Introduction();
        FragmentTransaction fm;
        getSupportFragmentManager().beginTransaction().add(R.id.pressedPlayLayout, introductionFragment).commit();

        /*
        siguienteButton = findViewById(R.id.siguienteButton);
        siguienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CambiarFragmento(new Name());
            }
        });
        */
    }

    /*
    public void CambiarFragmento(Fragment fragmento){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.pressedPlayLayout, fragmento);
        ft.commit();
    }
    */
}