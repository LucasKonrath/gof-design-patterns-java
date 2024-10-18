# Creational GOF Design Patterns

The Creational Gang of Four (GOF) Design Patterns are a set of patterns that deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. Here's a summary of the five Creational GOF Design Patterns:

## 1. [Singleton](/src/main/java/creational/singleton/)

- Ensures a class has only one instance and provides a global point of access to it.
- Useful when exactly one object is needed to coordinate actions across the system.

## 2. [Factory Method](/src/main/java/creational/factory/method/)

- Defines an interface for creating an object, but lets subclasses decide which class to instantiate.
- Allows a class to defer instantiation to subclasses.

## 3. [Abstract Factory](/src/main/java/creational/abstractFactory/)

- Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
- Useful when a system should be independent of how its products are created, composed, and represented.

## 4. [Builder](/src/main/java/creational/builder/)

- Separates the construction of a complex object from its representation.
- Allows the same construction process to create different representations.

## 5. [Prototype](/src/main/java/creational/prototype/)

- Specifies the kinds of objects to create using a prototypical instance, and creates new objects by copying this prototype.
- Useful when the cost of creating an object is more expensive than copying an existing one.

These patterns address different scenarios:

- Singleton is used when you need to ensure that only one instance of a class exists.
- Factory Method is used when a class can't anticipate the type of objects it needs to create.
- Abstract Factory is used when you need to create families of related objects.
- Builder is used when you want to separate the construction of a complex object from its representation.
- Prototype is used when creating an object is more efficient by cloning an existing instance.

Each of these patterns provides a way to encapsulate object creation, making the system more flexible and less dependent on specific classes.
