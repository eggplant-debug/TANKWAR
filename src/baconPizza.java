public class baconPizza extends pizzaSystem{
    private int bacon;

    public int getBacon() {
        return bacon;
    }

    public void setBacon(int bacon) {
        this.bacon = bacon;
    }

    @Override
    public String show() {
        super.setName("培根披萨");
        return super.show()+"\n培根的克数是："+bacon;
    }
}
