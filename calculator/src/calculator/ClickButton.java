package calculator;

import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextArea;

public class ClickButton implements ActionListener {

    private JTextArea textArea;
    private final static String regEx = "^(\\d+[\\+\\-\\*\\/]{1})+\\d+$";

    ClickButton(JTextArea textArea) {
        super();
        this.textArea = textArea;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command == "C") {
            this.textArea.setText("");
        } else if (command == "=") {
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(this.textArea.getText());
            System.out.println(this.textArea.getText());
            
            if (matcher.find()) {
                this.compute();
            } else {
                System.out.println("Please enter a valid expression.");
            }
        } else {
            this.textArea.append(command);
        }
    }

    public void compute() {
        this.textArea.setText("");
        System.out.println("J'ai calculé ou pas");
    }
}