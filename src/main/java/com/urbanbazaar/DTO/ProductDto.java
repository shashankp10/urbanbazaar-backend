package com.urbanbazaar.DTO;

import lombok.Data;

@Data
public class ProductDto {
    private long id;
    private String type;
    private String title;
    private double price;
    private String description;
    private String image_url;
}
