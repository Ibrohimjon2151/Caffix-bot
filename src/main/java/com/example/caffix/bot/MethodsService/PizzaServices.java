package com.example.caffix.bot.MethodsService;

import com.example.caffix.bot.interfaces.PizzaConstants;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.awt.SystemColor.text;

public class PizzaServices implements PizzaConstants {

    @Override
    public SendPhoto sendPizzaTypes(Update update ,String urlImage) {
        SendPhoto sendPhoto = new SendPhoto();

        sendPhoto.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        sendPhoto.setPhoto(new InputFile(new File(urlImage)));

        sendPhoto.setCaption("Qaysi lavashni tanlaymiz ☺️");

        SendServices sendServices = new SendServices()
;        InlineKeyboardMarkup inlineKeyboardMarkup = sendServices.makeInlineKeyboardButton(PizzaConstants.listPizzaProducts);

        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);

        return sendPhoto;
    }


}
