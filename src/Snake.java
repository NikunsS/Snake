import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<Rectangle> body;
    private String move; //NOTHING, UP, LEFT, RIGHT, DOWN

    public Snake() {
        body = new ArrayList<>();

        Rectangle temp = new Rectangle(MainWindow.DIMENSION, MainWindow.DIMENSION);
        temp.setLocation(MainWindow.SCREEN_WIDTH / 2 * MainWindow.DIMENSION, MainWindow.SCREEN_HEIGHT / 2 * MainWindow.DIMENSION);
        body.add(temp);

        temp = new Rectangle(MainWindow.DIMENSION, MainWindow.DIMENSION);
        temp.setLocation((MainWindow.SCREEN_WIDTH / 2 - 1) * MainWindow.DIMENSION, (MainWindow.SCREEN_HEIGHT / 2) * MainWindow.DIMENSION);
        body.add(temp);

        temp = new Rectangle(MainWindow.DIMENSION, MainWindow.DIMENSION);
        temp.setLocation((MainWindow.SCREEN_WIDTH / 2 - 2) * MainWindow.DIMENSION, (MainWindow.SCREEN_HEIGHT / 2) * MainWindow.DIMENSION);
        body.add(temp);

        move = "NOTHING";
    }

    public List<Rectangle> getBody() {
        return body;
    }

    public void setBody(ArrayList<Rectangle> body) {
        this.body = body;
    }

    public int getX() {
        return body.get(0).x;
    }

    public int getY() {
        return body.get(0).y ;
    }

    public String getMove() {
        return move;
    }

    public void up() {
        move = "UP";
    }
    public void down() {
        move = "DOWN";
    }
    public void left() {
        move = "LEFT";
    }
    public void right() {
        move = "RIGHT";
    }

    public void move() {
        Rectangle head = body.get(0);
        Rectangle temp = new Rectangle(MainWindow.DIMENSION, MainWindow.DIMENSION);

        if(move == "UP") {
            temp.setLocation(head.x, head.y - MainWindow.DIMENSION);
        }
        else if(move == "DOWN") {
            temp.setLocation(head.x, head.y + MainWindow.DIMENSION);
        }
        else if(move == "LEFT") {
            temp.setLocation(head.x - MainWindow.DIMENSION, head.y);
        }
        else{
            temp.setLocation(head.x + MainWindow.DIMENSION, head.y);
        }

        body.add(0, temp);
    }

    public void grow(){

    }


}
