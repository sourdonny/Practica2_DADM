package com.example.practica1_dadm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class Name extends AppCompatActivity {

    Button empezarButton;
    AppCompatEditText nombreEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        nombreEditText = (AppCompatEditText) findViewById(R.id.nombreEditText);

        empezarButton = findViewById(R.id.empezarButton);
        empezarButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(nombreEditText.getText().toString().isEmpty()){
                    Toast.makeText(Name.this, "Que pongas tu nombre -_-", Toast.LENGTH_SHORT).show();
                }
                else{
                    Empezar(view);
                }
            }
        });
    }

    public void Empezar(View view){
        Intent preguntas = new Intent(this, Pregunta.class);
        //preguntas.putExtra("nombre", nombreEditText.toString());
        startActivity(preguntas);
        finish();
    }
}