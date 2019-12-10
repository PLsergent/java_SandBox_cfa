package front;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class Search extends ActionScreen {

    private static final String title = "Search";

    Search() {
        super(title);

        GridBagConstraints c = new GridBagConstraints();

        // Create TextField
        JTextField searchField = new JTextField(30);
        Border searchFieldBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        Font searchFont = new Font("Arial", Font.PLAIN, 25);
        searchField.setBorder(searchFieldBorder);
        searchField.setFont(searchFont);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(40,0,0,0);  //top padding
        c.gridx = 0;       //aligned with button 2
        c.gridwidth = 5;   //2 columns wide
        c.gridy = 0;       //third row
        this.mainPanel.add(searchField, c);

        JButton searchButton = new JButton("Search");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(40,0,0,0);  //top padding
        c.gridx = 7;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 0;       //third row
        Font buttonFont = new Font("Arial", Font.PLAIN, 18);
        searchButton.setFont(buttonFont);
        searchButton.addActionListener(new ClickSearch(this.mainPanel, this.screenWindow, searchField));
        this.mainPanel.add(searchButton, c);
    }
}
