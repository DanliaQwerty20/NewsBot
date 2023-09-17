package io.pro3ct.FlowersBot.service;

import io.pro3ct.FlowersBot.MyFlowersTelegramBot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class CreateNewBouquet {

    private MyFlowersTelegramBot myFlowersTelegramBot;

    public CreateNewBouquet(@Lazy MyFlowersTelegramBot myFlowersTelegramBot) {
        this.myFlowersTelegramBot = myFlowersTelegramBot;
    }

}
