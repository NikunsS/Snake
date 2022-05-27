import java.awt.*;
import java.util.Random;

import static sun.swing.SwingUtilities2.getFontMetrics;

public class Fruit {

    private int x;
    private int y;
    private Random random;

    public int getX() {return x;}
    public void setX(int x) {this.x = x;}
    public int getY() {return y;}
    public void setY(int y) {this.y = y;}

    public Fruit(){
        x = -1;
        y = -1;
    }
    public void generate () {
        x = random.nextInt(GameWindow.SCREEN_WIDTH * GameWindow.DIMENSION);
        y = random.nextInt(GameWindow.SCREEN_HEIGHT * GameWindow.DIMENSION);
    }

    public void DrawFruit(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, GameWindow.DIMENSION, GameWindow.DIMENSION);
    }
}