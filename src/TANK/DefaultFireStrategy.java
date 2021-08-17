package TANK;

public class DefaultFireStrategy implements FireStrategy{
    /*
    考虑改写为静态内部类来实现
     */
    private void DefaultFireStrategy(){

    }

    private static class InnerDefaultFireStrategy{
        private final static DefaultFireStrategy INSTANCE= new DefaultFireStrategy();
    }

    public static DefaultFireStrategy getInstance(){
        return InnerDefaultFireStrategy.INSTANCE;
    }


    @Override
    public void fire(Tank tank) {
        int bx =tank.getX() + Tank.width/2 -Bullet.width/2;
        int by =tank.getY() + Tank.height/2 -Bullet.height/2;

        /**
         * 以下的tf 需要获取到，该如何办呢？
         * 1.直接强行获取通过tank,实现tf的get,set方法
         * 2.不用在fire时添加子弹，可以直接在new bullet的时候，在tf的bullets中直接添加
         */
       new Bullet(bx,by,tank.dir,tank.tf,tank.group) ;
        System.out.println(String.format("子弹的初始坐标是（%d,%d)", bx,by));
        System.out.println(String.format("坦克当前的坐标是（%d,%d）",tank.getX(),tank.getY()));
    }
}
