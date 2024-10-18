package creational.prototype;

public class FruitClient {

    private final Fruit prototype;

    public FruitClient(Fruit prototype) {
        this.prototype = prototype;
    }

    public Fruit createFruit() {
        return prototype.clone();
    }
}
