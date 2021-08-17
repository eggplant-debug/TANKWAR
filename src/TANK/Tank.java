package TANK;

import java.awt.*;
import java.util.Random;

public class Tank {
    private int x;
    private int y;
    public Dir dir =Dir.Down;
    private static  int  speed =10;
    private boolean move = true;
    public TankFrame tf;//对象中可以持有另一个对象的引用
    public static int width=ResourceMgr.GoodtankD.getWidth();
    public static int height=ResourceMgr.GoodtankD.getHeight();
    private boolean living = true;
    private Random random = new Random();
    private  Rectangle rectangle = new Rectangle();
    public Group group=Group.BAD;


    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }




    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }



    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public Tank(int x, int y, Dir dir,TankFrame tf,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
        this.group = group;
        rectangle.x = this.x;
        rectangle.y =this.y;
        rectangle.height=Tank.height;
        rectangle.width =Tank.width;
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

        }
        if(this.group == Group.BAD && random.nextInt(100)>95) this.fire(DefaultFireStrategy.getInstance());
        if(this.group == Group.BAD && random.nextInt(10)>7)
            randomDir();

        boundsCheck();
        rectangle.x = this.x;
        rectangle.y =this.y;
    }

    private void boundsCheck() {
        if(this.x<0) x=0;
        if (this.y<30) y=30;
        if(this.x>TankFrame.Game_Width-Tank.width-2) x=TankFrame.Game_Width-Tank.width;
        if(this.y>TankFrame.Game_Height-Tank.height-2)y =TankFrame.Game_Height-Tank.height;
    }

    private void randomDir() {

        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void paint(Graphics g){
        if(!living){
            this.tf.enemys.remove(this);
            return;
        }

        switch (this.dir){
            case Down:
                // 正常判断 ，我会写if else了，可以学习一下这里的高明写法
                g.drawImage(this.group == Group.GOOD? ResourceMgr.GoodtankD: ResourceMgr.BadtankD ,x,y,null);
                break;
            case Left:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.GoodtankL: ResourceMgr.BadtankL ,x,y,null);
                break;
            case Up:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.GoodtankU: ResourceMgr.BadtankU ,x,y,null);
                break;
            case Right:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.GoodtankR: ResourceMgr.BadtankR ,x,y,null);
                break;


        }

        move();

}

    /**
     * tankframe 中能画的子弹只有一颗，这样操作无法保证，子弹能传递到tankFrame
     *
     * 只有在tankFrame中才能画对象
     */

    /**
     * 通过策略模式实现fire 后，要考虑如何传参的问题，
     * 1. 通过参数将strategy传入
     *          缺点：需要先new 一个FireStrategy 才能传
     *          优点：限制属性的作用域范围
     *          能用传参数就用传参数
     * 2. 通过成员变量的方式，
     */
    public void fire(FireStrategy fireStrategy) {
        fireStrategy.fire(this);

    }

    public void die() {
        this.living=false;
    }
}
