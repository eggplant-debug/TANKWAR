package TANK;

public class main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame  t = new TankFrame();
        while (true){
            /**
             * 线程睡眠时间，用于让敌人进行
             */
            Thread.sleep(50);
            t.repaint();
        }

    }
}
  