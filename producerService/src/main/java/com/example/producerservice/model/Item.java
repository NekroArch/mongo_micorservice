package com.example.producerservice.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String id;

    private String name;
    private int quantity;
    private String category;

}
