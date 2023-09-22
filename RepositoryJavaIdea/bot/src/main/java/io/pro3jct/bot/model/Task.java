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
@Entity(name="tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chatId;
    private String title;
    private String description;

    private String videoUrl;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignedUser;

    @Override
    public String toString() {
        return "User{" +
                "chatId=" + chatId +
                ", title='" + title + '\'' +
                ", description='" + description+
                '}';
    }

}
