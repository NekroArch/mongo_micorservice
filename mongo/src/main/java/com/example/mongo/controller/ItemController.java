package com.example.mongo.controller;

import com.example.mongo.model.Item;
import com.example.mongo.service.ItemInterface;
import com.example.mongo.service.impl.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-mongo")
public class ItemController {

    @Autowired
    ItemInterface itemInterface;

    @GetMapping()
    public List<Item> getAll(){
        return itemInterface.getAll();
    }

    @PostMapping()
    public void save(@RequestBody Item item){
        itemInterface.save(item);
    }
}
