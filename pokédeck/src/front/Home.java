package front;

import javax.swing.*;
import java.awt.*;


public class Home {

    public Home() {
        JFrame window = new JFrame("Pokédeck");
        JPanel screenInputPanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Welcome to the pokédeck");
        Font font = new Font("Arial", Font.BOLD, 40);
        title.setFont(font);
        screenInputPanel.add(title, BorderLayout.CENTER);

        JPanel menuPanel = new JPanel(new GridLayout(1, 3));
        String[] items = {"Search", "Add card", "All cards"};
        for (String i : items) {
            JButton b = new JButton(i);
            menuPanel.add(b);
            b.addActionListener(new Navigate(window));
        }

        window.setSize(1500, 800);
        window.setLayout(new GridLayout(2, 1));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(screenInputPanel);
        window.add(menuPanel);
        window.setVisible(true);
    }
}
