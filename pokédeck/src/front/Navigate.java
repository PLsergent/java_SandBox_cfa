package front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Navigate implements ActionListener {

    private JFrame window;

    Navigate(JFrame window) {
        super();
        this.window = window;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String actionCommand = actionEvent.getActionCommand();

        switch (actionCommand) {
            case "Home":
                Home home = new Home();
                this.window.setVisible(false);
                break;
            case "Search": {
                Search search = new Search();
                this.window.setVisible(false);
                break;
            }
            case "Add card": {
                AddCard addCard = new AddCard();
                this.window.setVisible(false);
                break;
            }
            case "All cards": {
                AllCards allCards = new AllCards();
                this.window.setVisible(false);
                break;
            }
        }
    }
}
