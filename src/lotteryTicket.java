import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;

public class lotteryTicket {

    public static void main(String[] args) {

        int [] choseball= new int[7];
        int count =0;
        while(true){
            System.out.println("------欢迎来到老黑的彩票系统---------");
            System.out.println("1.购买彩票");
            System.out.println("2.查看中奖结果");
            System.out.println("3.退出系统");
            Scanner sc= new Scanner(System.in);
            int choice= sc.nextInt();

            switch (choice){
                //选购彩票
                case 1:
                    System.out.println("请选择购买注数：");
                    count= sc.nextInt();
                    for (int i = 1; i <=7 ; i++) {
                        if(i!=7){
                            System.out.println("请选择"+i+"号红色球");
                            int redball=sc.nextInt();
                            choseball[i-1]=redball;
                        }
                        else {
                            System.out.println("请选择蓝色球");
                            int blueball=sc.nextInt();
                            choseball[6]=blueball;
                        }
                    }
                    break;
                // 查看彩票是否中奖以及是否开奖
                case 2:
                    /*
                    1.获取之前中奖信息
                    2.获取当前中奖号码
                    3.兑奖
                     */
                    int[] luckeynum=getLuckeyNum();
                    int level =confirmLuckey(choseball,luckeynum);
                    switch (level){
                        case 1:
                            System.out.println("恭喜您，已中奖，一等奖500万元");
                            System.out.println("您共计获得"+count*500+"万元");
                            break;
                        case 2:
                            System.out.println("恭喜您，已中奖，二等奖100万元");
                            System.out.println("您共计获得"+count*100+"万元");
                            break;
                        case 3:
                            System.out.println("恭喜您，已中奖，三等奖50万元");
                            System.out.println("您共计获得"+count*50+"万元");
                            break;
                        case 4:
                            System.out.println("恭喜您，已中奖，四等奖10万元");
                            System.out.println("您共计获得"+count*10+"万元");
                            break;
                        case 5:
                            System.out.println("恭喜您，已中奖，五等奖2万元");
                            System.out.println("您共计获得"+count*10+"万元");
                            break;
                        case 6:
                            System.out.println("恭喜您，已中奖，六等奖1万元");
                            System.out.println("您共计获得"+count*1+"万元");
                            break;
                        case 0:
                            System.out.println("很遗憾，您尚未中奖");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("您确定要退出系统吗？（Y/N）");
                    String choose=sc.next();
                    if(choose.equals("Y")){
                        return;
                    }
                    break;
            }
        }

    }
    public static int[] getLuckeyNum(){
        int [] luckeynum = new int[7];
        luckeynum= new int[]{1, 2, 3, 4, 5, 6, 7};
//        for (int i = 0; i <7 ; i++) {
//            if(i!=6){
//                luckeynum[i]=(int)(Math.random()*33)+1;
//            }
//            else{
//                luckeynum[6]=(int)(Math.random()*16)+1;
//            }
//        }

        return luckeynum;
    }

    public static int confirmLuckey(int [] yournum,int[] luckeynum){
        int RedchoseCount=0;
        int bluechoseCount=0;
        for (int i = 0; i < 7; i++) {
            if(i!=6){
                for (int j = 0; j < 6; j++) {
                    if(yournum[i]==luckeynum[j]){
                        RedchoseCount+=1;
                        break;
                    }


                }
            }
            else if (yournum[6]==luckeynum[6]){
                bluechoseCount+=1;
            }
            
        }
        if(RedchoseCount==6 && bluechoseCount==1){
            return 1;
        }
        else if(RedchoseCount==6){
            return 2;
        }
        else if(RedchoseCount==5 && bluechoseCount==1){
            return 3;
        }
        else if(RedchoseCount==5 || (RedchoseCount==4 && bluechoseCount==1)){
            return 4;
        }
        else if(RedchoseCount==4 || (RedchoseCount==4 &&bluechoseCount==1)){
            return 5;
        }
        else if(bluechoseCount==1){
            return 6;
        }
        return 0;
    }

}
