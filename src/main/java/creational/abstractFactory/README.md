# Abstract Factory Design Pattern (Simplified)

## Intent
The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.

## Implementation

```java
// Abstract Product A
public abstract class Console {

    public abstract String getName();
    public abstract double getPrice();
    public abstract int getReleaseYear();

    @Override
    public String toString() {
        return "Name= " + getName() + ", Price= " + getPrice() + ", ReleaseYear= " + getReleaseYear();
    }
}

// Concrete Product A1
public class PS5 extends Console {
    @Override
    public String getName() {
        return "Playstation 5";
    }

    @Override
    public double getPrice() {
        return 500;
    }

    @Override
    public int getReleaseYear() {
        return 2021;
    }
}

// Concrete Product A2
public class XboxSeriesX extends Console {
    @Override
    public String getName() {
        return "Xbox Series X";
    }

    @Override
    public double getPrice() {
        return 300;
    }

    @Override
    public int getReleaseYear() {
        return 2021;
    }
}

// Abstract Factory
public class ConsoleFactory {

    public static Console createConsole(ConsoleAbstractFactory consoleAbstractFactory) {
        return consoleAbstractFactory.createConsole();
    }
}

// Concrete Factory 1
public class PS5Factory implements ConsoleAbstractFactory {
    @Override
    public Console createConsole() {
        return new PS5();
    }
}

// Concrete Factory 2
public class XboxSeriesXFactory implements ConsoleAbstractFactory {
    @Override
    public Console createConsole() {
        return new XboxSeriesX();
    }
}
```

## Test
```java
    @Test
    public void testAbstractFactory() {
        Console xbox = ConsoleFactory.createConsole(new XboxSeriesXFactory());
        Console ps5 = ConsoleFactory.createConsole(new PS5Factory());

        assertTrue(xbox instanceof XboxSeriesX);
        assertTrue(ps5 instanceof PS5);
    }
```

Tests found [here](../../../../../src/test/java/creational/abstractFactory)