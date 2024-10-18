package structural.adapter;

public class LightningPortCharger implements Charger {

    @Override
    public void charge() {
        System.out.println("Charging with Lightning");
    }
}
