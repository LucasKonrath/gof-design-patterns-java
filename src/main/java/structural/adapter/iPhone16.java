package structural.adapter;

public class iPhone16 implements iPhone {

    Charger lightningPortToUsbCAdapter;

    public iPhone16(Charger adapter) {
        this.lightningPortToUsbCAdapter = adapter;
    }

    @Override
    public void charge() {
        lightningPortToUsbCAdapter.charge();
    }
}
