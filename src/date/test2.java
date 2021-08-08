package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test2 {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String--->Date
        try {
            Date d = df.parse("2019-4-6 12:23:54");
            System.out.println(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //Date--->String
        String format = df.format(new Date());
        System.out.println(format);
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.toGMTString());
        System.out.println(date.toLocaleString());
    }
}
