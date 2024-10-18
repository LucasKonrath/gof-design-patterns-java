package behavioral.visitor;

public interface GameStoreVisitor {

    int visit(BaseGame baseGame);
    int visit(DeluxePack deluxePack);

}
