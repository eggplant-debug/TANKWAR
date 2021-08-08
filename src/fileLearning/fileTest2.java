package fileLearning;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class fileTest2 {
    public static void main(String[] args) throws IOException {
        //程序——）目标位置
        //1、创建一个file对象
        File f = new File("d:/Test.txt");
        //2、创建一个filewriter流的对象
        FileWriter fw = new FileWriter(f,true);

        //3、写入动作
        char[] s = new char[5];
        String  a ="HelloWorld";
        fw.write(a);
//        for (int i = 0; i <a.length() ; i++) {
//            fw.write(a.charAt(i));
//
//        }
        //4、关闭流的对象
        fw.close();


    }
}
