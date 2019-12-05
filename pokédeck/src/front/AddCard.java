package front;

import javax.swing.*;
import java.awt.*;


public class AddCard {

    private JPanel mainPanel;
    private JFrame addWindow;

    AddCard() {
        this.addWindow = new JFrame("Pokédeck");
        this.mainPanel = new JPanel(new BorderLayout());

        addWindow.setSize(1500, 800);
        addWindow.setLayout(new BorderLayout());
        addWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindow.add(this.mainPanel, BorderLayout.CENTER);
        new NavBar("Add card", this.addWindow);
        addWindow.setVisible(true);
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    public JFrame getFrame() {
        return addWindow;
    }
}