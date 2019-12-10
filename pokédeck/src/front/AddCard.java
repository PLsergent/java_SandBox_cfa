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

        JLabel justToTest = new JLabel("Development stage button: ");
        Font buttonFont = new Font("Arial", Font.PLAIN, 20);
        JButton addBlankCard = new JButton("Add blank pokémon card");
        addBlankCard.addActionListener(e -> {
            Card card = new Pokemon();
            Collection collection = Collection.getInstance();
            collection.addToCollection(card);
        });
        addBlankCard.setFont(buttonFont);

        JButton removeLastCard = new JButton("Remove last card");
        removeLastCard.addActionListener(e -> {
            Collection collection = Collection.getInstance();
            Card lastCard = collection.getCards().get(collection.getCards().size()-1);
            collection.removeFromCollection(lastCard);
        });
        removeLastCard.setFont(buttonFont);

        this.mainPanel.add(justToTest);
        this.mainPanel.add(addBlankCard);
        this.mainPanel.add(removeLastCard);
    }
}