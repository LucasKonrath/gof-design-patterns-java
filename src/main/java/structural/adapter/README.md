# Adapter Design Pattern

The **Adapter Pattern** (also known as the **Wrapper Pattern**) is a structural design pattern that allows incompatible interfaces to work together. It acts as a bridge between two objects by converting the interface of a class into another interface that a client expects.

## Purpose

The Adapter pattern is used when:
- You want to use an existing class, but its interface doesn't match the one you need.
- You want to create a reusable class that cooperates with unrelated or unforeseen classes with incompatible interfaces.

## Participants
1. **Target**: Defines the domain-specific interface that the client uses.
2. **Adapter**: Implements the target interface and adapts the Adaptee to the Target.
3. **Adaptee**: Defines an existing interface that needs adapting.
4. **Client**: Collaborates with objects that implement the Target interface.

## Example

Let's say we have an existing interface `iPhone`. It has a charge method.

```java
public interface iPhone {
    void charge();
}
```

We also have a `Charger` interface.

```java
public interface Charger {
    void charge();
}
```
We have a class called `iPhone16` as well. This has a USB-C type charger. Older iPhone chargers used the Lightning port.
In order to charge our iPhone16, we'll need an adapter that ports the LightningPortCharger to USB-C.

```java
public class iPhone16 implements iPhone {

    Charger lightningPortToUsbCAdapter;

    public iPhone16(Charger adapter) {
        this.lightningPortToUsbCAdapter = adapter;
    }

    @Override
    public void charge() {
        lightningPortToUsbCAdapter.charge();
    }
}

public class LightningPortCharger implements Charger {

    @Override
    public void charge() {
        System.out.println("Charging with Lightning");
    }
}

public class LightningPortToUsbCAdapter implements Charger {

    LightningPortCharger charger;

    LightningPortToUsbCAdapter() {
        charger = new LightningPortCharger();
    }

    @Override
    public void charge() {
        System.out.println("Charging with USB-C Adapter");
        charger.charge();
    }
}
```

### Test

```java
    @Test
    public void test() {
        iPhone16 iPhone16 = new iPhone16(new LightningPortToUsbCAdapter());
        iPhone16.charge();
    }
```
Output:
```
Charging with USB-C Adapter
Charging with Lightning
```

## Key Points
- The **Adapter** pattern helps integrate classes that could not otherwise work together due to incompatible interfaces.
- It provides a way to make unrelated, pre-existing classes work with a new or unified interface.
- It is frequently used in legacy systems


Tests found [here](../../../../../src/test/java/structural/adapter)
