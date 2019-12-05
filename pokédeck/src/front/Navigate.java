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
        if (actionCommand.equals("Search")) {
            Search search = new Search();
            this.window.add(search.getPanel());
        }
    }
}
