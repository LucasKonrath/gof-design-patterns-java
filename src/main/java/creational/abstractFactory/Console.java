package creational.abstractFactory;

public abstract class Console {

    public abstract String getName();
    public abstract double getPrice();
    public abstract int getReleaseYear();

    @Override
    public String toString() {
        return "Name= " + getName() + ", Price= " + getPrice() + ", ReleaseYear= " + getReleaseYear();
    }
}
