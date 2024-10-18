package behavioral.visitor;

public interface GameStoreItem {

    long accept(GameStoreVisitor visitor);
}
