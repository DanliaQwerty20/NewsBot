package io.pro3ct.FlowersBot.service;

import io.pro3ct.FlowersBot.MyFlowersTelegramBot;
import io.pro3ct.FlowersBot.model.Bouquet;
import io.pro3ct.FlowersBot.repository.BouquetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class SendMessage {
    @Autowired
    private BouquetRepository bouquetRepository;

    MyFlowersTelegramBot bot;
    public SendMessage(@Lazy MyFlowersTelegramBot bot) {
        this.bot=bot;
    }
    public void send(long chatId) throws FileNotFoundException {
        SendMediaGroup sendMediaGroup=new SendMediaGroup();
        sendMediaGroup.setChatId(String.valueOf(chatId));
        List<InputMedia> mediaGroup = new ArrayList<>();
        log.info("зашли в отправку сообщений");



        File imageFile1 = new File("src/main/resources/static/img/20230731_172942.jpg");
        String imgPhoto1 = imageFile1.getName();
        InputStream imageStream1 = new FileInputStream(imageFile1);
        String photoCaption1 = "Цветочные стабилизированные композиции в стеклянных сосудах можно\n" +
                "поставить на журнальный столик в гостиной или прикроватную тумбочку\n" +
                "в спальне. Они идеально подходят для озеленения ванных комнат.\n" +
                "Стекло защищает нежные лепестки от перепада температур и\n" +
                "влажности. Вазочки с роскошными розами идеальны для украшения\n" +
                "праздничного стола, их часто используют для декорирования свадеб и\n" +
                "юбилеев.\n" +
                "\uD83D\uDCB02890\n"+
                "\uD83D\uDE9A Товар с доставкой";
        //

        File imageFile2 = new File("src/main/resources/static/img/20230731_172954.jpg");
        String imgPhoto2 = imageFile2.getName();
        InputStream imageStream2 = new FileInputStream(imageFile2);

        //
        File imageFile3 = new File("src/main/resources/static/img/20230731_173015.jpg");
        String imgPhoto3 = imageFile3.getName();
        InputStream imageStream3 = new FileInputStream(new File("src/main/resources/static/img/20230731_173015.jpg"));

        log.info("добавили в input фотки");
        // Добавление фотографий в группу медиа
        InputMediaPhoto inputMediaPhoto1 = new InputMediaPhoto();
        inputMediaPhoto1.setMedia(imageStream1,imgPhoto1);
        inputMediaPhoto1.setCaption(photoCaption1);
        //
        InputMediaPhoto inputMediaPhoto2 = new InputMediaPhoto();
        inputMediaPhoto2.setMedia(imageStream2,imgPhoto2);
        //
        InputMediaPhoto inputMediaPhoto3 = new InputMediaPhoto();
        inputMediaPhoto3.setMedia(imageStream3,imgPhoto3);
        log.info("добавили в группу фотки");
        mediaGroup.add(inputMediaPhoto1);
        mediaGroup.add(inputMediaPhoto2);
        mediaGroup.add(inputMediaPhoto3);
        // Создание запроса на отправку группы медиа

        sendMediaGroup.setMedias(mediaGroup);
        log.info("запрос на отправку");
        try {
            // Отправка группы медиа
            bot.execute(sendMediaGroup);
            log.info("отправили фотки");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }
    public void send1(long chatId) throws FileNotFoundException{
        //получаем список букетов
        Iterable<Bouquet> employeesOptional = bouquetRepository.findAll();
        //список букетов
        List<InputMedia> mediaGroup = new ArrayList<>();
        //добавили чат айди пользователя

        for (Bouquet b : employeesOptional){
            InputMediaPhoto inputMediaPhoto = new InputMediaPhoto();
            inputMediaPhoto.setMedia(new File(b.getFilePath()), b.getFileName());
            inputMediaPhoto.setCaption(b.getDescription());

            mediaGroup.add(inputMediaPhoto);
        }

        SendMediaGroup sendMediaGroup = new SendMediaGroup();
        sendMediaGroup.setChatId(String.valueOf(chatId));
        sendMediaGroup.setMedias(mediaGroup);

        try {
            // Отправка группы медиа
            bot.execute(sendMediaGroup);
            log.info("отправили фотки");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

}
