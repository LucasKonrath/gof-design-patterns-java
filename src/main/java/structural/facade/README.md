# Facade Design Pattern (Simplified)

## Intent
The Facade pattern provides a unified interface to a set of interfaces in a subsystem. It defines a higher-level interface that makes the subsystem easier to use.

## Problem
How can a complex subsystem be simplified and made easier to use?

## Solution
Define a Facade object that provides a single, simplified interface to the more general facilities of a subsystem.

## Implementation

```java
// Complex subsystem classes
public abstract class Key {
    void press() {
        System.out.println(getKey());
    };

    abstract String getKey();
}

public class AKey extends Key {
    @Override
    String getKey() {
        return "A";
    }
}

// BKey, DownKey, LeftKey, RightKey, StartKey... etc

// Facade
public class KonamiCodeFacade {

    private Key up = new UpKey();

    private Key down = new DownKey();

    private Key left = new LeftKey();

    private Key right = new RightKey();

    private Key b = new BKey();

    private Key a = new AKey();

    private Key start = new StartKey();

    public void konamiCode(){
        Stream.of(up, up, down, down, left, right, left, right, b, a, start)
                .forEach(Key::press);
    }
}
```

## Test

```java
    @Test
    public void test() {
        KonamiCodeFacade facade = new KonamiCodeFacade();
        facade.konamiCode();
    }
```
## Output:
```
^
^
↓
↓
<
>
<
>
B
A
Start
```

## Advantages
1. Simplifies the interface to a complex subsystem.
2. Decouples the client from the subsystem.
3. Promotes weak coupling between the subsystem and its clients.
4. Provides a context-specific interface to a more general facility.

## Disadvantages
1. Can become a "god object" coupled to all classes of an app.
2. May introduce an additional layer of indirection, impacting performance.

## Common Use Cases
1. When you need to provide a simple interface to a complex subsystem.
2. When there are many dependencies between clients and the implementation classes of an abstraction.
3. When you want to layer your subsystems.
4. In libraries and frameworks to make them easier to use and understand.

## Considerations
- The Facade pattern is often used in conjunction with other patterns like Abstract Factory and Singleton.
- While Facade aims to simplify, be cautious not to over-simplify. Sometimes, clients may need more fine-grained control over the subsystem.
- Facades don't forbid direct access to the subsystem. You can still provide access to lower-level interfaces for clients that need it.
- Multiple facades can be created for different use cases of the same subsystem.

Tests found [here](../../../../../src/test/java/structural/facade)
