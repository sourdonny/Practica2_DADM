package com.example.practica1_dadm.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.practica1_dadm.database.entity.DatabaseItem;

import java.util.List;

@Dao
public interface ItemDAO {
    @Query("select * from PREGUNTA")
    List<DatabaseItem> getAll();

    @Query("select * from PREGUNTA where idxPregunta = :idxPregunta")
    DatabaseItem findByIdx(int idxPregunta);

    @Insert
    void Insert(DatabaseItem databaseItem);

    @Update
    void Update(DatabaseItem databaseItem);

    @Delete
    void Delete(DatabaseItem databaseItem);
}
