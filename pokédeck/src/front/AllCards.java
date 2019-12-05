package front;

import javax.swing.*;
import java.awt.*;


public class AllCards {

    private JPanel mainPanel;
    private JFrame cardWindow;

    AllCards() {
        this.cardWindow = new JFrame("Pokédeck");
        this.mainPanel = new JPanel(new BorderLayout());

        cardWindow.setSize(1500, 800);
        cardWindow.setLayout(new BorderLayout());
        cardWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardWindow.add(this.mainPanel, BorderLayout.CENTER);
        new NavBar("All cards", this.cardWindow);
        cardWindow.setVisible(true);
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    public JFrame getFrame() {
        return cardWindow;
    }
}
