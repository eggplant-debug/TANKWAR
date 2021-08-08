public class FruitPizza extends pizzaSystem {
    private String fruit;
    //由于是水果匹萨，所以父类名字要重写为水果披萨
    //这一点未处理好，使用父类方法，直接设置name

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    @Override
    public String show() {
        super.setName("水果披萨");
        return super.show() + "\n配料水果: " + fruit;

    }
}
