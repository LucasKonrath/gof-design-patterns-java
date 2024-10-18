package creational.prototype;

public class Grape implements Fruit {

    private String type;

    public Grape(String type) {
        this.type = type;
    }

    @Override
    public Fruit clone() {
        return new Grape(this.type);
    }

    @Override
    public String getJuice() {
        return "Squeezing " + this.type + " grapes to get juice";
    }
}
