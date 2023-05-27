package com.example.mongo.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@SuperBuilder
@Getter
@Setter
@Document("items")
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    private String id;

    private String name;
    private int quantity;
    private String category;

}
