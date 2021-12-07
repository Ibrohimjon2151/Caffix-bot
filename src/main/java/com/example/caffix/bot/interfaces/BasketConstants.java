package com.example.caffix.bot.interfaces;

import com.example.caffix.DBconfig.repository.BasketRepository;
import com.example.caffix.DBconfig.repository.OrderProductRepository;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.FileNotFoundException;

public interface BasketConstants {
    SendMessage sendOrderedProducts(Update update , BasketRepository basketRepository , OrderProductRepository orderProductRepository) throws FileNotFoundException;
    void cancelOrderFromBasket(Update update ,BasketRepository basketRepository ,OrderProductRepository orderProductRepository);
    SendMessage sendOrderProductsToChanel(Update update , BasketRepository basketRepository , OrderProductRepository orderProductRepository);
    SendMessage getLocation(Update update);
    EditMessageText errorSplitProduct(Update update);
    SendMessage chooseYexOrNo(Update update);

    String pilus = "➕";
    String minus = "➖";
    String ordererProduct = "☑️ Buyurtmani tasdiqlash";
    String cancelOrder = "❌Bekor qilish";
    String moreOrder = "⬅️Yana buyurtma berish";

    EditMessageText addProductOrSplit(Update update , OrderProductRepository orderProductRepository ,BasketRepository basketRepository);




}
