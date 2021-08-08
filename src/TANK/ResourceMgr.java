package TANK;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public  static BufferedImage tankL,tankU,tankR,tankD;

    /**
     * 该类加载到内存后，static 语句块会立即执行，可以直接加载以下所有图片
     */
    static {
        try{
            tankL= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/tankL.gif"));
            tankD= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/tankD.gif"));
            tankU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/tankU.gif"));
            tankR= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/tankR.gif"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
