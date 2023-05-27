package com.example.producerservice.service.impl;

import com.example.producerservice.annotation.Log;
import com.example.producerservice.model.Item;
import com.example.producerservice.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${rest.template.url}")
    private String url;

    @Log
    public List<Item> getAll() {
        return new ArrayList<>(
                Arrays.asList(
                        Objects.requireNonNull(
                                restTemplate.getForObject(url + "/api-mongo", Item[].class)
                        )
                )
        );
    }

    @Log
    public void save(Item item) {
        restTemplate.postForEntity(url + "/api-mongo", item, Item.class);
    }

    @Log
    public void save(Integer count) {
        restTemplate.postForLocation(url + "/api-mongo/" + count , null);
    }
}
