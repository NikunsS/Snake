import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;
import javax.swing.*;
public class MainWindow implements KeyListener {

    static final int SCREEN_WIDTH = 50;
    static final int SCREEN_HEIGHT = 50;
    static final int DIMENSION = 15;

    private Graphics g;
    private  JFrame mainFrame;
    private JButton startButton;
    private Fruit fruit;
    private Snake snake;
    private Graphics graphics;

    public MainWindow() throws InterruptedException {
        mainFrame = new JFrame();
        snake = new Snake();
        fruit = new Fruit();
//        graphics = new Graphics(this);
        WindowInit(mainFrame);
    }



    public void WindowInit(JFrame mainFrame) throws InterruptedException {
        mainFrame.setTitle("Snake");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(SCREEN_WIDTH*DIMENSION, SCREEN_HEIGHT*DIMENSION);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        graphics = new Graphics(this);
        mainFrame.getContentPane().setBackground(Color.BLACK);
        mainFrame.add(graphics);

        Thread.sleep(100);
          startButton = new JButton("Start");
//        startButton.setBounds((SCREEN_HEIGHT*DIMENSION-100)/2,(SCREEN_HEIGHT*DIMENSION-200)/2,100,200);
          startButton.addActionListener(e -> GameStart());
        mainFrame.add(startButton);

        
    }


    private void GameStart() {
        startButton.setVisible(false);
        graphics.state = "RUNNING";
        }


    public void update() {
        if(Objects.equals(graphics.state, "RUNNING")) {
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
        int keyCode = e.getKeyCode();

        if(graphics.state == "RUNNING") {
            if(keyCode == KeyEvent.VK_UP && snake.getMove() != "DOWN") {
                snake.up();
            }

            if(keyCode == KeyEvent.VK_DOWN && snake.getMove() != "UP") {
                snake.down();
            }

            if(keyCode == KeyEvent.VK_LEFT && snake.getMove() != "RIGHT") {
                snake.left();
            }

            if(keyCode == KeyEvent.VK_RIGHT && snake.getMove() != "LEFT") {
                snake.right();
            }
        }
        else {
            this.GameStart();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
