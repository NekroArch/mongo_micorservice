package com.example.mongo.repository;

import com.example.mongo.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoCrudRepository extends MongoRepository<Item, String> {
}
