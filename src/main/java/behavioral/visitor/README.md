# Visitor Design Pattern

The Visitor pattern is a behavioral design pattern that separates an algorithm from the object structure it operates on. It allows you to add new operations to existing object structures without modifying those structures.

The pattern consists of the following components:

1. **Visitor**: An interface or abstract class that declares a visit operation for each type of ConcreteElement in the object structure.
2. **ConcreteVisitor**: Implements the Visitor interface and defines the behavior for each type of ConcreteElement.
3. **Element**: An interface or abstract class that declares an accept operation that takes a Visitor as an argument.
4. **ConcreteElement**: Implements the Element interface and provides an accept operation that takes a Visitor as an argument and calls the corresponding visit operation on the Visitor.

The key benefits of using the Visitor pattern include:

- Separating the algorithm from the object structure it operates on
- Adding new operations to existing object structures without modifying those structures
- Promoting code reuse by encapsulating operations in separate classes

## Java Code Example

```java
// Visitor interface
public interface GameStoreVisitor {

    int visit(BaseGame baseGame);
    int visit(DeluxePack deluxePack);

}

// Concrete Visitor
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

// Element interface
public interface GameStoreItem {
    long accept(GameStoreVisitor visitor);
}

// Concrete Element A
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

// Concrete Element B
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
```

### Test
```java
    @Test
    public void test(){
        List<GameStoreItem> items = new ArrayList<>();
        items.add(new BaseGame(0, "Deadlock"));
        items.add(new DeluxePack(50,
             "Warhammer 40k Space Marine Battle Pass", new BaseGame(40, "Warhammer 40K Space Marine 2")));

        GameStoreVisitor visitor = new GameStoreVisitorImpl();

        assertEquals(90L, items.stream()
                .mapToLong(item -> item.accept(visitor))
                .sum());

    }
```

Tests found [here](../../../../../src/test/java/behavioral/visitor)
