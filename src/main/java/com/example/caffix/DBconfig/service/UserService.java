package com.example.caffix.DBconfig.service;

import com.example.caffix.DBconfig.entity.User;
import com.example.caffix.DBconfig.repository.UserRepository;
import com.example.caffix.DBconfig.service.interfase.DbConfigInteffaces;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

public class UserService implements DbConfigInteffaces {
    @Override
    public void saveUser(Update update, String state, UserRepository userRepository) {
        String name = update.getMessage().getContact().getFirstName();
        String phoneNumber = update.getMessage().getContact().getPhoneNumber();
        Long chatId = update.getMessage().getChatId();

        User user = new User();
        user.setState(state);
        user.setName(name);
        user.setChatId(chatId);
        user.setPhoneNumber(phoneNumber);
        userRepository.save(user);
    }

    @Override
    public void saveUserByPhoneNumber(Update update, String state, UserRepository userRepository) {
        String name = update.getMessage().getFrom().getFirstName();
        String phoneNumber = update.getMessage().getText();
        User user = new User();
        user.setState(state);
        user.setName(name);
        user.setChatId(update.getMessage().getChatId());
        user.setPhoneNumber(phoneNumber);
        userRepository.save(user);
    }

    @Override
    public void updateUserState(Long chatId, String state, UserRepository userRepository) {
        Optional<User> byChatId = userRepository.findByChatId(chatId);
        User user = byChatId.get();
        user.setState(state);
        userRepository.save(user);
    }

    @Override
    public User checkUser(Update update, UserRepository userRepository) {
        Optional<User> byChatId = userRepository.findByChatId(update.getMessage().getChatId());
        return byChatId.get();
    }

    @Override
    public void updateUserLocation(Update update, UserRepository userRepository) {
        Optional<User> byChatId = userRepository.findByChatId(update.getMessage().getChatId());
        User user = byChatId.get();
        if (update.getMessage().hasLocation()) {
            user.setLocationLatitude(update.getMessage().getLocation().getLatitude());
            user.setLocationLongitude(update.getMessage().getLocation().getLongitude());
            userRepository.save(user);
        } else {
            user.setLocation(update.getMessage().getText());
            userRepository.save(user);
        }

    }

    @Override
    public void doEmpityLocation(Update update, UserRepository userRepository) {
        Optional<User> user = userRepository.findByChatId(update.getCallbackQuery().getMessage().getChatId());
        User user1 = user.get();
        user1.setLocation(null);
        user1.setLocationLatitude(null);
        user1.setLocationLongitude(null);
        userRepository.save(user1);
    }
}
