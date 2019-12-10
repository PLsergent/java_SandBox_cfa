package front;

import back.Card;
import back.Collection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClickSearch implements ActionListener {

    private JPanel mainPanel;
    private JTextField searchField;

    ClickSearch(JPanel mainPanel, JTextField searchField) {
        this.mainPanel = mainPanel;
        this.searchField = searchField;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        Collection collection = Collection.getInstance();
        ArrayList<Card> cards = collection.getCards();

        String searchText = this.searchField.getText();
        Pattern pattern = Pattern.compile(searchText, Pattern.CASE_INSENSITIVE);

        ArrayList<Card> results = new ArrayList<Card>();

        for (Card card : cards) {
            Matcher nameMatcher = pattern.matcher(card.getCardName());
            Matcher cardTypeMatcher = pattern.matcher(card.getCardType());
            Matcher typeMatcher = pattern.matcher(card.getType());
            Matcher expMatcher = pattern.matcher(card.getExpansionName());
            if (nameMatcher.find() || cardTypeMatcher.find() || typeMatcher.find() || expMatcher.find()) {
                results.add(card);
            }
        }

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;       //reset to default
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(100,0,0,0);  //top padding
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 10;

        JButton resultButton;
        for (int i=0; i < results.size(); i++) {
            resultButton = new JButton(cards.get(i).getCardName() + ", " +cards.get(i).getCardType());
            System.out.println(results.get(i).getCardName());
            c.insets = new Insets(100+40*i,0,0,0);
            this.mainPanel.add(resultButton, c);
        }
        this.mainPanel.revalidate();
    }
}
