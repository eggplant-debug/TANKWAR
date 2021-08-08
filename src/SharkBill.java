import java.util.Scanner;

public class SharkBill {
    public static void main(String[] args) {
        String detail = "";
        int balance = 0;
        while (true) {

            System.out.println("--------欢迎使用系统---------");
            System.out.println("1.收支明细\n" +
                    "2.登记收入\n" +
                    "3.登记支出\n" +
                    "4.退出");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                System.out.println("输入的参数有误，请再次输入：");
                int newchoice = sc.nextInt();
                choice = newchoice;
            }
            switch (choice) {
                //收支明细
                case 1:
                    if(detail.length()!=0){
                        detail.substring(0,detail.length()-1);
                        System.out.print(detail);
                    }


                    break;
                //登记收入
                case 2:
                    System.out.println("请输入您的收入明细");
                    String tip = sc.next();
                    System.out.println("请输入您的收入：");
                    int count = sc.nextInt();
                    balance += count;
                    detail = detail + "收入：" + count + "  来源：" + tip+" 剩余 "+balance+"\n";
                    break;
                case 3:
                    System.out.println("请输入您的支出明细");
                    String tips = sc.next();
                    System.out.println("请输入您的收入：");
                    int cost_count = sc.nextInt();
                    balance -= cost_count;
                    detail=detail+"支出："+cost_count+" 用途："+ tips+" 剩余 "+balance+"\n";
                    // 字符串拼接 可以直接拼接数字

                    break;
                case 4:
                    System.out.println("记账系统》》退出功能");
                    System.out.println("确认要退出吗");
                    String isExit =sc.next();
                    switch ( isExit){
                        case "Y":
                            System.out.println("系统退出，欢迎您下次继续使用！ ：");
                            return  ;
                    }

            }

        }
    }
}
