package dev.lab.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
public class Book {
    private Integer id;
    private String title;
    private Integer pages;
    private Rating rating;
    private Author author;
}