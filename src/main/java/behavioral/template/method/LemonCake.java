package behavioral.template.method;

public class LemonCake extends CakeTemplate {

    @Override
    protected void makeDough() {
        System.out.println("Making dough with lemon");
    }

    @Override
    protected void addToppings() {
        System.out.println("No toppings!");
    }
}
