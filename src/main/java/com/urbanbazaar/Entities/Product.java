package com.urbanbazaar.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="product")
@Getter
@ToString
@RequiredArgsConstructor
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String type;
    private String title;
    private double price;
    private String description;
    private String image_url;
}
