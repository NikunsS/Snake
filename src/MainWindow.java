import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class MainWindow implements KeyListener {

    static final int SCREEN_WIDTH = 30;
    static final int SCREEN_HEIGHT = 30;
    static final int DIMENSION = 30;

    private Graphics g;
    private  JFrame mainFrame;
    private JButton startButton;
    private Fruit fruit;
    private Snake snake;
    private Graphics graphics;

    public MainWindow() {
        mainFrame = new JFrame();
        WindowInit(mainFrame);
    }



    public void WindowInit(JFrame mainFrame){
        mainFrame.setTitle("Snake");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(SCREEN_WIDTH*DIMENSION, SCREEN_HEIGHT*DIMENSION);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.getContentPane().setBackground(Color.BLACK);
        graphics = new Graphics(this);
        mainFrame.add(graphics);

        startButton = new JButton("Start");
        startButton.setBounds((SCREEN_HEIGHT*DIMENSION-100)/2,(SCREEN_HEIGHT*DIMENSION-200)/2,100,200);
        startButton.addActionListener(e -> GameStart());
        mainFrame.add(startButton);
        
    }


    private void GameStart() {
        startButton.setVisible(false);
        graphics.state = "RUNNING";
        }


    public void update() {
        if(graphics.state == "RUNNING") {
            if(FruitCollisionCheck()) {
                snake.grow();
                fruit.generateNewFruit();
            }
            else if(WallCollisionCheck() || check_self_collision()) {
                graphics.state = "END";
            }
            else {
                snake.move();
            }
        }
    }

    private boolean WallCollisionCheck() {
        if(snake.getX() < 0 || snake.getX() >= SCREEN_WIDTH * DIMENSION
                || snake.getY() < 0|| snake.getY() >= SCREEN_HEIGHT * DIMENSION) {
            return true;
        }
        return false;
    }

    private boolean FruitCollisionCheck() {
        return snake.getX() == fruit.getX() * DIMENSION && snake.getY() == fruit.getY() * DIMENSION;
    }

    private boolean check_self_collision() {
        for(int i = 1; i < snake.getBody().size(); i++) {
            if(snake.getX() == snake.getBody().get(i).x &&
                    snake.getY() == snake.getBody().get(i).y) {
                return true;
            }
        }
        return false;
    }

    public Fruit getFruit() {
        return fruit;
    }
    public Snake getSnake() {
        return snake;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
