package TANK;

import java.awt.*;

//** 子弹类
public class Bullet {
    private int speed=10;
    private int x,y;
    private Dir Dir;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    private Group group=Group.BAD;
    /**
     * 如何正确获取子弹的长度和宽度
     */
    public static int width=ResourceMgr.BulletD.getWidth();
    public static int height=ResourceMgr.BulletD.getHeight();
    private TankFrame tf;
    private boolean living =true;

    public Bullet(int x, int y, TANK.Dir dir,TankFrame tf,Group group) {
        this.x = x;
        this.y = y;
        Dir = dir;
        this.tf=tf;
        this.group=group;

    }

    public void paint(Graphics g){
        if (!living){
            tf.bullets.remove(this);
            return;
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

        }


        if (x<0||y<0||x>TankFrame.Game_Width||y>TankFrame.Game_Height){
            this.living =false;
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


    public void collideWith(Tank tank){

        //TODO:用一个rect来记录当前位置，此时每次都需要用一个new一个rect出来。
        Rectangle rect =new Rectangle(this.x,this.y,width,height);
        Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),Tank.width,Tank.height);
        if(rect.intersects(rect2) && tank.getGroup()!=this.group){
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.living=false;
    }
}
