import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Graphics extends JPanel implements ActionListener{
    private Snake snake;
    private Fruit fruit;
    private MainWindow game;
    String state;
    private Timer t = new Timer(100, this);

    public Graphics(MainWindow g) {
       // t.start();
        state = "START";

        game = g;
        snake = g.getSnake();
        fruit = g.getFruit();

        this.addKeyListener(g);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        if(state == "RUNNING") {
            g2D.setColor(Color.red);
            g2D.fillRect(fruit.getX() * MainWindow.DIMENSION, fruit.getY() * MainWindow.DIMENSION, MainWindow.DIMENSION, MainWindow.DIMENSION);

            g2D.setColor(Color.green);
            for (Rectangle r : snake.getBody()) {
                g2D.fill(r);
            }
        }
    }
    public void actionPerformed(ActionEvent e) {
        repaint();
        game.update();
    }


}
