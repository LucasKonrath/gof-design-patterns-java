# Structural GOF Design Patterns

Structural patterns deal with object composition, creating relationships between objects to form larger structures. Here's a summary of the seven Structural GOF Design Patterns:

## 1. [Adapter](/src/main/java/structural/adapter/)

- Converts the interface of a class into another interface clients expect.
- Allows classes to work together that couldn't otherwise because of incompatible interfaces.

## 2. [Bridge](/src/main/java/structural/bridge/)

- Separates an abstraction from its implementation so that the two can vary independently.
- Useful when both the abstraction and its implementation need to be extensible by subclassing.

## 3. [Composite](/src/main/java/structural/composite/)

- Composes objects into tree structures to represent part-whole hierarchies.
- Lets clients treat individual objects and compositions of objects uniformly.

## 4. [Decorator](/src/main/java/structural/decorator/)

- Attaches additional responsibilities to an object dynamically.
- Provides a flexible alternative to subclassing for extending functionality.

## 5. [Facade](/src/main/java/structural/facade/)

- Provides a unified interface to a set of interfaces in a subsystem.
- Defines a higher-level interface that makes the subsystem easier to use.

## 6. [Flyweight](/src/main/java/structural/flyweight/)

- Uses sharing to support large numbers of fine-grained objects efficiently.
- Useful when a program needs a huge number of objects that have some shared state.

## 7. [Proxy](/src/main/java/structural/proxy/)

- Provides a surrogate or placeholder for another object to control access to it.
- Can be used for lazy loading, access control, logging, etc.

These patterns address different structural challenges:

- Adapter is used to make existing classes work with others without modifying their source code.
- Bridge is used to separate abstraction from implementation, allowing them to vary independently.
- Composite is used to treat individual objects and compositions uniformly.
- Decorator is used to add responsibilities to objects dynamically without affecting other objects.
- Facade is used to provide a simplified interface to a complex subsystem.
- Flyweight is used to reduce the cost of creating and manipulating a large number of similar objects.
- Proxy is used to provide a placeholder for another object to control access to it.

Each of these patterns provides a way to organize objects and classes into larger structures, while keeping these structures flexible and efficient.
