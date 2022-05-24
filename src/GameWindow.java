import java.awt.*;
import javax.swing.*;
public class GameWindow {

    static final int SCREEN_WIDTH = 30;
    static final int SCREEN_HEIGHT = 30;
    static final int DIMENSION = 25;

    private Graphics g;
    private JFrame mainFrame;
    private Fruit fruit;
    public GameWindow() {
        mainFrame = new JFrame();

        mainFrame.setTitle("Snake");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(SCREEN_WIDTH*DIMENSION, SCREEN_HEIGHT*DIMENSION);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.getContentPane().setBackground(Color.BLACK);
    }


}
