package com.example.caffix.bot.interfaces;


import com.example.caffix.bot.constants.MenuConstants;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public interface PizzaConstants {
    String meatPizza = "\uD83C\uDF55 G'shtli";
    String mushroomPizza = "\uD83C\uDF55 Qo'ziqorinli";
    String assortiPizza = "\uD83C\uDF55 Assorti";
    String margaritaPizza = "\uD83C\uDF55 Margarita";
    String kaziPizza = "\uD83C\uDF55 Kazili";
    String qalampirPizza = "\uD83C\uDF55 Qalampirli";
    String paleromPizza = "\uD83C\uDF55 Palerom";
    String exelusivePizza = "\uD83C\uDF55 Exclusive";
    String mevaliPizza = "\uD83C\uDF55 Mevali";
    String pideSirliPizza = "\uD83C\uDF55 Pide sirli";
    String pideFarshemPizza = "\uD83C\uDF55 Pide qiymali";

    String [] listPizzaProducts = {meatPizza,mushroomPizza,assortiPizza,margaritaPizza,kaziPizza
    ,qalampirPizza,paleromPizza,exelusivePizza,mevaliPizza,pideSirliPizza,pideFarshemPizza , MenuConstants.menuBack};

    SendPhoto sendPizzaTypes(Update update ,String urlImage);
}
