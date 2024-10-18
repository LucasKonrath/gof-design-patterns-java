package creational.abstractFactory;

public class XboxSeriesX extends Console {
    @Override
    public String getName() {
        return "Xbox Series X";
    }

    @Override
    public double getPrice() {
        return 300;
    }

    @Override
    public int getReleaseYear() {
        return 2021;
    }
}
