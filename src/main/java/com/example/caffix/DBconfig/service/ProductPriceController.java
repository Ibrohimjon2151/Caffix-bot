package com.example.caffix.DBconfig.service;

import com.example.caffix.DBconfig.entity.ProductPrice;
import com.example.caffix.DBconfig.payload.ProductPriceDto;
import com.example.caffix.DBconfig.repository.ProductPriceRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/product-price")
public class ProductPriceController {
    @Autowired
    ProductPriceRepository productPriceRepository;

    @PostMapping()
    public  boolean addProductAndPrice(@RequestBody ProductPriceDto productPriceDto) {
        ProductPrice productPrice = new ProductPrice();
        productPrice.setName(productPriceDto.getName());
        productPrice.setPrice(productPriceDto.getPrice());
        productPriceRepository.save(productPrice);
        return true;
    }
}
