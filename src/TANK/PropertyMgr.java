package TANK;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
    static Properties props =new Properties();

    private  PropertyMgr (){

    }

    /*
    单例设计模式(内部类实现)，最好的一种之一。
    由于内部实现类进行实现，不会有多余加载的问题
    通过enum 类来实现，可以解决反射来使用方法的问题，其防止了反序列化的情况

     */
    private  static class PropertyMgrHolder{
        private final static PropertyMgr INSTANCE= new PropertyMgr();
    }
    public static PropertyMgr getInstance(){
        return PropertyMgrHolder.INSTANCE;
    }

    static{
        try{
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    public static  Object get(String key){
        if(props == null) return null;
        return  props.get(key);
    }
}
