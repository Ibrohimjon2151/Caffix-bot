package com.example.caffix.bot.interfaces;

import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;

public interface LavashConstants {



    SendPhoto sendLavashType(Update update , String imageUrl);
    SendPhoto orderFirstLavash(String firstButton , String secondButton , Update update, String imageUrl);
    SendPhoto orderCaffixLavash(Update update , String imageurl);

    // lavash Menu
    String firstNameLavash = "\uD83C\uDF2F Tandir Lavash";
    String secondNameLavash = "\uD83E\uDED4 Caffix";
    String thirdNameLavash = "\uD83C\uDF54 Shaurma";
    String fourthdNameLavash = "\uD83C\uDF2F Mangal lavashi";
    String fifthdNameLavash = "\uD83C\uDF5F Klab";
    String sixthdNameLavash = "\uD83C\uDF5F Non Kabob";

    // Tandir Lavash Menu
    String tandirLavashOne = "\uD83C\uDF2F Mol Go'shtli";
    String tandirLavashTwo = "\uD83E\uDED4 Tovuqli";

    // Caffix lavash type
    String caffixMiniLavash = "\uD83C\uDF2F Mini";
    String caffixClasicLavash = "\uD83E\uDED4 Klassik";
    String caffixOstiriyLavash = "\uD83C\uDF2F Achchiq";
    String caffixSirliyLavash = "\uD83E\uDED4 Sirli";

    // Shaurma
    String shaurmaSmall ="\uD83C\uDF2F Mini";
    String shaurmaBig ="\uD83E\uDED4 Max";

    // Klab
    String klabTovuqli = "\uD83C\uDF2F Klab Tovuqli";
    String klabGoshtli = "\uD83E\uDED4 Klab Tovuqli";

    // non lavash
    String breadLavash = "\uD83E\uDED4 Non Kabob";
    String breadDonar = "\uD83E\uDED4 Donar";


//    EditMessageText orderShaurmaLavash(Update update  , String imageUrl);

    SendPhoto orderKlab(Update update , String imageUrl);

//    SendPhoto orderBreadLavash(Update update , String imageUrl);
}
