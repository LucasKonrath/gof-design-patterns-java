package behavioral.template.method;

public class ChocolateCake extends CakeTemplate {

    @Override
    protected void makeDough() {
        System.out.println("Making dough with chocolate chips");
    }

    @Override
    protected void addToppings() {
        System.out.println("Adding ganache!");
    }
}
