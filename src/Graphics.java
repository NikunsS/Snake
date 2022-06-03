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
    private Timer t = new Timer(75, this);

    public Graphics(MainWindow g) {
        t.start();

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

        g2D.setColor(Color.black);
        g2D.fillRect(0, 0, MainWindow.SCREEN_WIDTH * MainWindow.DIMENSION + 5, MainWindow.SCREEN_HEIGHT * MainWindow.DIMENSION + 5);

        if(state == "START") {
            JButton startButton = new JButton("Start");
            startButton.add(startButton);
            startButton.setBounds((MainWindow.SCREEN_HEIGHT*MainWindow.DIMENSION-100)/2,(MainWindow.SCREEN_HEIGHT*MainWindow.DIMENSION-200)/2,100,200);
            startButton.addActionListener(e -> state = "RUNNING");
        }

        if(state == "RUNNING") {
            g2D.setColor(Color.red);
            g2D.fillOval(fruit.getX() * MainWindow.DIMENSION, fruit.getY() * MainWindow.DIMENSION, MainWindow.DIMENSION, MainWindow.DIMENSION);

            g2D.setColor(Color.green);
            for (Rectangle r : snake.getBody()) {
                g2D.fill(r);
            }
        }
        if(state == "END") {
            g2D.setColor(Color.WHITE);
            g2D.drawString("Score: " + (snake.getBody().size() - 3), MainWindow.SCREEN_WIDTH/2 * MainWindow.DIMENSION - 40, MainWindow.SCREEN_HEIGHT / 2 * MainWindow.DIMENSION - 20);
        }
    }
    public void actionPerformed(ActionEvent e) {
        repaint();
        game.update();
    }


}
