# Flyweight Design Pattern (Simplified)

## Intent
The Flyweight pattern is used to minimize memory usage or computational expenses by sharing as much as possible with similar objects.

## Problem
How can a large number of similar objects be supported efficiently?

## Solution
Separate the intrinsic state that can be shared and the extrinsic state that can vary, and create a Flyweight for the intrinsic state.

## Implementation

```java
import java.util.HashMap;
import java.util.Map;

// Flyweight
public interface Session {
    void login();
}

// Flyweight Factory
public class SessionFactory {
    private final Map<String, Session> sessions = new HashMap<>();

    public Session getSession(String sessionId) {
        return sessions.computeIfAbsent(sessionId, SimpleSession::new);
    }
}

// Client
public class SimpleSession implements Session {
    public String sessionId;

    public SimpleSession(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public void login() {
        System.out.print("Logged in as " + sessionId);
    }
}
```

## Test

```java
    @Test
    public void test() {
        SessionFactory sessionFactory = new SessionFactory();
    
        String id = UUID.randomUUID().toString();
        Instant then = Instant.now();
        for (int i = 0; i < 10000; i++) {
            Session session = sessionFactory.getSession(id);
            session.login();
        }
        Instant now = Instant.now();
    
        long flyweightDelta = Duration.between(then, now).toMillis();
    
        then = Instant.now();
    
        for (int i = 0; i < 10000; i++) {
            Session session = new SimpleSession(id);
            session.login();
        }
    
        now = Instant.now();
    
        long standardDelta = Duration.between(then, now).toMillis();
    
        System.out.printf("Flyweight Delta " + flyweightDelta + "ms\n");
        System.out.printf("Standard Delta " + standardDelta + "ms\n");
    
        assertTrue(flyweightDelta < standardDelta);
    }
```

## Advantages
1. Reduces memory usage when dealing with a large number of similar objects.
2. Improves performance in applications where object creation is heavy.
3. Provides a way to share data between multiple objects.

## Disadvantages
1. Can complicate the code due to the introduction of the Factory.
2. Might introduce a runtime cost for transferring, finding, and/or computing extrinsic state.

## Common Use Cases
1. When an application needs to spawn a huge number of similar objects.
2. When objects take up a lot of memory and can have their state separated into intrinsic and extrinsic parts.
3. Text formatting and word processing applications.
4. Game development for sharing graphical representations of objects.
5. Caching and data compression.

## Real-World Analogy
Think of a library. Instead of each person owning a copy of each book, the library keeps one copy that can be shared among many readers. The book is the flyweight (intrinsic state), while the reader and checkout date would be the extrinsic state.

## Considerations
- The Flyweight pattern is often used in conjunction with the Composite pattern to implement shared leaf nodes.
- It's crucial to clearly define which state is intrinsic and which is extrinsic.
- The pattern is particularly useful in situations where memory is at a premium, such as in mobile or embedded systems.
- Be aware that the pattern can introduce complexity in terms of separating intrinsic and extrinsic state, which might not be worth it for small-scale applications.
- Consider using weak references if you want the Flyweight Factory to allow garbage collection of unused flyweights.

Tests found [here](../../../../../src/test/java/structural/flyweight)
