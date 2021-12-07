package com.example.caffix.DBconfig.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;

    private Double amount;

    private Double price;

    private Integer userId;



}
