package com.example.practica1_dadm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ranking extends AppCompatActivity {

    TextView[] rankingN = new TextView[5];
    TextView[] rankingP = new TextView[5];
    Button menuPrincipal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        rankingN[0] = (TextView) findViewById(R.id.puesto1nombre);
        rankingN[1] = (TextView) findViewById(R.id.puesto2nombre);
        rankingN[2] = (TextView) findViewById(R.id.puesto3nombre);
        rankingN[3] = (TextView) findViewById(R.id.puesto4nombre);
        rankingN[4] = (TextView) findViewById(R.id.puesto5nombre);

        rankingP[0] = (TextView) findViewById(R.id.puesto1puntos);
        rankingP[1] = (TextView) findViewById(R.id.puesto2puntos);
        rankingP[2] = (TextView) findViewById(R.id.puesto3puntos);
        rankingP[3] = (TextView) findViewById(R.id.puesto4puntos);
        rankingP[4] = (TextView) findViewById(R.id.puesto5puntos);

        menuPrincipal = findViewById(R.id.menuPrincipalButton2);

        SharedPreferences ajustes = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = ajustes.edit();
        String[] nombres = new String[6];
        int[] pregAcert = new int[6];

        for(int i = 0; i < 5; i++){
            nombres[i] = ajustes.getString("nombres" + i, "");
            pregAcert[i] = ajustes.getInt("acert" + i, -1);
        }

        for(int i = 0; i < 5; i++){
            rankingN[i].setText(nombres[i]);
            rankingP[i].setText(Integer.toString(pregAcert[i]));
        }

        menuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuPrincipal = new Intent(Ranking.this, MainActivity.class);
                startActivity(menuPrincipal);
                finish();
            }
        });
    }
}