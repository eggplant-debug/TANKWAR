package TANK;

import java.awt.*;

//** 子弹类
public class Bullet {
    private int speed=10;
    private int x,y;
    private Dir Dir;
    private int width=30;
    private int height=30;
    private TankFrame tf;
    private boolean live=true;

    public Bullet(int x, int y, TANK.Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        Dir = dir;
        this.tf=tf;

    }

    public void paint(Graphics g){
        if (!live){
            tf.bullets.remove(this);
        }

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

        if (x<0||y<0||x>TankFrame.Game_Width||y>TankFrame.Game_Height){
            this.live=false;
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
