package com.example.producerservice.contoller;

import com.example.producerservice.model.Item;
import com.example.producerservice.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @GetMapping
    public List<Item> getAll(){
        return producerService.getAll();
    }

    @PostMapping("/{count}")
    public void saveForCount(@PathVariable Integer count){
        producerService.save(count);
    }

    @PostMapping()
    public void save(@RequestBody Item item){
        producerService.save(item);
    }
}
