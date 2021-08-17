package TANK;

public class main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame  t = new TankFrame();

        int initTankCount =Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        //由错误
        for(int i=0;i<initTankCount;i++){
            t.enemys.add(new Tank(50+i*100,200,Dir.Down,t,Group.BAD));
        }


        while (true){
            /**
             * 线程睡眠时间，用于让敌人进行
             */
            //初始化地方坦克

            Thread.sleep(50);
            t.repaint();
        }

    }
}
  