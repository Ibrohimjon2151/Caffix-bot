package com.example.caffix.DBconfig.repository;

import com.example.caffix.DBconfig.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByUserId(Long chatId);
}
