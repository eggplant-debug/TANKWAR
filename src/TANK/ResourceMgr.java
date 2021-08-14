package TANK;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public  static BufferedImage tankL,tankU,tankR,tankD;
    public  static BufferedImage BulletL,BulletU,BulletR,BulletD;

    public static  BufferedImage[] explodes =new BufferedImage[16];
    /**
     * 该类加载到内存后，static 语句块会立即执行，可以直接加载以下所有图片
     */
    static {
        try{
            tankU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/GoodTank1.png"));
            tankD= ImageUtil.rotateImage(tankU,180);
            tankL= ImageUtil.rotateImage(tankU,270);
            tankR= ImageUtil.rotateImage(tankU,90);






            /*
            子弹相关的图片
             */
            BulletL=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/bulletL.gif"));
            BulletR=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/bulletR.gif"));
            BulletD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/bulletD.gif"));
            BulletU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/bulletU.gif"));


            /*
            在explodes 中在增加一系列图片，表示爆炸的
             */
            for (int i = 0; i < explodes.length; i++) {
                explodes[i]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/e"+(i+1)+".gif"));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
