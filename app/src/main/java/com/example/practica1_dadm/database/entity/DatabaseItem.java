package com.example.practica1_dadm.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

    @Entity(tableName = "PREGUNTA")
public class DatabaseItem {

    @PrimaryKey(autoGenerate = true)
    int idxPregunta;

    @ColumnInfo(name = "titulo")
    String titulo;

    @ColumnInfo(name = "respuesta1")
    String respuesta1;

    @ColumnInfo(name = "respuesta2")
    String respuesta2;

    @ColumnInfo(name = "respuesta3")
    String respuesta3;

    @ColumnInfo(name = "respuesta4")
    String respuesta4;

    @ColumnInfo(name = "respuestaCorrecta")
    String respuestaCorrecta;

    public int getIdxPregunta() {
        return idxPregunta;
    }

    public void setIdxPregunta(int idxPregunta) {
        this.idxPregunta = idxPregunta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public String getRespuesta4() {
        return respuesta4;
    }

    public void setRespuesta4(String respuesta4) {
        this.respuesta4 = respuesta4;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
}
