package TANK;

import java.awt.*;

public class Tank {
    private int x,y;
    private Dir dir =Dir.Down;
    private static  int  speed =10;
    private boolean move = false;
    private TankFrame tf;//对象中可以持有另一个对象的引用

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
        g.fillRect(x,y,60,60);
        if (!this.move){
            return;
        }
        move();

}

    /**
     * tankframe 中能画的子弹只有一颗，这样操作无法保证，子弹能传递到tankFrame
     *
     * 只有在tankFrame中才能画对象
     */
    public void fire() {
        // 子弹如何进行remove掉
        tf.bullets.add(new Bullet(this.x,this.y,this.dir,this.tf)) ;


    }

}
