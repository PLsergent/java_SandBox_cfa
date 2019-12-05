package front;

import javax.swing.*;
import java.awt.*;

public class Search {

    private JPanel mainPanel;
    private JFrame searchWindow;

    Search() {
        this.searchWindow = new JFrame("Pokédeck");
        this.mainPanel = new JPanel(new BorderLayout());

        searchWindow.setSize(1500, 800);
        searchWindow.setLayout(new BorderLayout());
        searchWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchWindow.add(this.mainPanel, BorderLayout.CENTER);
        new NavBar("Search", this.searchWindow);
        searchWindow.setVisible(true);
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    public JFrame getFrame() {
        return searchWindow;
    }
}
