import java.awt.*;
import java.util.Random;

import static sun.swing.SwingUtilities2.getFontMetrics;

public class Fruit {

    private int x;
    private int y;
    private Random random = new Random();

    public int getX() {return x;}
    public void setX(int x) {this.x = x;}
    public int getY() {return y;}
    public void setY(int y) {this.y = y;}

    public Fruit(){

        this.generateNewFruit();
    }
    public void generateNewFruit () {
//        x = random.nextInt(MainWindow.SCREEN_WIDTH * MainWindow.DIMENSION);
//        y = random.nextInt(MainWindow.SCREEN_HEIGHT * MainWindow.DIMENSION);
        this.x = random.nextInt(MainWindow.SCREEN_WIDTH);
        this.y = random.nextInt(MainWindow.SCREEN_HEIGHT);
    }


}