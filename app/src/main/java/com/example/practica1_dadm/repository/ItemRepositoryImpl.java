package com.example.practica1_dadm.repository;

import com.example.practica1_dadm.database.dao.ItemDAO;
import com.example.practica1_dadm.database.entity.DatabaseItem;

import java.util.List;

public class ItemRepositoryImpl implements ItemRepository{
    ItemDAO dao;

    public ItemRepositoryImpl(ItemDAO dao){
        this.dao = dao;
    }

    @Override
    public List<DatabaseItem> getAllItems() {
        return dao.getAll();
    }

    @Override
    public DatabaseItem findItemById(int idxItem) {
        return dao.findByIdx(idxItem);
    }

    @Override
    public void InsertItem(DatabaseItem databaseItem) {
        dao.Insert(databaseItem);
    }

    @Override
    public void UpdateItem(DatabaseItem databaseItem) {
        dao.Update(databaseItem);
    }

    @Override
    public void DeleteItem(DatabaseItem databaseItem) {
        dao.Delete(databaseItem);
    }
}
