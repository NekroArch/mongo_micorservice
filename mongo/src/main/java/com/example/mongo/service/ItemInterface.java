package com.example.mongo.service;

import com.example.mongo.model.Item;

import java.util.List;

public interface ItemInterface {
    void save(Item item);

    List<Item> getAll();
}
