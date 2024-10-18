# Singleton Design Pattern

## Intent
The Singleton pattern ensures a class has only one instance and provides a global point of access to it.

## Problem
Sometimes it's important to have exactly one instance of a class. For example, in a system there should be only one file system or window manager. How do we ensure that a class has only one instance and that the instance is easily accessible?

## Solution
The Singleton pattern involves a single class which is responsible to create an object while making sure that only single object gets created. This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.

## Structure
![Singleton Structure](https://upload.wikimedia.org/wikipedia/commons/f/fb/Singleton_UML_class_diagram.svg)

## Key Components
1. **Singleton**: The class that implements the singleton pattern.
   - Has a private static instance of itself.
   - Has a private constructor to prevent direct construction.
   - Provides a public static method to get the instance.

## Implementation

### We can have some variations for the Singleton. Explored here are the eager singleton, the lazy singleton, the static singleton and a thread safe implementation.
```java
public class EagerSingleton {

   private static final EagerSingleton instance = new EagerSingleton();

   // Private constructor so no one can instantiate the singleton straight away.
   private EagerSingleton() {}

   public static EagerSingleton getInstance() {
      return instance;
   }

}

public class LazySingleton {

   private static LazySingleton instance;

   // Private constructor so no one can instantiate the singleton straight away.
   private LazySingleton() {}

   public static LazySingleton getInstance() {
      if (instance == null) {
         instance = new LazySingleton();
      }
      return instance;
   }

}

public class StaticSingleton {

   private static final StaticSingleton instance;

   // Private constructor so no one can instantiate the singleton straight away.
   private StaticSingleton() {}

   // This way we can catch and rethrow exceptions.
   static {
      try {
         instance = new StaticSingleton();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   public static StaticSingleton getInstance() {
      return instance;
   }

}

public class ThreadSafeSingleton {
   private static ThreadSafeSingleton instance;

   private ThreadSafeSingleton() {}

   public static synchronized ThreadSafeSingleton getInstance() {
      if(instance == null) {
         instance = new ThreadSafeSingleton();
      }

      return instance;
   }
}
```

## Test
```java
    @Test
    public void test() {
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();

        // Assert they're the same address.
        assertEquals(eagerSingleton, eagerSingleton2);
    }

   @Test
   public void test() {
      LazySingleton lazySingleton = LazySingleton.getInstance();
      LazySingleton lazySingleton2 = LazySingleton.getInstance();
   
      // Assert they're the same address.
      assertEquals(lazySingleton, lazySingleton2);
   }

   @Test
   public void test() {
      StaticSingleton staticSingleton = StaticSingleton.getInstance();
      StaticSingleton staticSingleton2 = StaticSingleton.getInstance();
   
      // Assert they're the same address.
      assertEquals(staticSingleton, staticSingleton2);
   }

   @Test
   public void test() {
      ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
      ThreadSafeSingleton threadSafeSingleton2 = ThreadSafeSingleton.getInstance();
   
      // Assert they're the same address.
      assertEquals(threadSafeSingleton, threadSafeSingleton2);
   }
```


Tests found [here](../../../../../src/test/java/creational/singleton)
