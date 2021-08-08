package TANK;

import java.awt.*;

//** 子弹类
public class Bullet {
    private int speed=10;
    private int x,y;
    private Dir Dir;
    private int width=30;
    private int height=30;


    public Bullet(int x, int y, TANK.Dir dir) {
        this.x = x;
        this.y = y;
        Dir = dir;

    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,width,height);

        move();
    }
    public void move(){
        switch (Dir){
            case Left:
                x-=speed;
                break;
            case Up:
                y-=speed;
                break;
            case Right:
                x+=speed;
                break;
            case Down:
                y+=speed;
                break;

            default:
                break;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public TANK.Dir getDir() {
        return Dir;
    }

    public void setDir(TANK.Dir dir) {
        Dir = dir;
    }
}
