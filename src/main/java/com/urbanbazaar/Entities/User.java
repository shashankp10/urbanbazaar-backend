package com.urbanbazaar.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Entity
@Table(name="users")
@Getter
@ToString
@RequiredArgsConstructor
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private long mobile;
    private String address;
    private String state;
    private int cartCount;
    private List<String> itemsInCart;
}
