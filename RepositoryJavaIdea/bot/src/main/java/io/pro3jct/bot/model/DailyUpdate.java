package io.pro3jct.bot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="daily_updates")
public class DailyUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;

    private Date date;
    private String content;

    @Override
    public String toString() {
        return "User{" +
                "chatId=" + chatId +
                ", date='" + date + '\'' +
                ", content='" + content +
                '}';
    }
}
