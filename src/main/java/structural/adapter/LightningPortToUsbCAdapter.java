package structural.adapter;

public class LightningPortToUsbCAdapter implements Charger {

    LightningPortCharger charger;

    LightningPortToUsbCAdapter() {
        charger = new LightningPortCharger();
    }

    @Override
    public void charge() {
        System.out.println("Charging with USB-C Adapter");
        charger.charge();
    }
}
