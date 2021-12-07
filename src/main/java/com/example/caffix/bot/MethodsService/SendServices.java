package com.example.caffix.bot.MethodsService;

import com.example.caffix.DBconfig.entity.*;
import com.example.caffix.DBconfig.repository.*;
import com.example.caffix.bot.constants.ConstantaNumbers;
import com.example.caffix.bot.constants.MenuConstants;
import com.example.caffix.bot.interfaces.ServiceMethods;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SendServices implements ServiceMethods {
    static Integer amount = 0;

    /// Welcome To bot
    @Override
    public SendMessage WelcomeToBot(Update update) {
        StringBuilder stringBuilder = new StringBuilder();
        Long chatId = update.getMessage().getChatId();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        stringBuilder.append("Assalomu alaykum hurmatli " + update.getMessage().getFrom().getFirstName() + "" +
                " Caffix hizmatlar botga hush kelibsiz \uD83E\uDD17.");

        stringBuilder.append("\n" + "‼️Telegram rqamini yuboring yoki o'zingiz kiriting" + "\n" +
                "Misol uchun: +998901234567");
        sendMessage.setText(String.valueOf(stringBuilder));


        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);


        // new list
        List<KeyboardRow> keyboard = new ArrayList<>();

        // first keyboard line
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardButton keyboardButton = new KeyboardButton();
        keyboardButton.setRequestContact(true);
        keyboardButton.setText("< Kontakt jo'natish \uD83D\uDCDE >");
        keyboardFirstRow.add(keyboardButton);

        // add array to list
        keyboard.add(keyboardFirstRow);

        // add list to our keyboard
        replyKeyboardMarkup.setKeyboard(keyboard);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }


    @Override
    public SendMessage phoneNumberError(Update update) {
        StringBuilder stringBuilder = new StringBuilder();
        Long chatId = update.getMessage().getChatId();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        stringBuilder.append("Hurmatli " + update.getMessage().getFrom().getFirstName() + " " +
                update.getMessage().getText() + " bunday raqam tizimdan topilmadi ‼️");

        stringBuilder.append("\n" + "Telegram rqamini yuboring yoki o'zingiz kiriting" + "\n" +
                "Misol uchun: +998901234567");
        sendMessage.setText(String.valueOf(stringBuilder));


        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);


        // new list
        List<KeyboardRow> keyboard = new ArrayList<>();

        // first keyboard line
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardButton keyboardButton = new KeyboardButton();
        keyboardButton.setRequestContact(true);
        keyboardButton.setText("< Kontakt jo'natish \uD83D\uDCDE >");
        keyboardFirstRow.add(keyboardButton);

        // add array to list
        keyboard.add(keyboardFirstRow);

        // add list to our keyboard
        replyKeyboardMarkup.setKeyboard(keyboard);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    @Override
    public DeleteMessage deleteMessage(Update update) {
        DeleteMessage deleteMessage = new DeleteMessage();
        deleteMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        deleteMessage.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
        return deleteMessage;
    }

    @Override
    public SendMessage sendCategory(Update update) throws FileNotFoundException {

        SendMessage sendMessage = new SendMessage();

        if (update.hasMessage()) {
            sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        } else {
            sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        }
        sendMessage.setText("Zakasni birga joylashtiramizmi ☺️");

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        //   Inline Buttons
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton6 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton7 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton8 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton9 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton10 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton11 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton12 = new InlineKeyboardButton();

        List<InlineKeyboardButton> listButton1 = new ArrayList<>();
        List<InlineKeyboardButton> listButton2 = new ArrayList<>();
        List<InlineKeyboardButton> listButton3 = new ArrayList<>();
        List<InlineKeyboardButton> listButton4 = new ArrayList<>();
        List<InlineKeyboardButton> listButton5 = new ArrayList<>();
        List<InlineKeyboardButton> listButton6 = new ArrayList<>();
        List<InlineKeyboardButton> listButton7 = new ArrayList<>();

        // add data to inline buttons
        // 1 - row
        inlineKeyboardButton1.setText(MenuConstants.menuLavash);
        inlineKeyboardButton1.setCallbackData(MenuConstants.menuLavash);

        inlineKeyboardButton2.setText(MenuConstants.menuPizza);
        inlineKeyboardButton2.setCallbackData(MenuConstants.menuPizza);
        //2-row
        inlineKeyboardButton3.setText(MenuConstants.menuDoner);
        inlineKeyboardButton3.setCallbackData(MenuConstants.menuDoner);

        inlineKeyboardButton4.setText(MenuConstants.menuFastFood);
        inlineKeyboardButton4.setCallbackData(MenuConstants.menuFastFood);
        //3-row
        inlineKeyboardButton5.setText(MenuConstants.menuMeat);
        inlineKeyboardButton5.setCallbackData(MenuConstants.menuMeat);

        inlineKeyboardButton6.setText(MenuConstants.menuChiken);
        inlineKeyboardButton6.setCallbackData(MenuConstants.menuChiken);
        //4-row
        inlineKeyboardButton7.setText(MenuConstants.menuSoup);
        inlineKeyboardButton7.setCallbackData(MenuConstants.menuSoup);

        inlineKeyboardButton8.setText(MenuConstants.menuSteak);
        inlineKeyboardButton8.setCallbackData(MenuConstants.menuSteak);

        //5-row
        inlineKeyboardButton9.setText(MenuConstants.menuSalat);
        inlineKeyboardButton9.setCallbackData(MenuConstants.menuSalat);

        inlineKeyboardButton10.setText(MenuConstants.menuBread);
        inlineKeyboardButton10.setCallbackData(MenuConstants.menuBread);

        inlineKeyboardButton11.setText(MenuConstants.menuDrinks);
        inlineKeyboardButton11.setCallbackData(MenuConstants.menuDrinks);

        inlineKeyboardButton12.setText(MenuConstants.menuBasket);
        inlineKeyboardButton12.setCallbackData(MenuConstants.menuBasket);


        // add buttons to listButtons
        listButton1.add(inlineKeyboardButton1);
        listButton1.add(inlineKeyboardButton2);

        listButton2.add(inlineKeyboardButton3);
        listButton2.add(inlineKeyboardButton4);

        listButton3.add(inlineKeyboardButton5);
        listButton3.add(inlineKeyboardButton6);

        listButton4.add(inlineKeyboardButton7);
        listButton4.add(inlineKeyboardButton8);

        listButton5.add(inlineKeyboardButton9);
        listButton5.add(inlineKeyboardButton10);

        listButton6.add(inlineKeyboardButton11);

        listButton7.add(inlineKeyboardButton12);

        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        rowlist.add(listButton1);
        rowlist.add(listButton2);
        rowlist.add(listButton3);
        rowlist.add(listButton4);
        rowlist.add(listButton5);
        rowlist.add(listButton6);
        rowlist.add(listButton7);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        return sendMessage;
    }


    @Override
    public EditMessageText backToPreviousMenu(Update update) {
        return null;
    }

    @Override
    public SendPhoto sendPhotoMenu(String chatId, String imageUrl, String descreptionImage) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setCaption(descreptionImage);
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile(new File(imageUrl)));
        return sendPhoto;
    }

    @Override
    public SendMessage orderedProduct(String productName, Update update, ProductRepository productRepository ,ProductPriceRepository productPriceRepository ) {

        Optional<Product> byUserId = productRepository.findByUserId(update.getCallbackQuery().getMessage().getChatId());

        if (byUserId.isPresent()) {
            amount = byUserId.get().getAmount();
        } else {
            Product product = new Product();
            product.setName(productName);
            product.setUserId(update.getCallbackQuery().getMessage().getChatId());
            productRepository.save(product);
            amount = 0;
        }


        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));

        Optional<ProductPrice> byName = productPriceRepository.findByName(productName);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Siz tanlagan mahsulot:"+productName+"\n");
        stringBuilder.append("Narxi: "+byName.get().getPrice()+" so'm");
        sendMessage.setText(String.valueOf(stringBuilder));
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton6 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton7 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton8 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton9 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton10 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton11 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton12 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton13 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton14 = new InlineKeyboardButton();

        List<InlineKeyboardButton> listButton1 = new ArrayList<>();
        List<InlineKeyboardButton> listButton2 = new ArrayList<>();
        List<InlineKeyboardButton> listButton3 = new ArrayList<>();
        List<InlineKeyboardButton> listButton4 = new ArrayList<>();
        List<InlineKeyboardButton> listButton5 = new ArrayList<>();
        List<InlineKeyboardButton> listButton6 = new ArrayList<>();
        List<InlineKeyboardButton> listButton7 = new ArrayList<>();

        // add data to inline buttons
        // 1 - row
        inlineKeyboardButton1.setText(ConstantaNumbers.order + " " + amount);
        inlineKeyboardButton1.setCallbackData(ConstantaNumbers.order);

        inlineKeyboardButton2.setText(ConstantaNumbers.one);
        inlineKeyboardButton2.setCallbackData("1");
        //2-row
        inlineKeyboardButton3.setText(ConstantaNumbers.two);
        inlineKeyboardButton3.setCallbackData("2");

        inlineKeyboardButton4.setText(ConstantaNumbers.three);
        inlineKeyboardButton4.setCallbackData("3");
        //3-row
        inlineKeyboardButton5.setText(ConstantaNumbers.four);
        inlineKeyboardButton5.setCallbackData("4");

        inlineKeyboardButton6.setText(ConstantaNumbers.five);
        inlineKeyboardButton6.setCallbackData("5");
        //4-row
        inlineKeyboardButton7.setText(ConstantaNumbers.six);
        inlineKeyboardButton7.setCallbackData("6");

        inlineKeyboardButton8.setText(ConstantaNumbers.seven);
        inlineKeyboardButton8.setCallbackData("7");

        //5-row
        inlineKeyboardButton9.setText(ConstantaNumbers.eight);
        inlineKeyboardButton9.setCallbackData("8");

        inlineKeyboardButton10.setText(ConstantaNumbers.nine);
        inlineKeyboardButton10.setCallbackData("9");

        inlineKeyboardButton11.setText(ConstantaNumbers.ten);
        inlineKeyboardButton11.setCallbackData("10");

        inlineKeyboardButton12.setText(ConstantaNumbers.delete);
        inlineKeyboardButton12.setCallbackData(ConstantaNumbers.delete);

        inlineKeyboardButton13.setText(ConstantaNumbers.saveBasket);
        inlineKeyboardButton13.setCallbackData(ConstantaNumbers.saveBasket);

        inlineKeyboardButton14.setText(MenuConstants.menuBack);
        inlineKeyboardButton14.setCallbackData(MenuConstants.menuBack);


        // add buttons to listButtons
        listButton1.add(inlineKeyboardButton1);


        listButton2.add(inlineKeyboardButton2);

        listButton2.add(inlineKeyboardButton3);
        listButton2.add(inlineKeyboardButton4);

        listButton3.add(inlineKeyboardButton5);
        listButton3.add(inlineKeyboardButton6);

        listButton3.add(inlineKeyboardButton7);
        listButton4.add(inlineKeyboardButton8);

        listButton4.add(inlineKeyboardButton9);
        listButton4.add(inlineKeyboardButton10);

        listButton5.add(inlineKeyboardButton11);

        listButton5.add(inlineKeyboardButton12);

        listButton6.add(inlineKeyboardButton13);

        listButton7.add(inlineKeyboardButton14);

        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        rowlist.add(listButton1);
        rowlist.add(listButton2);
        rowlist.add(listButton3);
        rowlist.add(listButton4);
        rowlist.add(listButton5);
        rowlist.add(listButton6);
        rowlist.add(listButton7);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    @Override
    public SendMessage saveProduct(Update update, ProductRepository productRepository, ProductPriceRepository productPriceRepository, BasketRepository basketRepository, UserRepository userRepository , OrderProductRepository orderProductRepository) throws FileNotFoundException {

        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));

        String data = update.getCallbackQuery().getData();

        Optional<Product> byUserId = productRepository.findByUserId(update.getCallbackQuery().getMessage().getChatId());

        Product product = byUserId.get();
        String name = product.getName();

        Optional<ProductPrice> byName = productPriceRepository.findByName(name);
        Long price = byName.get().getPrice();

        product.setPrice(price);

        switch (data) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
                product.setAmount(Integer.parseInt(data));
                productRepository.save(product);
                return orderedProduct(name, update, productRepository ,productPriceRepository);
            case ConstantaNumbers.delete:
            case MenuConstants.menuBack:
                productRepository.deleteById(product.getId());
                SendMessage sendMessageCategory = sendCategory(update);
                sendMessage = sendMessageCategory;
                return sendMessage;
            case ConstantaNumbers.saveBasket:
                if (product.getAmount()!=null) {
                    Optional<Basket> optional = basketRepository.findByChatId(update.getCallbackQuery().getMessage().getChatId());
                    if (optional.isEmpty()) {
                        Basket basket = new Basket();
                        basket.setChatId(update.getCallbackQuery().getMessage().getChatId());
                        Optional<User> byChatId = userRepository.findByChatId(update.getCallbackQuery().getMessage().getChatId());
                        basket.setUser(byChatId.get());
                        ///  basket
                        basketRepository.save(basket);

                        AddOrderProduct(update, productRepository, basketRepository, orderProductRepository, product);

                    } else {
                        AddOrderProduct(update, productRepository, basketRepository, orderProductRepository, product);
                    }
                }else {
                    productRepository.deleteById(product.getId());
                    return sendCategory(update);
                }
                break;
        }
        SendMessage sendMessageCategory = sendCategory(update);
        sendMessage = sendMessageCategory;
        return sendMessage;
    }

    private void AddOrderProduct(Update update, ProductRepository productRepository, BasketRepository basketRepository, OrderProductRepository orderProductRepository, Product product) {
        Optional<Basket> repositoryByChatId = basketRepository.findByChatId(update.getCallbackQuery().getMessage().getChatId());
        Basket bas = repositoryByChatId.get();
        OrderProduct orderProduct = new OrderProduct();

        orderProduct.setAmount(product.getAmount());
        orderProduct.setName(product.getName());
        orderProduct.setPrice(product.getPrice()*product.getAmount());
        orderProduct.setUserId(update.getCallbackQuery().getMessage().getChatId());
        orderProduct.setBasket(bas);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String format = dtf.format(now);

        orderProduct.setDate(format);

        orderProductRepository.save(orderProduct);
        productRepository.deleteById(product.getId());
    }

    @Override
    public InlineKeyboardMarkup makeInlineKeyboardButton(String [] array) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 1) {

                row = getInlineKeyboardButtons(array, row, rowlist, i);
            }else if (array.length-1 == i){
                row = getInlineKeyboardButtons(array, row, rowlist, i);
            }
            else {
                InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();

                inlineKeyboardButton.setText(array[i]);
                inlineKeyboardButton.setCallbackData(array[i]);

                row.add(inlineKeyboardButton);
            }
        }
        inlineKeyboardMarkup.setKeyboard(rowlist);
        return inlineKeyboardMarkup;
    }

    private List<InlineKeyboardButton> getInlineKeyboardButtons(String[] array, List<InlineKeyboardButton> row, List<List<InlineKeyboardButton>> rowlist, int i) {
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();

        inlineKeyboardButton.setText(array[i]);
        inlineKeyboardButton.setCallbackData(array[i]);

        row.add(inlineKeyboardButton);

        List<InlineKeyboardButton> row2 = new ArrayList<>();

        rowlist.add(row);
        row = row2;
        return row;
    }

    @Override
    public SendMessage thanksMessage(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        sendMessage.setText("Xizmatlarimizdan foydalanganingiz uchun rahmat siz bilan tez orada bog'lanamiz \uD83E\uDD17");
        return sendMessage;
    }
}
