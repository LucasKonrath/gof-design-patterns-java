package creational.factory.method;

public class JeepCompassCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new JeepCompass();
    }
}
