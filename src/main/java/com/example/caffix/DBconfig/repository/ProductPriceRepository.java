package com.example.caffix.DBconfig.repository;

import com.example.caffix.DBconfig.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductPriceRepository extends JpaRepository<ProductPrice , Integer> {

    Optional<ProductPrice> findByName(String productName);
}
