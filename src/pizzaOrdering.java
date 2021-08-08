import java.awt.*;
import java.util.Scanner;

public class pizzaOrdering {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("请选择想要制作的披萨：1.水果披萨 2.培根披萨");
        int choice=sc.nextInt();
        if(choice==1){
            FruitPizza f= new FruitPizza();
            System.out.println("请选择要添加的水果： ");
            String fruit=sc.next();
            f.setFruit(fruit);
            System.out.println("请选择匹萨的大小: ");
            int size =sc.nextInt();
            f.setSize(size);
            System.out.println("请选择匹萨的价格");
            int prize= sc.nextInt();
            f.setPrice(prize);
            String result=f.show();
            System.out.println(result);
        }
        else if(choice==2){
            baconPizza b =new baconPizza();
            System.out.println("请选择要添加的水果： ");
            int bacon =sc.nextInt();
            b.setBacon(bacon);
            System.out.println("请选择匹萨的大小: ");
            int size =sc.nextInt();
            b.setSize(size);
            System.out.println("请选择匹萨的价格");
            int prize= sc.nextInt();
            b.setPrice(prize);
            String result=b.show();
            System.out.println(result);
        }
        else{
            System.out.println("对不起，没有该种选项的披萨");
        }
    }
}
