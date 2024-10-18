package behavioral.visitor;

public class BaseGame implements GameStoreItem {

    private int price;
    private String name;

    public BaseGame(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public long accept(GameStoreVisitor visitor) {
        return visitor.visit(this);
    }
}
