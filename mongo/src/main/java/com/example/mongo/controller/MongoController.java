package com.example.mongo.controller;

import com.example.mongo.model.Item;
import com.example.mongo.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-mongo")
public class MongoController {

    @Autowired
    MongoService mongoTestService;

    @GetMapping()
    public List<Item> getAll(){
        return mongoTestService.getAll();
    }

    @PostMapping("/{count}")
    public void saveForCount(@PathVariable Integer count){
        mongoTestService.save(count);
    }

    @PostMapping()
    public void save(@RequestBody Item item){
        mongoTestService.save(item);
    }

}
