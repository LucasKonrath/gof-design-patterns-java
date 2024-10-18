package creational.abstractFactory;

public class PS5 extends Console {
    @Override
    public String getName() {
        return "Playstation 5";
    }

    @Override
    public double getPrice() {
        return 500;
    }

    @Override
    public int getReleaseYear() {
        return 2021;
    }
}
