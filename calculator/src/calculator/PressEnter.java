package calculator;

import java.awt.event.*;
import javax.swing.JTextArea;


public class PressEnter implements KeyListener {

    private JTextArea textArea;

    PressEnter(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void keyTyped(KeyEvent e) {
        // Invoked when a key has been typed.
    }

    public void keyPressed(KeyEvent e) {
        // Invoked when a key has been pressed.
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            ClickButton.compute(this.textArea);
        }
    }

    public void keyReleased(KeyEvent e) {
        // Invoked when a key has been released.
    }
}