package front;

import javax.swing.*;
import java.awt.*;


public class NavBar {

    private JPanel navPanel;

    NavBar(String title, JFrame window) {
        this.navPanel = new JPanel(new GridLayout(1, 5));

        JLabel titleLabel = new JLabel(title);
        Font font = new Font("Arial", Font.BOLD, 25);
        Font buttonFont = new Font("Arial", Font.PLAIN, 25);
        titleLabel.setFont(font);
        this.navPanel.add(titleLabel);

        String[] items = {"Home", "Search", "Add card", "All cards"};
        for (String i : items) {
            JButton b = new JButton(i);
            navPanel.add(b);
            b.setFont(buttonFont);
            b.addActionListener(new Navigate(window));
        }
        window.add(navPanel, BorderLayout.NORTH);
    }

    public JPanel getPanel() {
        return this.navPanel;
    }
}
