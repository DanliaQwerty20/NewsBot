package io.pro3ct.FlowersBot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bouquet {
    @Id
    private long id;

    private String name;
    private int price;
    private String description;



    public String toString(){
        return getName()+"\n\n\uD83D\uDCB0"+ getPrice() + "\n\n" + getDescription() + "\n\n\uD83D\uDE9A Товар с доставкой";
    }
}

