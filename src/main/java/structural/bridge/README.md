# Bridge Design Pattern (Simplified)

## Intent
The Bridge pattern decouples an abstraction from its implementation so that the two can vary independently. It is especially useful when both the abstraction and its implementation need to be extensible by subclassing.

## Problem
How can an abstraction and its implementation be defined and extended independently?

## Solution
Separate the abstraction and its implementation into two separate class hierarchies. This way, both can be modified without affecting each other.

## Implementation

```java
// Implementor
public interface Step {
    void doStep();
}

// Concrete Implementor A
public class SeparateIngredients implements Step {
    @Override
    public void doStep() {
        System.out.println("Separated ingredients");
    }
}

// Concrete Implementor B
public class CookFood implements Step {
    @Override
    public void doStep() {
        System.out.print(" And cooked.");
    }
}

// Abstraction
public abstract class Food {
    protected Step stepOne;
    protected Step stepTwo;

    protected Food(Step stepOne, Step stepTwo) {
        this.stepOne = stepOne;
        this.stepTwo = stepTwo;
    }

    abstract public void makeFood();
}

// Refined Abstraction A
public class Burger extends Food {

    public Burger(Step stepOne, Step stepTwo) {
        super(stepOne, stepTwo);
    }

    @Override
    public void makeFood() {
        System.out.print("Burger");
        stepOne.doStep();
        stepTwo.doStep();
    }
}

// Refined Abstraction B
public class Pizza extends Food {

    public Pizza(Step stepOne, Step stepTwo) {
        super(stepOne, stepTwo);
    }

    @Override
    public void makeFood() {
        System.out.print("Pizza");
        stepOne.doStep();
        stepTwo.doStep();
    }
}
```

## Test

```java
    @Test
    public void test() {
        Food one = new Burger(new SeparateIngredients(), new CookFood());
        one.makeFood();
        Food two = new Pizza(new SeparateIngredients(), new CookFood());
        two.makeFood();
    }
```

## Advantages
1. Decouples interface from implementation.
2. Improves extensibility (you can extend the abstraction and implementation hierarchies independently).
3. Hides implementation details from clients.
4. Allows the separation of abstraction and implementation into different packages.

## Disadvantages
1. Increases overall code complexity.
2. Might be overkill for simple scenarios.

## Common Use Cases
1. When you want to avoid a permanent binding between an abstraction and its implementation.
2. When both the abstractions and their implementations should be extensible by subclassing.
3. When changes in the implementation of an abstraction should have no impact on clients.
4. When you have a proliferation of classes resulting from a coupled interface and numerous implementations.

## Considerations
- The Bridge pattern is often used in conjunction with the Abstract Factory pattern.
- It's similar to the Adapter pattern but the Bridge is designed up-front to let abstractions and implementations vary independently, while the Adapter is retrofitted to make unrelated classes work together.
- The pattern is particularly useful in graphics and windowing systems that need to run on multiple platforms.


Tests found [here](../../../../../src/test/java/structural/bridge)
