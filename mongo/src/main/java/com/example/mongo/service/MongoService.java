package com.example.mongo.service;

import com.example.mongo.model.Item;
import com.example.mongo.repository.MongoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoService {

    @Autowired
    MongoCrudRepository repository;

    public void save(Item item) {
        repository.save(item);
    }

    public void save(Integer count) {

        Item build = Item.builder().name("1").category("1").quantity(1).build();

        for (int i = 0; i < count; i++) {
            repository.save(build);
        }
    }

    public List<Item> getAll() {
        return repository.findAll();
    }
}
