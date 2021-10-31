package com.example.practica1_dadm.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.practica1_dadm.database.entity.Item;

import java.util.List;

@Dao
public interface ItemDAO {
    @Query("select * from PREGUNTA")
    List<Item> getAll();

    @Query("select * from PREGUNTA where idxPregunta = :idxPregunta")
    Item findByIdx(int idxPregunta);

    @Insert
    void Insert(Item item);

    @Update
    void Update(Item item);

    @Delete
    void Delete(Item item);
}
