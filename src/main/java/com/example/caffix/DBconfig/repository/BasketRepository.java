package com.example.caffix.DBconfig.repository;

import com.example.caffix.DBconfig.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Integer> {

    Optional<Basket> findByChatId(Long chatId);
    }
