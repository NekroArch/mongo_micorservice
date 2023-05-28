package com.example.mongo.service.impl;

import com.example.mongo.model.Item;
import com.example.mongo.repository.ItemRepository;
import com.example.mongo.service.ItemInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements ItemInterface {

    @Autowired
    ItemRepository repository;

    public void save(Item item) {
        repository.save(item);
    }

    public List<Item> getAll() {
        return repository.findAll();
    }
}
