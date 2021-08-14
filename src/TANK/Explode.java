package TANK;

import java.awt.*;

/**
 * 增加 爆炸 放置在 坦克中
 * 敌人坦克随机动，随机发射子弹，做边界检测
 */
public class Explode {
    public static  int WIDTH =ResourceMgr.explodes[0].getWidth();
    public static  int HEIGHT=ResourceMgr.explodes[0].getHeight();

    private  int x,y;
    private  boolean living =true;

    TankFrame tf = null;

    private  int step =0;

    public Explode(int x,int y,TankFrame tf){
        this.x = x;
        this.y =y ;
        this.tf = tf;
    }

    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if(step>=ResourceMgr.explodes.length){
            tf.explodes.remove(this);
        }
        /*
        画完后，需要从list中去除
         */

    }
}
