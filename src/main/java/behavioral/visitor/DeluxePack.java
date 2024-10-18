package behavioral.visitor;

public class DeluxePack implements GameStoreItem {

    private int additionalPrice;
    private String name;
    private BaseGame baseGame;

    public DeluxePack(int additionalPrice, String name, BaseGame baseGame) {
        this.additionalPrice = additionalPrice;
        this.name = name;
        this.baseGame = baseGame;
    }

    public int getPrice() {
        return additionalPrice;
    }

    public String getName() {
        return name;
    }

    public BaseGame getBaseGame() {
        return baseGame;
    }

    @Override
    public long accept(GameStoreVisitor visitor) {
        return visitor.visit(this);
    }
}
