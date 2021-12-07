package com.example.caffix.DBconfig.repository;

import com.example.caffix.DBconfig.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderProductRepository extends JpaRepository<OrderProduct,Integer> {

    List<OrderProduct> findAllByBasket_ChatId(Long chatId);

    Optional<OrderProduct> findByName(String name);
}
