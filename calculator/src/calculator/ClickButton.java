package calculator;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextArea;

public class ClickButton implements ActionListener {

    private JTextArea textArea;

    private final static String regEx = "^-([.0-9]+[\\+\\-\\*\\/]{1})+[.0-9]+$";
    private final static String regOpEx = "[\\+\\-\\*\\/]";
    private final static String firstPriority =  "[\\*\\/]";
    private final static String secondPriority = "[\\+\\-]";

    static public final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";

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
            
            if (matcher.find()) {
                this.compute();
            } else {
                this.textArea.setText("Invalid expression");
                System.out.println("Please enter a valid expression.");
            }
        } else {
            this.textArea.append(command);
        }
    }

    public void compute() {
        String expression = this.textArea.getText();

        // Get the expression and create an array that split before and after operators
        // 5+5 => [5, +, 5]
        String[] expSplit = expression.split(String.format(WITH_DELIMITER, regOpEx));
        ArrayList<String> expressionArray = new ArrayList<String>(Arrays.asList(expSplit));

        // Pattern to check the regex
        Pattern firstPattern = Pattern.compile(firstPriority);
        Pattern secondPattern = Pattern.compile(secondPriority);

        // Check if there is any */ or +- inside the expression
        Matcher matcher1 = firstPattern.matcher(expression);
        Matcher matcher2 = secondPattern.matcher(expression);
    
        Boolean firstPriorityFound;
        Boolean secondPriorityFound;


        // Manage if first number is negative
        if (expressionArray.get(0).equals("-")) {
            expressionArray.add(0, "0");
        }

        // ================================ FIRST PRIORITY * / ================================

        if (matcher1.find()) {
            do {
                firstPriorityFound = false;
                int i = 0;
                while (i < expressionArray.size()) {

                    if (expressionArray.get(i).equals("/")) {
    
                        expressionArray.set(i-1, String.valueOf(Double.parseDouble(expressionArray.get(i-1)) / Double.parseDouble(expressionArray.get(i+1))));
                        expressionArray.remove(i+1);
                        expressionArray.remove(i);
    
                        firstPriorityFound = true;
                        break;
    
                    } else if (expressionArray.get(i).equals("*")) {

                        expressionArray.set(i-1, String.valueOf(Double.parseDouble(expressionArray.get(i-1)) * Double.parseDouble(expressionArray.get(i+1))));
                        expressionArray.remove(i+1);
                        expressionArray.remove(i);
    
                        firstPriorityFound = true;
                        break;
                    }
                    i++;
                }
            } while (firstPriorityFound);
        }

        // ================================ SECOND PRIORITY + - ================================

        if (matcher2.find()) {
            do {
                secondPriorityFound = false;
                int i = 0;
                while (i < expressionArray.size()) {

                    if (expressionArray.get(i).equals("+")) {
                        
                        expressionArray.set(i-1, String.valueOf(Double.parseDouble(expressionArray.get(i-1)) + Double.parseDouble(expressionArray.get(i+1))));
                        expressionArray.remove(i+1);
                        expressionArray.remove(i);

                        secondPriorityFound = true;
                        break;
    
                    } else if (expressionArray.get(i).equals("-")) {
    
                        expressionArray.set(i-1, String.valueOf(Double.parseDouble(expressionArray.get(i-1)) - Double.parseDouble(expressionArray.get(i+1))));
                        expressionArray.remove(i+1);
                        expressionArray.remove(i);
    
                        secondPriorityFound = true;
                        break;
                    }
                    i++;
                }
            } while (secondPriorityFound);
        }
        
        this.textArea.setText(expressionArray.get(0));
    }
}