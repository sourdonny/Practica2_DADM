package com.example.practica1_dadm.repository;

import com.example.practica1_dadm.database.entity.DatabaseItem;

import java.util.List;

public interface ItemRepository {
    List<DatabaseItem> getAllItems();
    DatabaseItem findItemById(int idxItem);
    void InsertItem(DatabaseItem databaseItem);
    void UpdateItem(DatabaseItem databaseItem);
    void DeleteItem(DatabaseItem databaseItem);
}
