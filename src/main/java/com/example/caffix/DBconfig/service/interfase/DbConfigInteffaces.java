package com.example.caffix.DBconfig.service.interfase;

import com.example.caffix.DBconfig.entity.User;
import com.example.caffix.DBconfig.repository.UserRepository;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

public interface DbConfigInteffaces {
    void saveUser(Update update , String state, UserRepository userRepository);
    void saveUserByPhoneNumber(Update update , String state, UserRepository userRepository);
    void updateUserState(Long chatId , String state , UserRepository userRepository);
    void updateUserLocation(Update update, UserRepository userRepository);
    User checkUser(Update update , UserRepository userRepository);
}
