package ru.geekbrains.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Product {

    private Long id;
    private String title;
    private int cost;

}
