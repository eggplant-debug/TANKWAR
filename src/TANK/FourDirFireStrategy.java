package TANK;

public class FourDirFireStrategy implements FireStrategy{

    private void FourDirFireStrategy(){

    }
    private static class innerFourDirFireStrategy{
        private static FourDirFireStrategy INSTANCE =new FourDirFireStrategy();
    }
    public static FourDirFireStrategy GetInstance(){
        return innerFourDirFireStrategy.INSTANCE;
    }




    @Override
    public void fire(Tank tank) {
        int bx =tank.getX() + Tank.width/2 -Bullet.width/2;
        int by =tank.getY() + Tank.height/2 -Bullet.height/2;

        Dir[] dirs= Dir.values();
        for (Dir dir : dirs) {
            new Bullet(bx,by,dir, tank.tf, tank.group);
        }

        /**
         * 以下的tf 需要获取到，该如何办呢？
         * 1.直接强行获取通过tank,实现tf的get,set方法
         * 2.不用在fire时添加子弹，可以直接在new bullet的时候，在tf的bullets中直接添加
         */

    }
}
