package TANK;

import java.awt.*;

public class Tank {
    private int x,y;
    private Dir dir =Dir.Down;
    private static  int  speed =10;
    private boolean move = false;
    private TankFrame tf;//对象中可以持有另一个对象的引用
    public static int width=ResourceMgr.tankD.getWidth();
    public static int height=ResourceMgr.tankD.getHeight();


    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public Tank(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void move(){
        if (!this.move){
            return;
        }
        switch (dir){
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
    public void paint(Graphics g){
        switch (this.dir){
            case Down:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
            case Left:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case Up:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case Right:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;


        }

        move();

}

    /**
     * tankframe 中能画的子弹只有一颗，这样操作无法保证，子弹能传递到tankFrame
     *
     * 只有在tankFrame中才能画对象
     */
    public void fire() {
        // 计算子弹的 位置
        int bx =this.x + Tank.width/2 -Bullet.width/2;
        int by =this.x + Tank.height/2 -Bullet.height/2;

        // 子弹如何进行remove掉
        tf.bullets.add(new Bullet(bx,by,this.dir,this.tf)) ;


    }

}
