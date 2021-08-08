package fileLearning;

import sun.font.TrueTypeFont;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class fileTest {
    public static void main(String[] args) throws IOException {
        //文件--》程序：
        //1.创建一个File类的对象
        File f = new File("d:\\Test.txt");
        //2.创建一个FileReader的流的对象
        FileReader fr = new FileReader(f);
        //3.读取动作
        //引入一个“快递员的小车”，这个“小车”一次拉5个快递：
        char[] ch = new char[5];//缓冲数组
        int len = fr.read(ch);//一次读取五个:返回值是这个数组中 的有效长度
        while(true){
            System.out.println(len);
            //错误方式：
//            for (int i = 0 ;i < ch.length;i++){
//                System.out.println(ch[i]);
//            }
//            //正确方式：
//            for (int i = 0 ;i < len;i++){
//                System.out.println(ch[i]);
//            }
            //正确方式2：将数组转为String：
            String str = new String(ch,0,len);
            System.out.print(str);
            len = fr.read(ch);//相当于一次读5个字符到流中
            if(len<-1){
                break;
            }
        }
        //4.关闭流
        fr.close();
    }
}
