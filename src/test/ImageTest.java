package test;

import org.junit.Test;
import sun.awt.image.BufferedImageDevice;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class ImageTest {

    @Test
    public void test(){
        try{
            BufferedImage image = ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\forMsb\\src\\img\\4.gif"));
            assertNotNull(image);

            //使用了 classLoader 的方法， 每个类都有一个classLoader
            // this.getClass  等同于 Image.class
            BufferedImage images = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("img/4.gif"));
            assertNotNull(images);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
