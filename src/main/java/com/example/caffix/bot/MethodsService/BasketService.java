package com.example.caffix.bot.MethodsService;

import com.example.caffix.DBconfig.entity.Basket;
import com.example.caffix.DBconfig.entity.OrderProduct;
import com.example.caffix.DBconfig.repository.BasketRepository;
import com.example.caffix.DBconfig.repository.OrderProductRepository;
import com.example.caffix.bot.constants.MenuConstants;
import com.example.caffix.bot.interfaces.BasketConstants;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BasketService implements BasketConstants {
    @Override
    public SendMessage getLocation(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        sendMessage.setText("Manzilni (location\uD83D\uDCCD) jo'nating yoki qisqacha mo'ljalni kiriting. " + "\n" +
                "Misol uchun: Osiyo to'yxonasi yaqinida");

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
        keyboardButton.setRequestLocation(true);
        keyboardButton.setText("< Location jo'natish \uD83D\uDCCD >");
        keyboardFirstRow.add(keyboardButton);

        // add array to list
        keyboard.add(keyboardFirstRow);

        // add list to our keyboard
        replyKeyboardMarkup.setKeyboard(keyboard);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    @Override
    public SendMessage chooseYexOrNo(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        sendMessage.setText("Zakasni tasdiqlaymizmi☺️");

        SendServices sendServices = new SendServices();
        String[] array = {BasketConstants.ordererProduct, BasketConstants.cancelOrder};

        InlineKeyboardMarkup inlineKeyboardMarkup = sendServices.makeInlineKeyboardButton(array);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        return sendMessage;
    }

    @Override
    public SendMessage sendOrderProductsToChanel(Update update, BasketRepository basketRepository, OrderProductRepository orderProductRepository) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId("1094047440");
        StringBuilder stringBuilder = new StringBuilder();
        Optional<Basket> optional = basketRepository.findByChatId(update.getCallbackQuery().getMessage().getChatId());
        Basket basket = optional.get();

        List<OrderProduct> allBasket = orderProductRepository.findAllByBasket_ChatId(basket.getChatId());
        stringBuilder.append("Zakaschini Ismi: " + basket.getUser().getName());
        stringBuilder.append("\n ➖➖➖➖ \n");
        stringBuilder.append("Telfon raqami: " + basket.getUser().getPhoneNumber());
        stringBuilder.append("\n ➖➖➖➖ \n");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String format = dtf.format(now);
        stringBuilder.append("Zakas qilingan vaqt: " + format);
        stringBuilder.append("\n ➖➖➖➖ \n");
        for (OrderProduct orderProduct : allBasket) {
            stringBuilder.append(orderProduct.getName()).append(": \n").append(orderProduct.getAmount()).append("x").append(orderProduct.getPrice() / orderProduct.getAmount()).append(" = ").append(orderProduct.getPrice()).append(" so'm");
            stringBuilder.append("\n ➖➖➖➖ \n");
        }

        Long allPrice = 0l;
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < allBasket.size(); i++) {
            allPrice += allBasket.get(i).getPrice();
            stringBuilder1.append((i + 1) + ") " + allBasket.get(i).getAmount() + " ta").append(allBasket.get(i).getName()).append("\n");
        }
        stringBuilder.append("Zakaslar: \n" + stringBuilder1);
        stringBuilder.append("\n ➖➖➖➖ \n");
        stringBuilder.append("Umumiy summa :" + allPrice + "so'm");

        sendMessage.setText(String.valueOf(stringBuilder));


        return sendMessage;
    }

    @Override
    public SendMessage sendOrderedProducts(Update update, BasketRepository basketRepository, OrderProductRepository orderProductRepository) throws FileNotFoundException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));

        StringBuilder stringBuilder = new StringBuilder();

        Optional<Basket> optionalBasket = basketRepository.findByChatId(update.getCallbackQuery().getMessage().getChatId());

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();

        if (optionalBasket.isPresent()) {
            Basket basket = optionalBasket.get();
            List<OrderProduct> allOrderProducts = orderProductRepository.findAllByBasket_ChatId(basket.getChatId());

            for (OrderProduct orderProduct : allOrderProducts) {
                stringBuilder.append(orderProduct.getName() + ": \n" + orderProduct.getAmount() + "x" + orderProduct.getPrice() / orderProduct.getAmount() + " = " + orderProduct.getPrice() + " so'm");
                stringBuilder.append("\n ➖➖➖➖ \n");
            }
            sendMessage.setText(String.valueOf(stringBuilder));

            for (int i = 0; i < allOrderProducts.size(); i++) {
                InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
                InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
                InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();

                inlineKeyboardButton.setText(BasketConstants.pilus);
                inlineKeyboardButton.setCallbackData("+" + allOrderProducts.get(i).getName());

                inlineKeyboardButton2.setText(allOrderProducts.get(i).getName());
                inlineKeyboardButton2.setCallbackData(allOrderProducts.get(i).getName() + 2);

                inlineKeyboardButton3.setText(BasketConstants.minus);
                inlineKeyboardButton3.setCallbackData("-" + allOrderProducts.get(i).getName());

                row.add(inlineKeyboardButton);
                row.add(inlineKeyboardButton2);
                row.add(inlineKeyboardButton3);

                List<InlineKeyboardButton> row2 = new ArrayList<>();

                rowlist.add(row);
                row = row2;
            }
            List<InlineKeyboardButton> row1 = new ArrayList<>();
            List<InlineKeyboardButton> row2 = new ArrayList<>();

            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
            InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();

            inlineKeyboardButton.setText(BasketConstants.ordererProduct);
            inlineKeyboardButton.setCallbackData(BasketConstants.ordererProduct);

            inlineKeyboardButton2.setText(BasketConstants.cancelOrder);
            inlineKeyboardButton2.setCallbackData(BasketConstants.cancelOrder);

            inlineKeyboardButton3.setText(BasketConstants.moreOrder);
            inlineKeyboardButton3.setCallbackData(BasketConstants.moreOrder);

            row1.add(inlineKeyboardButton);

            row2.add(inlineKeyboardButton2);
            row2.add(inlineKeyboardButton3);
            rowlist.add(row1);
            rowlist.add(row2);
            inlineKeyboardMarkup.setKeyboard(rowlist);
            sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        } else {
            SendServices sendServices = new SendServices();
            sendMessage = sendServices.sendCategory(update);
        }

        return sendMessage;
    }

    @Override
    public EditMessageText errorSplitProduct(Update update) {
        EditMessageText editMessageText = new EditMessageText() ;
        editMessageText.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        editMessageText.setText("Afsuski sizda mahsulot qolmadi");
        return null;
    }

    @Override
    public EditMessageText addProductOrSplit(Update update, OrderProductRepository orderProductRepository, BasketRepository basketRepository) {
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        editMessageText.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
        String data = update.getCallbackQuery().getData();

        String substring = data.substring(0, 1);
        String productName = data.substring(1);

        Optional<OrderProduct> productOptional = orderProductRepository.findByName(productName);
        if (substring.equals("+")) {
            OrderProduct orderProduct = productOptional.get();
            orderProduct.setAmount(orderProduct.getAmount() + 1);
            orderProductRepository.save(orderProduct);
        } else {
            OrderProduct orderProduct = productOptional.get();
            if (orderProduct.getAmount() > 1) {
                orderProduct.setAmount(orderProduct.getAmount() - 1);
                orderProductRepository.save(orderProduct);
            } else {
                orderProductRepository.deleteById(orderProduct.getId());
            }

        }
        Optional<Basket> optional1 = basketRepository.findByChatId(update.getCallbackQuery().getMessage().getChatId());

        List<OrderProduct> allOrderProducts = orderProductRepository.findAllByBasket_ChatId(optional1.get().getChatId());

        StringBuilder stringBuilder = new StringBuilder();

        for (OrderProduct orderProduct : allOrderProducts) {
            stringBuilder.append(orderProduct.getName() + ": \n" + orderProduct.getAmount() + "x" + orderProduct.getPrice() / orderProduct.getAmount() + " = " + orderProduct.getPrice() + " so'm");
            stringBuilder.append("\n ➖➖➖➖ \n");
        }

        editMessageText.setText(String.valueOf(stringBuilder));

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();


        for (int i = 0; i < allOrderProducts.size(); i++) {
            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
            InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();

            inlineKeyboardButton.setText(BasketConstants.pilus);
            inlineKeyboardButton.setCallbackData("+" + allOrderProducts.get(i).getName());

            inlineKeyboardButton2.setText(allOrderProducts.get(i).getName());
            inlineKeyboardButton2.setCallbackData(allOrderProducts.get(i).getName() + i);

            inlineKeyboardButton3.setText(BasketConstants.minus);
            inlineKeyboardButton3.setCallbackData("-" + allOrderProducts.get(i).getName());

            row.add(inlineKeyboardButton);
            row.add(inlineKeyboardButton2);
            row.add(inlineKeyboardButton3);

            List<InlineKeyboardButton> row2 = new ArrayList<>();

            rowlist.add(row);
            row = row2;
        }
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();

        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();

        inlineKeyboardButton.setText(BasketConstants.ordererProduct);
        inlineKeyboardButton.setCallbackData(BasketConstants.ordererProduct);

        inlineKeyboardButton2.setText(BasketConstants.cancelOrder);
        inlineKeyboardButton2.setCallbackData(BasketConstants.cancelOrder);

        inlineKeyboardButton3.setText(BasketConstants.moreOrder);
        inlineKeyboardButton3.setCallbackData(BasketConstants.moreOrder);

        row1.add(inlineKeyboardButton);

        row2.add(inlineKeyboardButton2);
        row2.add(inlineKeyboardButton3);
        rowlist.add(row1);
        rowlist.add(row2);
        inlineKeyboardMarkup.setKeyboard(rowlist);
        editMessageText.setReplyMarkup(inlineKeyboardMarkup);

        return editMessageText;
    }

    @Override
    public void cancelOrderFromBasket(Update update, BasketRepository basketRepository, OrderProductRepository orderProductRepository) {
        Optional<Basket> optionalBasket = basketRepository.findByChatId(update.getCallbackQuery().getMessage().getChatId());
        Basket basket = optionalBasket.get();
        for (OrderProduct orderProduct : orderProductRepository.findAllByBasket_ChatId(basket.getChatId())) {
            orderProductRepository.deleteById(orderProduct.getId());
        }
        basketRepository.deleteById(basket.getId());
    }

}
