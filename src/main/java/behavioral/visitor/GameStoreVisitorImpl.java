package behavioral.visitor;

public class GameStoreVisitorImpl implements GameStoreVisitor {
    @Override
    public int visit(BaseGame baseGame) {
        return baseGame.getPrice();
    }

    @Override
    public int visit(DeluxePack deluxePack) {
        return deluxePack.getPrice() + deluxePack.getBaseGame().getPrice();
    }
}
