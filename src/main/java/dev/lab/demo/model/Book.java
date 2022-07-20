package dev.lab.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private Integer id;
    private String title;
    private Integer pages;
    private Rating rating;
    private Author author;
}