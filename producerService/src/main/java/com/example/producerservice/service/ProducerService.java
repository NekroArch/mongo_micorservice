package com.example.producerservice.service;

import com.example.producerservice.model.Item;

import java.util.List;

public interface ProducerService {
    List<Item> getAll();

    void save(Item item);
}
