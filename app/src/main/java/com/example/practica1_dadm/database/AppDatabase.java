package com.example.practica1_dadm.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.practica1_dadm.database.dao.ItemDAO;
import com.example.practica1_dadm.database.entity.Item;

@Database(entities = {
        Item.class
}, version = 1)

public abstract class AppDatabase extends RoomDatabase{
    public static AppDatabase INSTANCE;

    public abstract ItemDAO itemDAO();

    public static AppDatabase GetInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "preguntas.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return INSTANCE;
    }
}
