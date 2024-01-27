package com.urbanbazaar.DTO;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private long id;
    private String name;
    private long mobile;
    private String address;
    private String state;
    private int cartCount;
    private List<String> itemsInCart;
}
