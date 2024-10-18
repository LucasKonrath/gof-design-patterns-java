# Proxy Design Pattern (Simplified)

## Intent
The Proxy pattern provides a surrogate or placeholder for another object to control access to it.

## Problem
How can we control access to an object?

## Solution
Create a new proxy class with the same interface as an original service object. Then you can update your app so that it passes the proxy object to all of the original object's clients.

## Implementation

```java
public interface DatabaseConnection {
    void executeQuery(String query);
}

// Real Subject
public class DatabaseConnectionImpl implements DatabaseConnection {

    public DatabaseConnectionImpl() {
        setupInitialConnection();
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing query: " + query);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Query executed");
    }

    private void setupInitialConnection() {
        System.out.printf("Setting up database connection\n");
        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

// Proxy
public class DatabaseConnectionProxy implements DatabaseConnection {

    private static DatabaseConnection instance;

    @Override
    public void executeQuery(String query) {
        if (instance == null) {
            instance = new DatabaseConnectionImpl();
        }
        instance.executeQuery(query);
    }
}
```

## Test

```java
    @Test
    public void test() {
        Instant then = Instant.now();
        DatabaseConnectionProxy proxy = new DatabaseConnectionProxy();
        proxy.executeQuery("SELECT * FROM TEST");
        proxy.executeQuery("SELECT * FROM TEST");
        proxy.executeQuery("SELECT * FROM TEST");
        Instant now = Instant.now();
        long proxyDelta = Duration.between(then, now).toMillis();
    
        then = Instant.now();
        DatabaseConnectionImpl databaseConnection = new DatabaseConnectionImpl();
        databaseConnection.executeQuery("SELECT * FROM TEST");
        DatabaseConnectionImpl databaseConnection2 = new DatabaseConnectionImpl();
        databaseConnection2.executeQuery("SELECT * FROM TEST");
        DatabaseConnectionImpl databaseConnection3 = new DatabaseConnectionImpl();
        databaseConnection3.executeQuery("SELECT * FROM TEST");
        now = Instant.now();
    
        long noProxyDelta = Duration.between(then, now).toMillis();
    
        System.out.println("Proxy delta:" + proxyDelta + "ms no Proxy delta:" + noProxyDelta + "ms");
        assertTrue(proxyDelta < noProxyDelta);
    }
```

## Advantages
1. Controls access to the original object, allowing you to perform something either before or after the request gets through to the original object.
2. Can manage the lifecycle of the service object without clients knowing about it.
3. Works even if the service object isn't ready or is not available.
4. Introduces a new level of indirection which can be used for lazy loading, caching, logging, access control, etc.

## Disadvantages
1. The code may become more complicated since you need to introduce a lot of new classes.
2. The response from the service might get delayed.

## Common Use Cases
1. Lazy initialization (virtual proxy): When you have a heavyweight service object that wastes system resources by being always up.
2. Access control (protection proxy): When you want only specific clients to be able to use the service object.
3. Local execution of a remote service (remote proxy): When the service object is located on a remote server.
4. Logging requests (logging proxy): When you want to keep a history of requests to the service object.
5. Caching request results (caching proxy): When you need to cache results of client requests and manage the life cycle of this cache.

## Considerations
- The Proxy pattern is structurally similar to Decorator, but their intents are different.
- There are several variations of the Proxy pattern (as mentioned in Common Use Cases).
- Proxy works best when there's a well-defined interface for the Real Subject, as the Proxy must implement the same interface.
- Be cautious of creating "dumb" proxies that simply forward all requests to the Real Subject without adding any value.

Tests found [here](../../../../../src/test/java/structural/proxy)
