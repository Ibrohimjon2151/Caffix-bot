package com.example.caffix.DBconfig.repository;

import com.example.caffix.DBconfig.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByChatId(Long chatId);
}
