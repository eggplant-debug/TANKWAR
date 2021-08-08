import java.util.Scanner;

/*
披萨制作，面向对象效果

 */
public class pizzaSystem {
    private String name;
    private int price;
    private int size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public String show(){
        return "匹萨的名字是: "+name+"\n匹萨的价格是： "+price+"\n匹萨的尺寸是： "+size;
    }
    public pizzaSystem(){

    }


    public pizzaSystem(String name, int price, int size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }
}

