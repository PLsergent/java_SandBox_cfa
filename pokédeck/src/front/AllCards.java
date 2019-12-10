package front;


import back.Card;
import back.Collection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AllCards extends ActionScreen {

    private static final String title = "All cards";

    AllCards() {
        super(title);

        Collection collection = Collection.getInstance();
        ArrayList<Card> cards = collection.getCards();

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;       //reset to default
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(100,0,0,0);  //top padding
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 10;
        c.weighty = 1;
        c.weightx = 1;

        JButton resultButton;
        for (int i=0; i < cards.size(); i++) {
            resultButton = new JButton(cards.get(i).getCardName() + ", " +cards.get(i).getCardType());
            System.out.println(cards.get(i).getCardName());
            c.insets = new Insets(100+40*i,300,0,300);
            this.mainPanel.add(resultButton, c);
        }
        this.mainPanel.revalidate();
    }
}
