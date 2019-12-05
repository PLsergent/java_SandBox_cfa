import com.jogamp.newt.event.WindowEvent;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.*;
import java.awt.event.WindowAdapter;

public class Main {

    public static void main (String[] args) {
        new Thread(() -> {
            JFrame frame = new JFrame("Welcome to the jogl");
            GLCanvas canvas = new GLCanvas();

            // Setup GL canvas
            frame.add(canvas);
            canvas.addGLEventListener(new Renderer());
            canvas.destroy();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            // Setup AWT frame
            frame.setSize(1000, 600);
            frame.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    frame.dispose();
                    System.exit(0);
                }
            });

            frame.setVisible(true);

            // Render loop
            while(true) {
                canvas.display();
            }
        }).start();
    }
}
