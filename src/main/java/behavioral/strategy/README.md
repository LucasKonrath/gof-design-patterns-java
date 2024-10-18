# Strategy Design Pattern

The Strategy pattern is a behavioral design pattern that defines a family of algorithms, encapsulates each one, and makes them interchangeable. It allows the algorithm to vary independently from clients that use it.

The pattern consists of the following components:

1. **Strategy**: An interface or abstract class that declares the operation(s) that concrete strategies must implement.
2. **ConcreteStrategy**: Implements the algorithm defined by the Strategy interface.
3. **Context**: Maintains a reference to a Strategy object and provides an interface for executing the strategy.

The key benefits of using the Strategy pattern include:

- Separating algorithms from the client code that uses them
- Allowing for easy switching between different algorithms at runtime
- Promoting code reuse by encapsulating algorithms in separate classes
- Adhering to the Open/Closed Principle (OCP) by allowing new strategies to be added without modifying existing code

## Java Code Example

```java
// Strategy interface
public interface CardStrategy {
    void transact(int amount);
}

// Concrete Strategy 1 (Credit Card)
public class CreditCardStrategy implements CardStrategy {
    @Override
    public void transact(int amount) {
        System.out.println("Paid " + amount + " with credit");
    }
}

// Concrete Strategy 2 (Debit Card)
public class DebitCardStrategy implements CardStrategy {
    @Override
    public void transact(int amount) {
        System.out.println("Paid " + amount + " with debit");
    }
}

// Context
public class CardMachine {
    void transact(int amount, CardStrategy cardStrategy) {
        cardStrategy.transact(amount);
    }
}
```
### Test
```java
    @Test
    public void test() {
        CardMachine cardMachine = new CardMachine();
        cardMachine.transact(10, new CreditCardStrategy());
        cardMachine.transact(10, new DebitCardStrategy());
    }
```
### Output:
```
Paid 10 with credit
Paid 10 with debit
```

The Strategy pattern promotes code reuse, adheres to the Open/Closed Principle, and allows for easy switching between different algorithms at runtime based on the requirements or context of the application.


Tests found [here](../../../../../src/test/java/behavioral/strategy)