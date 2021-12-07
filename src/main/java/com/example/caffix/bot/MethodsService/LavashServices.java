package com.example.caffix.bot.MethodsService;

import com.example.caffix.bot.constants.MenuConstants;
import com.example.caffix.bot.interfaces.LavashConstants;
import org.apache.tomcat.util.net.SendfileState;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageCaption;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import javax.websocket.SendHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LavashServices implements LavashConstants {
    @Override
    public SendPhoto sendLavashType(Update update , String imageUrl) {

        SendPhoto sendMessage = new SendPhoto();
        sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        sendMessage.setPhoto(new InputFile(new File(imageUrl)));
        sendMessage.setCaption("Qaysi lavashni tanlaymiz ☺️");
        sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton6 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton7 = new InlineKeyboardButton();


        List<InlineKeyboardButton> list1 = new ArrayList<>();
        List<InlineKeyboardButton> list2 = new ArrayList<>();
        List<InlineKeyboardButton> list3 = new ArrayList<>();
        List<InlineKeyboardButton> list4 = new ArrayList<>();


        inlineKeyboardButton1.setText(LavashConstants.firstNameLavash);
        inlineKeyboardButton1.setCallbackData(LavashConstants.firstNameLavash);

        inlineKeyboardButton2.setText(LavashConstants.secondNameLavash);
        inlineKeyboardButton2.setCallbackData(LavashConstants.secondNameLavash);

        inlineKeyboardButton3.setText(LavashConstants.thirdNameLavash);
        inlineKeyboardButton3.setCallbackData(LavashConstants.thirdNameLavash);

        inlineKeyboardButton4.setText(LavashConstants.fourthdNameLavash);
        inlineKeyboardButton4.setCallbackData(LavashConstants.fourthdNameLavash);

        inlineKeyboardButton5.setText(LavashConstants.fifthdNameLavash);
        inlineKeyboardButton5.setCallbackData(LavashConstants.fifthdNameLavash);

        inlineKeyboardButton6.setText(LavashConstants.sixthdNameLavash);
        inlineKeyboardButton6.setCallbackData(LavashConstants.sixthdNameLavash);

        inlineKeyboardButton7.setText(MenuConstants.menuBack);
        inlineKeyboardButton7.setCallbackData(MenuConstants.menuBack);

        list1.add(inlineKeyboardButton1);
        list1.add(inlineKeyboardButton2);
        list2.add(inlineKeyboardButton3);
        list2.add(inlineKeyboardButton4);
        list3.add(inlineKeyboardButton5);
        list3.add(inlineKeyboardButton6);
        list4.add(inlineKeyboardButton7);

        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        rowlist.add(list1);
        rowlist.add(list2);
        rowlist.add(list3);
        rowlist.add(list4);
        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        return sendMessage;
    }

    @Override

    public SendPhoto orderFirstLavash(String firstButton, String secondButton, Update update , String imageUrl) {
        SendPhoto editMessageText = new SendPhoto();

        editMessageText.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        editMessageText.setPhoto(new InputFile(new File(imageUrl)));
        editMessageText.setCaption("Qaysi lavashni tanlaymiz ☺️");
        //Send Lavash Photo
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();

        List<InlineKeyboardButton> list = new ArrayList<>();
        List<InlineKeyboardButton> list2 = new ArrayList<>();

        inlineKeyboardButton.setText(firstButton);
        inlineKeyboardButton.setCallbackData(firstButton);

        inlineKeyboardButton2.setText(secondButton);
        inlineKeyboardButton2.setCallbackData(secondButton);

        inlineKeyboardButton3.setText(MenuConstants.menuBack);
        inlineKeyboardButton3.setCallbackData(MenuConstants.menuBack);


        list.add(inlineKeyboardButton);
        list.add(inlineKeyboardButton2);
        list2.add(inlineKeyboardButton3);

        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();

        rowlist.add(list);
        rowlist.add(list2);
        inlineKeyboardMarkup.setKeyboard(rowlist);
        editMessageText.setReplyMarkup(inlineKeyboardMarkup);

        return editMessageText;
    }

    @Override
    public SendPhoto orderCaffixLavash(Update update , String imageUrl) {
        SendPhoto editMessageText = new SendPhoto();

        editMessageText.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        editMessageText.setPhoto(new InputFile(new File(imageUrl)));
        editMessageText.setCaption("Qaysi lavashni tanlaymiz ☺️");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();


        List<InlineKeyboardButton> list = new ArrayList<>();
        List<InlineKeyboardButton> list2 = new ArrayList<>();
        List<InlineKeyboardButton> list3 = new ArrayList<>();

        inlineKeyboardButton.setText(LavashConstants.caffixMiniLavash);
        inlineKeyboardButton.setCallbackData(LavashConstants.caffixMiniLavash);

        inlineKeyboardButton2.setText(LavashConstants.caffixClasicLavash);
        inlineKeyboardButton2.setCallbackData(LavashConstants.caffixClasicLavash);

        inlineKeyboardButton3.setText(LavashConstants.caffixOstiriyLavash);
        inlineKeyboardButton3.setCallbackData(LavashConstants.caffixOstiriyLavash);

        inlineKeyboardButton4.setText(LavashConstants.caffixSirliyLavash);
        inlineKeyboardButton4.setCallbackData(LavashConstants.caffixSirliyLavash);

        inlineKeyboardButton5.setText(MenuConstants.menuBack);
        inlineKeyboardButton5.setCallbackData(MenuConstants.menuBack);

        list.add(inlineKeyboardButton);
        list.add(inlineKeyboardButton2);
        list2.add(inlineKeyboardButton3);
        list2.add(inlineKeyboardButton4);
        list3.add(inlineKeyboardButton5);


        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        rowlist.add(list);
        rowlist.add(list2);
        rowlist.add(list3);
        inlineKeyboardMarkup.setKeyboard(rowlist);
        editMessageText.setReplyMarkup(inlineKeyboardMarkup);
        return editMessageText;
    }

//    @Override
//    public EditMessageText orderShaurmaLavash(Update update , String imageUrl) {
//        SendPhoto editMessageText = new SendPhoto();
//
//        editMessageText.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
//        editMessageText.setPhoto(new InputFile(new File(imageUrl)));
//        editMessageText.setCaption("Qaysi lavashni tanlaymiz ☺️");
//
//        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
//
//        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
//        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
//        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
//
//        List<InlineKeyboardButton> list = new ArrayList<>();
//        List<InlineKeyboardButton> list2 = new ArrayList<>();
//
//        inlineKeyboardButton.setText(LavashConstants.shaurmaSmall);
//        inlineKeyboardButton.setCallbackData(LavashConstants.shaurmaSmall);
//
//        inlineKeyboardButton2.setText(LavashConstants.shaurmaBig);
//        inlineKeyboardButton2.setCallbackData(LavashConstants.shaurmaBig);
//
//        inlineKeyboardButton3.setText(MenuConstants.menuBack);
//        inlineKeyboardButton3.setCallbackData(MenuConstants.menuBack);
//
//        list.add(inlineKeyboardButton);
//        list.add(inlineKeyboardButton2);
//        list2.add(inlineKeyboardButton3);
//
//        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
//        rowlist.add(list);
//        rowlist.add(list2);
//
//        inlineKeyboardMarkup.setKeyboard(rowlist);
//        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
//        return sendMessage;
//    }

    @Override
    public SendPhoto orderKlab(Update update , String imageUrl) {
        SendPhoto editMessageText = new SendPhoto();

        editMessageText.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        editMessageText.setPhoto(new InputFile(new File(imageUrl)));
        editMessageText.setCaption("Qaysi lavashni tanlaymiz ☺️");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();

        List<InlineKeyboardButton> list = new ArrayList<>();
        List<InlineKeyboardButton> list2 = new ArrayList<>();

        inlineKeyboardButton.setText(LavashConstants.klabTovuqli);
        inlineKeyboardButton.setCallbackData(LavashConstants.klabTovuqli);

        inlineKeyboardButton2.setText(LavashConstants.klabGoshtli);
        inlineKeyboardButton2.setCallbackData(LavashConstants.klabGoshtli);

        inlineKeyboardButton3.setText(MenuConstants.menuBack);
        inlineKeyboardButton3.setCallbackData(MenuConstants.menuBack);

        list.add(inlineKeyboardButton);
        list.add(inlineKeyboardButton2);
        list2.add(inlineKeyboardButton3);

        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();

        rowlist.add(list);
        rowlist.add(list2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        editMessageText.setReplyMarkup(inlineKeyboardMarkup);
        return editMessageText;
    }

//    @Override
//    public SendPhoto orderBreadLavash(Update update , String imageUrl) {
//        SendPhoto editMessageText = new SendPhoto();
//
//        editMessageText.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
//        editMessageText.setPhoto(new InputFile(new File(imageUrl)));
//        editMessageText.setCaption("Qaysi lavashni tanlaymiz ☺️");
//
//        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
//
//        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
//        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
//        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
//
//        List<InlineKeyboardButton> list = new ArrayList<>();
//        List<InlineKeyboardButton> list2 = new ArrayList<>();
//        inlineKeyboardButton.setText(LavashConstants.breadLavash);
//        inlineKeyboardButton.setCallbackData(LavashConstants.breadLavash);
//
//        inlineKeyboardButton2.setText(LavashConstants.breadDonar);
//        inlineKeyboardButton2.setCallbackData(LavashConstants.breadDonar);
//
//        inlineKeyboardButton3.setText(MenuConstants.menuBack);
//        inlineKeyboardButton3.setCallbackData(MenuConstants.menuBack);
//
//        list.add(inlineKeyboardButton);
//        list.add(inlineKeyboardButton2);
//        list2.add(inlineKeyboardButton3);
//
//        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
//        rowlist.add(list);
//        rowlist.add(list2);
//        inlineKeyboardMarkup.setKeyboard(rowlist);
//        editMessageText.setReplyMarkup(inlineKeyboardMarkup);
//        return editMessageText;
//    }
}
