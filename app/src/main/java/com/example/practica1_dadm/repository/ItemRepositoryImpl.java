package com.example.practica1_dadm.repository;

import com.example.practica1_dadm.database.dao.ItemDAO;
import com.example.practica1_dadm.database.entity.Item;

import java.util.List;

public class ItemRepositoryImpl implements ItemRepository{
    ItemDAO dao;

    public ItemRepositoryImpl(ItemDAO dao){
        this.dao = dao;
    }

    @Override
    public List<Item> getAllItems() {
        return dao.getAll();
    }

    @Override
    public Item findItemById(int idxItem) {
        return dao.findByIdx(idxItem);
    }

    @Override
    public void InsertItem(Item item) {
        dao.Insert(item);
    }

    @Override
    public void UpdateItem(Item item) {
        dao.Update(item);
    }

    @Override
    public void DeleteItem(Item item) {
        dao.Delete(item);
    }
}
