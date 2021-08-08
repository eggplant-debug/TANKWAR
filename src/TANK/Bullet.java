package TANK;

import java.awt.*;

//** 子弹类
public class Bullet {
    private int speed=10;
    private int x,y;
    private Dir Dir;
    /**
     * 如何正确获取子弹的长度和宽度
     */
    public static int width=ResourceMgr.BulletD.getWidth();
    public static int height=ResourceMgr.BulletD.getHeight();
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
        switch (this.Dir){
            case Down:
                g.drawImage(ResourceMgr.BulletD,x,y,null);
                break;
            case Left:
                g.drawImage(ResourceMgr.BulletL,x,y,null);
                break;
            case Up:
                g.drawImage(ResourceMgr.BulletU,x,y,null);
                break;
            case Right:
                g.drawImage(ResourceMgr.BulletR,x,y,null);
                break;

        }
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
