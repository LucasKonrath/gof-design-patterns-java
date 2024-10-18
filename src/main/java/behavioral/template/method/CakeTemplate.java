package behavioral.template.method;

public abstract class CakeTemplate {

    public final void makeCake() {
        makeDough();
        heatInOven();
        addToppings();
        System.out.println("Cake completed! By the way, the cake is a lie.");
    }

    protected abstract void makeDough();

    protected void heatInOven(){
        //Default implementation.
        System.out.println("Heat In Oven at 300F");
    };

    protected abstract void addToppings();
}
