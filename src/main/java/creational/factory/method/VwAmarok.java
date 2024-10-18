package creational.factory.method;

public class VwAmarok implements Car {
    @Override
    public String make() {
        return "Volkswagen";
    }

    @Override
    public String name() {
        return "Amarok";
    }
}
