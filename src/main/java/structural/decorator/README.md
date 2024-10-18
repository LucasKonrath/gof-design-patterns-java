# Decorator Design Pattern (Simplified)

## Intent
The Decorator pattern allows behavior to be added to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class.

## Problem
How can responsibilities be added to an object dynamically without affecting other objects?

## Solution
Wrap the original object inside an abstract decorator class that implements the same interface and forwards requests to the wrapped object.

## Implementation

```java
// Component Interface
public interface Kart {
    void assemble();
}

// Concrete Component
public class BasicKart implements Kart {

    @Override
    public void assemble() {
        System.out.println("Standard Kart");
    }
}

// Decorator
public abstract class KartDecorator implements Kart {

    private Kart kart;

    public KartDecorator(Kart kart) {
        this.kart = kart;
    }

    @Override
    public void assemble() {
        this.kart.assemble();
    }
}

// Concrete Decorators
public class SuperKartDecorator extends KartDecorator {

    public SuperKartDecorator(Kart kart) {
        super(kart);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.println("Adding 125cc to kart because it's a super kart");
    }
}

public class ShifterKartDecorator extends KartDecorator {

    public ShifterKartDecorator(Kart kart) {
        super(kart);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.println("Adding Gears to kart because it's a shifter kart");
    }
}

```

## Test

```java
    @Test
    public void test() {
        Kart shifterKart = new ShifterKartDecorator(new BasicKart());
    
        Kart superKart = new SuperKartDecorator(new BasicKart());
    
        Kart superShifterKrazyKart = new ShifterKartDecorator(new SuperKartDecorator(new BasicKart()));
    
        shifterKart.assemble();
        superKart.assemble();
        superShifterKrazyKart.assemble();
    }
```

Output:
```
Standard Kart
Adding Gears to kart because it's a shifter kart
Standard Kart
Adding 125cc to kart because it's a super kart
Standard Kart
Adding 125cc to kart because it's a super kart
Adding Gears to kart because it's a shifter kart
```

## Advantages
1. Provides a flexible alternative to subclassing for extending functionality.
2. Allows for dynamic addition or removal of responsibilities.
3. Follows Single Responsibility Principle: each decorator is responsible for only one feature.
4. Follows Open/Closed Principle: existing code doesn't need modification to add new decorators.

## Disadvantages
1. Can result in many small objects in the design, and overuse can be complex.
2. Can be difficult to implement a decorator in such a way that its behavior doesn't depend on the order in which decorators are added.

## Common Use Cases
1. Adding responsibilities to objects dynamically without affecting other objects.
2. When extension by subclassing is impractical.
3. When you want to be able to assign extra behaviors to objects at runtime.
4. GUI toolkits use decorators to add scrollbars, borders, etc. to widgets.
5. In middleware systems for adding functionalities like logging, encryption, etc.

## Considerations
- Be cautious of decorators that add too much functionality, as they can lead to complex interfaces.
- The Decorator pattern is often used in conjunction with other patterns like Factory and Builder.
- Consider using the Decorator pattern when you have a lot of distinct extensions that can be composed to create even more possibilities.

Tests found [here](../../../../../src/test/java/structural/decorator)
