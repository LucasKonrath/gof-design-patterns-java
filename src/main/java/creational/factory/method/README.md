# Factory Method Design Pattern

## Intent
The Factory Method pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

## Problem
How can an object be created so that subclasses can redefine which class to instantiate?

## Solution
Define a separate operation (factory method) for creating an object. Create an object by calling a factory method.

## Structure
![Factory Method Structure](https://refactoring.guru/images/patterns/diagrams/factory-method/structure.png)

## Key Components
1. **Product**: Defines the interface of objects the factory method creates.
2. **ConcreteProduct**: Implements the Product interface.
3. **Creator**: Declares the factory method, which returns an object of type Product.
4. **ConcreteCreator**: Overrides the factory method to return an instance of a ConcreteProduct.

## Implementation
```java
public interface Car {
    String make();
    String name();
}

public class JeepCompass implements Car {

    @Override
    public String make() {
        return "Jeep";
    }

    @Override
    public String name() {
        return "Compass";
    }
}

public class VwAmarok implements Car {
    @Override
    public String make() {
        return "Volkswagen";
    }

    @Override
    public String name() {
        return "Amarok";
    }
}

public interface CarFactory {
    Car createCar();
}

public class JeepCompassCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new JeepCompass();
    }
}

public class VwAmarokCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new VwAmarok();
    }
}
```

## Test
```java
    @Test
    public void testFactoryMethod() {

        CarFactory amarokFactory = new VwAmarokCarFactory();
        Car amarok = amarokFactory.createCar();
        assertEquals("Volkswagen", amarok.make());
        assertEquals("Amarok", amarok.name());
        assertTrue(amarok instanceof VwAmarok);


        CarFactory jeepFactory = new JeepCompassCarFactory();
        Car jeep = jeepFactory.createCar();
        assertEquals("Jeep", jeep.make());
        assertEquals("Compass", jeep.name());
        assertTrue(jeep instanceof JeepCompass);
    }
```

Tests found [here](../../../../../src/test/java/creational/factory/method)
