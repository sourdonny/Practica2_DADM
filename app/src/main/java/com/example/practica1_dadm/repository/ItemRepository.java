package com.example.practica1_dadm.repository;

import com.example.practica1_dadm.database.entity.Item;

import java.util.List;

public interface ItemRepository {
    List<Item> getAllItems();
    Item findItemById(int idxItem);
    void InsertItem(Item item);
    void UpdateItem(Item item);
    void DeleteItem(Item item);
}
