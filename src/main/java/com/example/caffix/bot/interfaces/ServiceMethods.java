package com.example.caffix.bot.interfaces;

import com.example.caffix.DBconfig.repository.*;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.io.FileNotFoundException;

public interface ServiceMethods {

    SendMessage thanksMessage(Update update);

    SendMessage WelcomeToBot(Update update);

    SendMessage sendCategory(Update update) throws FileNotFoundException;

    SendMessage phoneNumberError(Update update);

    SendPhoto sendPhotoMenu(String chatId, String imageUrl, String descreptionImage);

    SendMessage orderedProduct(String productName, Update update, ProductRepository productRepository ,ProductPriceRepository productPriceRepository );

    EditMessageText backToPreviousMenu(Update update);

    DeleteMessage deleteMessage(Update update);

    SendMessage saveProduct(Update update, ProductRepository productRepository, ProductPriceRepository productPriceRepository, BasketRepository basketRepository, UserRepository userRepository, OrderProductRepository orderProductRepository) throws FileNotFoundException;

    InlineKeyboardMarkup makeInlineKeyboardButton(String[] buttonNamesArray);

}
