package TANK;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


//**  用双缓冲解决闪烁问题
public class TankFrame extends Frame {
    //此处将this 传入，表征这个TankFrame 实例化自己的引用，这样可以在
    // tank 内部进行其访问
    Tank mytank =new Tank(200,200,Dir.Down,this,Group.GOOD);
    List<Bullet> bullets=new ArrayList<>();
    List<Tank> enemys=new ArrayList<>();
    Explode explode =new Explode(100,100,this);
    static final int Game_Width=800,Game_Height=600;



    public TankFrame(){
        setSize(Game_Width,Game_Height);
        setResizable(true);
        setTitle("tankbattle");
        setVisible(true);


        this.addKeyListener(new MykeyListener());

        /*
        匿名内部类，
        什么时候使用，当该内部类只被该类调用时，才可使用
         */
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        }
    Image offScreenImage =null;
    @Override
    public void update(Graphics g){
        if (offScreenImage== null){
            offScreenImage=this.createImage(Game_Width,Game_Height);

        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c =gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,Game_Width,Game_Height);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }


    /*
    每次重新调出窗口，均会重新绘制一次窗口
     */
    @Override
    public void paint(Graphics g) {
        Color c =g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量是:"+bullets.size(),10,60);
        g.setColor(c);
        mytank.paint(g);
        //使用迭代器进行删除操作，容易出现ConcurrentModificationException
      /*  for (Bullet bullet : bullets) {
            bullet.paint(g);
        }*/



        /**
         * 使用迭代器遍历，进行删除问题，容易有CocurrentModificationException
         *
         */
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        for (int i = 0; i < enemys.size(); i++) {
            enemys.get(i).paint(g);
        }

        for (int i = 0; i < bullets.size(); i++) {
            for (int i1 = 0; i1 < enemys.size(); i1++) {
                bullets.get(i).collideWith(enemys.get(i1));
            }
        }
        explode.paint(g);

    }
//        x+=100;
//        y+=100;
        /**
         * 可以查看gui 章节，有相关细节
         */
        /**
         * git 相关操作，用于提交项目
         */
    class MykeyListener extends KeyAdapter{

        boolean bl = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;
        /*
        用于表征是否发出一颗子弹
         */
        boolean bb = false;


        @Override
        public void keyPressed(KeyEvent e) {
            int key =e.getKeyCode();
            //这样写有一个问题，无法斜着走
            switch (key){
                case KeyEvent.VK_DOWN:
                    bD =true;
                    break;
                case KeyEvent.VK_UP:
                    bU=true;
                    break;
                case KeyEvent.VK_LEFT:
                    bl=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=true;
                    break;
                case KeyEvent.CTRL_MASK:
                    bb=true;
                default:
                    break;
            }

            setMainDir();
            repaint();
            /**
             * 如何调用 paint 方法重新绘制窗口，paint 中的 参数是系统参数，无法由程序员直接给出
             */


        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key =e.getKeyCode();
            switch (key){
                case KeyEvent.VK_DOWN:
                    bD =false;
                    break;
                case KeyEvent.VK_UP:
                    bU=false;
                    break;
                case KeyEvent.VK_LEFT:
                    bl=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=false;
                    break;
                case KeyEvent.VK_CONTROL:
                    mytank.fire();
                default:
                    break;
            }
            setMainDir();

        }

        private void setMainDir(){
            if(!bl && !bR && !bD && !bU){
                mytank.setMove(false);
            }
            else{
                mytank.setMove(true);
                /*
                子弹如何进行处理，打出一颗子弹，new出一颗来
                 */


                // 原先为何会一直走，这里没有对false逻辑进行处理
                if(bl) mytank.setDir(Dir.Left);
                if(bR) mytank.setDir(Dir.Right);
                if(bD) mytank.setDir(Dir.Down);
                if(bU) mytank.setDir(Dir.Up);
            }



        }
    }


}


