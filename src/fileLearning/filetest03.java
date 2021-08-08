package fileLearning;

import java.io.*;

public class filetest03 {
    public static void main(String[] args) throws IOException {
        /*
        1.有一个源文件

        2.有一个目标文件
        3.搞一个输入的管 怼到源文件上
        4.搞一个输出的管 怼到目标文件上

         */
        //1.源文件
        File f  = new File("d:/Test.txt");
        //2.目标文件
        File t = new File("d:/demo.txt");
        //3.搞一个输入的管 怼到源文件上·
        FileReader fr = new FileReader(f);
        //4.输出管
        FileWriter fw =new FileWriter(t);
//        System.in
        int len = fr.read();
        System.out.println(len);
        while(len!=-1){
            //字符读取
            System.out.println(len);
            fw.write(len);
            len=fr.read();
        }

        fw.close();
        fr.close();

    }
}
