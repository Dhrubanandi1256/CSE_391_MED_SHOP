package com.example.carg.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private int categoryId;
    private int price;
    private String description;
    private String imageName;
}
