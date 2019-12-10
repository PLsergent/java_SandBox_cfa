package front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Navigate implements ActionListener {

    private JFrame window;

    Navigate(JFrame window) {
        this.window = window;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String actionCommand = actionEvent.getActionCommand();

        switch (actionCommand) {
            case "Home":
                new Home();
                this.window.setVisible(false);
                break;
            case "Search": {
                new Search();
                this.window.setVisible(false);
                break;
            }
            case "Add card": {
                new AddCard();
                this.window.setVisible(false);
                break;
            }
            case "All cards": {
                new AllCards();
                this.window.setVisible(false);
                break;
            }
        }
    }
}
