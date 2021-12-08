package com.example.caffix.bot;

import com.example.caffix.DBconfig.entity.Basket;
import com.example.caffix.DBconfig.entity.OrderProduct;
import com.example.caffix.DBconfig.entity.Product;
import com.example.caffix.DBconfig.entity.User;
import com.example.caffix.DBconfig.repository.*;
import com.example.caffix.DBconfig.service.UserService;
import com.example.caffix.bot.MethodsService.BasketService;
import com.example.caffix.bot.MethodsService.LavashServices;
import com.example.caffix.bot.MethodsService.PizzaServices;
import com.example.caffix.bot.MethodsService.SendServices;
import com.example.caffix.bot.constants.ConstantaNumbers;
import com.example.caffix.bot.constants.MenuConstants;
import com.example.caffix.bot.constants.BotState;
import com.example.caffix.bot.constants.ProductNames;
import com.example.caffix.bot.interfaces.BasketConstants;
import com.example.caffix.bot.interfaces.LavashConstants;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BotService extends TelegramLongPollingBot {
    @Value("${bot.token}")
    String token;
    @Value("${bot.username}")
    String username;


    static SendServices sendServices = new SendServices();

    static LavashServices lavashServices = new LavashServices();

    static PizzaServices pizzaServices = new PizzaServices();

    static UserService userService = new UserService();

    static BasketService basketService = new BasketService();

    static String message;
    static String state = null;

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductPriceRepository productPriceRepository;

    @Autowired
    OrderProductRepository orderProductRepository;

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {

        String urlMenu = "src/main/resources/Main images/";

        if (update.hasCallbackQuery()) {

            Long chatId = update.getCallbackQuery().getMessage().getChatId();
            Optional<User> byChatId = userRepository.findByChatId(chatId);
            String data = update.getCallbackQuery().getData();
            state = byChatId.get().getState();

            if (state.equals(BotState.start))
                for (int i = 1; i < 11; i++) {
                    if (data.equals(String.valueOf(i))) {
                        userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.ordered, userRepository);
                        break;
                    }
                }
            state = userRepository.findByChatId(chatId).get().getState();


            switch (state) {
                case BotState.start:
                    switch (data) {
                        case MenuConstants.menuLavash:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.menuCategory, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(lavashServices.sendLavashType(update, urlMenu + "lavash.jpg"));
                            break;
                        case MenuConstants.menuPizza:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.menuPizza, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(pizzaServices.sendPizzaTypes(update, urlMenu + "PizzaMenu.jpg"));
                            break;
                        case MenuConstants.menuDoner:
                            //LavashService()
                            break;
                        case MenuConstants.menuFastFood:
                            //LavashService()
                            break;
                        case MenuConstants.menuMeat:
                            //LavashService()
                            break;
                        case MenuConstants.menuChiken:
                            //LavashService()
                            break;
                        case MenuConstants.menuSoup:
                            //LavashService()
                            break;
                        case MenuConstants.menuSteak:
                            //LavashService()
                            break;
                        case MenuConstants.menuSalat:
                            //LavashService()
                            break;
                        case MenuConstants.menuDrinks:
                            //LavashService()
                            break;
                        case MenuConstants.menuBread:
                            //LavashService()
                            break;
                        case MenuConstants.menuBasket:
                            execute(sendServices.deleteMessage(update));
                            Optional<Basket> optional = basketRepository.findByChatId(update.getCallbackQuery().getMessage().getChatId());
                            if (optional.isPresent()) {
                                userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.saveToBasket, userRepository);
                            } else {
                                userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.start, userRepository);
                            }
                            execute(basketService.sendOrderedProducts(update, basketRepository, orderProductRepository));
                            break;

                        default:

                    }
                    break;
                case BotState.menuCategory:
                    switch (data) {
                        case LavashConstants.firstNameLavash:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.firtsLavash, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(lavashServices.orderFirstLavash(LavashConstants.tandirLavashOne, LavashConstants.tandirLavashTwo, update, urlMenu + "tandirLavash.jpg"));
                            break;
                        case LavashConstants.secondNameLavash:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.caffixLavash, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(lavashServices.orderCaffixLavash(update, urlMenu + "caffies.jpg"));
                            break;
                        case LavashConstants.thirdNameLavash:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.shaurmaLavash, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(lavashServices.orderFirstLavash(LavashConstants.shaurmaSmall, LavashConstants.shaurmaBig, update, urlMenu + "shaurma.jpg"));
                            break;
                        case LavashConstants.fourthdNameLavash:
                            execute(sendServices.deleteMessage(update));
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.ordered, userRepository);
                            execute(sendServices.orderedProduct(ProductNames.mangalLavash, update, productRepository, productPriceRepository));
                            break;
                        case LavashConstants.fifthdNameLavash:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.klabLavash, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(lavashServices.orderKlab(update, urlMenu + "klabOne.jpg"));
                            break;
                        case LavashConstants.sixthdNameLavash:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.breadLavash, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(lavashServices.orderFirstLavash(LavashConstants.breadLavash, LavashConstants.breadDonar, update, urlMenu + "breadKabob.jpg"));
                            break;
                        case MenuConstants.menuBack:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.start, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(sendServices.sendCategory(update));
                            break;
                        default:
                    }
                    break;
                case BotState.firtsLavash:
                    switch (data) {
                        case LavashConstants.tandirLavashOne:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.ordered, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(sendServices.orderedProduct(ProductNames.TandirLavashMax, update, productRepository, productPriceRepository));
                            break;
                        case LavashConstants.tandirLavashTwo:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.ordered, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(sendServices.orderedProduct(ProductNames.TandirLavashMini, update, productRepository, productPriceRepository));
                            break;
                        case MenuConstants.menuBack:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.menuCategory, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(lavashServices.sendLavashType(update, urlMenu + "lavash.jpg"));
                            break;

                    }
                    break;
                case BotState.caffixLavash:
                    switch (data) {
                        case LavashConstants.caffixMiniLavash:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.ordered, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(sendServices.orderedProduct(ProductNames.MiniLavashCaffix, update, productRepository, productPriceRepository));
                            break;
                        case LavashConstants.caffixClasicLavash:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.ordered, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(sendServices.orderedProduct(ProductNames.ClassicLavashCaffix, update, productRepository, productPriceRepository));
                            break;
                        case LavashConstants.caffixOstiriyLavash:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.ordered, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(sendServices.orderedProduct(ProductNames.AcchiqLavashCaffix, update, productRepository, productPriceRepository));
                            break;
                        case LavashConstants.caffixSirliyLavash:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.ordered, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(sendServices.orderedProduct(ProductNames.SirliLavashCaffix, update, productRepository, productPriceRepository));
                            break;
                        case MenuConstants.menuBack:
                            execute(sendServices.deleteMessage(update));
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.menuCategory, userRepository);
                            execute(lavashServices.sendLavashType(update, urlMenu + "lavash.jpg"));
                            break;
                    }
                    break;
                case BotState.shaurmaLavash:
                    switch (data) {
                        case LavashConstants.shaurmaSmall:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.ordered, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(sendServices.orderedProduct(ProductNames.miniShaurma, update, productRepository, productPriceRepository));
                            break;
                        case LavashConstants.shaurmaBig:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.ordered, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(sendServices.orderedProduct(ProductNames.maxShaurma, update, productRepository, productPriceRepository));
                            break;
                        case MenuConstants.menuBack:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.menuCategory, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(lavashServices.sendLavashType(update, urlMenu + "lavash.jpg"));
                            break;
                    }
                    break;
                case BotState.klabLavash:
                    switch (data) {
                        case LavashConstants.klabTovuqli:
                            execute(sendServices.deleteMessage(update));
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.ordered, userRepository);
                            execute(sendServices.orderedProduct(ProductNames.klabTvuqli, update, productRepository, productPriceRepository));
                            break;
                        case LavashConstants.klabGoshtli:
                            execute(sendServices.deleteMessage(update));
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.ordered, userRepository);
                            execute(sendServices.orderedProduct(ProductNames.klabGoshtli, update, productRepository, productPriceRepository));
                            break;
                        case MenuConstants.menuBack:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.menuCategory, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(lavashServices.sendLavashType(update, urlMenu + "lavash.jpg"));
                            break;
                    }
                    break;
                case BotState.breadLavash:
                    switch (data) {
                        case LavashConstants.breadLavash:
                            execute(sendServices.deleteMessage(update));
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.ordered, userRepository);
                            execute(sendServices.orderedProduct(ProductNames.breadLavash, update, productRepository, productPriceRepository));
                            break;
                        case LavashConstants.breadDonar:
                            execute(sendServices.deleteMessage(update));
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.ordered, userRepository);
                            execute(sendServices.orderedProduct(ProductNames.breadDonor, update, productRepository, productPriceRepository));
                            break;
                        case MenuConstants.menuBack:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.menuCategory, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(lavashServices.sendLavashType(update, urlMenu + "lavash.jpg"));
                            break;

                    }
                    break;
                case BotState.ordered:
                    execute(sendServices.deleteMessage(update));
                    execute(sendServices.saveProduct(update, productRepository, productPriceRepository, basketRepository, userRepository, orderProductRepository));
                    Optional<Product> optional = productRepository.findByUserId(update.getCallbackQuery().getMessage().getChatId());
                    if (optional.isPresent()) {
                        userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.ordered, userRepository);
                    } else {
                        userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.start, userRepository);
                    }
                    break;
                case BotState.saveToBasket:
                    switch (data) {
                        case BasketConstants.cancelOrder:
                            basketService.cancelOrderFromBasket(update, basketRepository, orderProductRepository);
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.start, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(sendServices.sendCategory(update));
                            break;
                        case BasketConstants.moreOrder:
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.start, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(sendServices.sendCategory(update));
                            break;
                        case BasketConstants.ordererProduct:
                            execute(sendServices.deleteMessage(update));
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.getLocation, userRepository);
                            execute(basketService.getLocation(update));
                            break;
                    }
                    execute(basketService.addProductOrSplit(update, orderProductRepository, basketRepository));
                    Optional<Basket> repositoryByChatId = basketRepository.findByChatId(update.getCallbackQuery().getMessage().getChatId());
                    if (repositoryByChatId.isEmpty()) {
                        execute(sendServices.sendCategory(update));
                        userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.start, userRepository);
                    }
                    break;
                case BotState.chooseYesOrNo:
                    switch (data) {
                        case BasketConstants.ordererProduct:
                            execute(sendServices.deleteMessage(update));
                            execute(basketService.sendOrderProductsToChanel(update, basketRepository, orderProductRepository));
                            Optional<User> byChatId1 = userRepository.findByChatId(update.getCallbackQuery().getMessage().getChatId());
                            if (byChatId1.get().getLocationLatitude() != null && byChatId1.get().getLocationLongitude() != null) {
                                execute(basketService.sendLocationToChanel(update, basketRepository));
                            }
                            execute(sendServices.thanksMessage(update));
                            execute(sendServices.sendCategory(update));
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.start, userRepository);
                            basketService.cancelOrderFromBasket(update, basketRepository, orderProductRepository);
                            userService.doEmpityLocation(update,userRepository);
                            break;
                        case BasketConstants.cancelOrder:
                            basketService.cancelOrderFromBasket(update, basketRepository, orderProductRepository);
                            userService.updateUserState(update.getCallbackQuery().getMessage().getChatId(), BotState.start, userRepository);
                            execute(sendServices.deleteMessage(update));
                            execute(sendServices.sendCategory(update));
                            break;
                    }
                    break;
                default:
            }


        } else if (update.getMessage().hasLocation()) {
            userService.updateUserLocation(update, userRepository);
            execute(basketService.chooseYexOrNo(update));
            userService.updateUserState(update.getMessage().getChatId(), BotState.chooseYesOrNo, userRepository);
        } else if (update.getMessage().hasContact()) {
            userService.saveUser(update, BotState.start, userRepository);
            execute(sendServices.sendPhotoMenu(String.valueOf(update.getMessage().getChatId()), urlMenu + "Menu.jpg", "Qisqacha menu \uD83D\uDC46\uD83D\uDC46\uD83D\uDC46 Caffix xizmatlar boti siz uchun 24 soat xizmatda"));
            execute(sendServices.sendCategory(update));
        }
        // Main service
        else if (update.hasMessage()) {
            message = update.getMessage().getText();

            if (message.equals("/start")) {
                Optional<User> byChatId = userRepository.findByChatId(update.getMessage().getChatId());
                if (byChatId.isPresent()) {
                    userService.updateUserState(update.getMessage().getChatId(), BotState.start, userRepository);
                    execute(sendServices.sendPhotoMenu(String.valueOf(update.getMessage().getChatId()), urlMenu + "Menu.jpg", "Qisqacha menu \uD83D\uDC46\uD83D\uDC46\uD83D\uDC46 Caffix xizmatlar boti siz uchun 24 soat xizmatda"));
                    execute(sendServices.sendCategory(update));
                } else {
                    execute(sendServices.WelcomeToBot(update));
                }
            } else if (message.length() > 3 && message.substring(0, 4).equals("+998")) {
                state = BotState.start;
                userService.saveUserByPhoneNumber(update, BotState.start, userRepository);
                execute(sendServices.sendPhotoMenu(String.valueOf(update.getMessage().getChatId()), urlMenu + "Menu.jpg", "Qisqacha menu \uD83D\uDC46\uD83D\uDC46\uD83D\uDC46 Caffix xizmatlar boti siz uchun 24 soat xizmatda"));
                execute(sendServices.sendCategory(update));
            } else {
                if (state == null) {
                    execute(sendServices.phoneNumberError(update));
                } else {
                    Optional<User> byChatId = userRepository.findByChatId(update.getMessage().getChatId());
                    state = byChatId.get().getState();
                    switch (state) {
                        case BotState.start:
                            break;
                        case BotState.getLocation:
                            userService.updateUserLocation(update, userRepository);
                            execute(basketService.chooseYexOrNo(update));
                            userService.updateUserState(update.getMessage().getChatId(), BotState.chooseYesOrNo, userRepository);
                            break;
                        default:
                    }
                }
            }
        }
    }


    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

}
