package io.pro3jct.bot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;

    private double amount;
    private String method;
    private boolean isPaid;

    // Другие атрибуты

    // Связь с пользователем
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "User{" +
                "chatId=" + chatId +
                ", amount='" + amount + '\'' +
                ", method='" + method + '\'' +isPaid+ '\''+
                '}';
    }

}
