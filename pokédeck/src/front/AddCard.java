package front;


import back.Card;
import back.Collection;
import back.Pokemon;

import javax.swing.*;
import java.awt.*;


public class AddCard extends ActionScreen {

    private static final String title = "Add card";

    AddCard() {
        super(title);

        Font buttonFont = new Font("Arial", Font.PLAIN, 20);
        JButton addBlankCard = new JButton("Add blank pokémon card");
        addBlankCard.addActionListener(e -> {
            Card card = new Pokemon();
            Collection collection = Collection.getInstance();
            collection.addToCollection(card);
        });
        addBlankCard.setFont(buttonFont);

        this.mainPanel.add(addBlankCard);
    }
}