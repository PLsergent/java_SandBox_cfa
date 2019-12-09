package front;

import javax.swing.*;
import java.awt.*;


public abstract class ActionScreen {

    protected JPanel mainPanel;
    protected JFrame screenWindow;

    ActionScreen(String title) {
        this.screenWindow = new JFrame("Pokédeck");
        this.mainPanel = new JPanel(new GridBagLayout());

        screenWindow.setSize(1500, 800);
        screenWindow.setLayout(new BorderLayout());
        screenWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screenWindow.add(this.mainPanel, BorderLayout.CENTER);
        new NavBar(title, this.screenWindow);
        screenWindow.setVisible(true);
    }

    public JPanel getPanel() { return mainPanel; }

    public JFrame getFrame() { return screenWindow; }
}
