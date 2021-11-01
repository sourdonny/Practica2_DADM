package com.example.practica1_dadm.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

    @Entity(tableName = "PREGUNTA")
    public class Item {

    @PrimaryKey(autoGenerate = false)
    int idxPregunta;

    @ColumnInfo(name = "titulo")
    int titulo;

    @ColumnInfo(name = "respuesta1")
    int respuesta1;

    @ColumnInfo(name = "respuesta2")
    int respuesta2;

    @ColumnInfo(name = "respuesta3")
    int respuesta3;

    @ColumnInfo(name = "respuesta4")
    int respuesta4;

    @ColumnInfo(name = "respuestaCorrecta")
    int respuestaCorrecta;

    @ColumnInfo(name = "tipoPregunta")
    int tipoPregunta;

        public int getTipoPregunta() {
            return tipoPregunta;
        }

        public void setTipoPregunta(int tipoPregunta) {
            this.tipoPregunta = tipoPregunta;
        }

        public int getIdxPregunta() {
            return idxPregunta;
        }

        public void setIdxPregunta(int idxPregunta) {
            this.idxPregunta = idxPregunta;
        }

        public int getTitulo() {
            return titulo;
        }

        public void setTitulo(int titulo) {
            this.titulo = titulo;
        }

        public int getRespuesta1() {
            return respuesta1;
        }

        public void setRespuesta1(int respuesta1) {
            this.respuesta1 = respuesta1;
        }

        public int getRespuesta2() {
            return respuesta2;
        }

        public void setRespuesta2(int respuesta2) {
            this.respuesta2 = respuesta2;
        }

        public int getRespuesta3() {
            return respuesta3;
        }

        public void setRespuesta3(int respuesta3) {
            this.respuesta3 = respuesta3;
        }

        public int getRespuesta4() {
            return respuesta4;
        }

        public void setRespuesta4(int respuesta4) {
            this.respuesta4 = respuesta4;
        }

        public int getRespuestaCorrecta() {
            return respuestaCorrecta;
        }

        public void setRespuestaCorrecta(int respuestaCorrecta) {
            this.respuestaCorrecta = respuestaCorrecta;
        }

    }
