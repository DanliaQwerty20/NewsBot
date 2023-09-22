package io.pro3jct.bot;

import io.pro3jct.bot.config.BotConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
@Component
@Slf4j
public class MyTelegramBot extends TelegramLongPollingBot {
    @Autowired
    private final BotConfig botConfig;

    public MyTelegramBot(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }
    public void sendWelcomeMessage(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Добро пожаловать! Этот бот поможет вам...");

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onUpdateReceived(Update update) {
        if(update.getMessage().hasText() && update.hasMessage()){
            String messageText=update.getMessage().getText();
            update.getMessage().getChat().getBio();
            long chatId=update.getMessage().getChatId();
            switch (messageText){
                case "/start":
                    sendWelcomeMessage(chatId);
            }
        }

    }


}
