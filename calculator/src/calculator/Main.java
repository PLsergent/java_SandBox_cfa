package calculator;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main (String[] args) {
        JPanel screenInputPanel = new JPanel(new BorderLayout());
        JTextArea screen = new JTextArea();
        Font font = new Font("Arial", Font.BOLD, 40);
        screen.setFont(font);
        screenInputPanel.add(screen, BorderLayout.CENTER);

        JPanel numbersPanel = new JPanel(new GridLayout(5, 4));
        String[] numbers = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", ".", "0", "C", "/", "", "", "", "="};
        for (String i : numbers) {
            JButton b = new JButton(i);
            numbersPanel.add(b);
            b.addActionListener(new ClickButton(screen));
        }
        
        JFrame window = new JFrame("Calculator");
        window.setSize(400, 600);
        window.setLayout(new GridLayout(2, 1));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(screenInputPanel);
        window.add(numbersPanel);
        window.setVisible(true);
    }
}