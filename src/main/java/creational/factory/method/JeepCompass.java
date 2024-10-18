package creational.factory.method;

public class JeepCompass implements Car {

    @Override
    public String make() {
        return "Jeep";
    }

    @Override
    public String name() {
        return "Compass";
    }
}
