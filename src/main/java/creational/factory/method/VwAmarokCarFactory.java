package creational.factory.method;

public class VwAmarokCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new VwAmarok();
    }
}
