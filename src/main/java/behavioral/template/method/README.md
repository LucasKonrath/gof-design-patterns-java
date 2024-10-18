# Template Method Design Pattern

The Template Method pattern is a behavioral design pattern that defines the skeleton of an algorithm in a base class, deferring some steps to subclasses. It allows subclasses to redefine certain steps of an algorithm without changing the algorithm's structure.

The pattern consists of the following components:

1. **AbstractClass**: Defines the template method that contains the skeleton of the algorithm. It also defines concrete methods that implement the invariant steps of the algorithm.
2. **ConcreteClass**: Implements the abstract methods defined in the AbstractClass, providing the specific implementation for the steps that can vary.

The key benefits of using the Template Method pattern include:

- Promoting code reuse by defining the invariant parts of an algorithm in a base class
- Allowing subclasses to override specific steps of the algorithm without changing the overall structure
- Adhering to the Hollywood Principle ("Don't call us, we'll call you") by inverting the control flow between the base class and subclasses

## Java Code Example

```java
// Abstract Class
public abstract class CakeTemplate {

    public final void makeCake() {
        makeDough();
        heatInOven();
        addToppings();
        System.out.println("Cake completed! By the way, the cake is a lie.");
    }

    protected abstract void makeDough();

    protected void heatInOven(){
        //Default implementation.
        System.out.println("Heat In Oven at 300F");
    };

    protected abstract void addToppings();
}

// Concrete Class 1
public class ChocolateCake extends CakeTemplate {

    @Override
    protected void makeDough() {
        System.out.println("Making dough with chocolate chips");
    }

    @Override
    protected void addToppings() {
        System.out.println("Adding ganache!");
    }
}

// Concrete Class 2
public class LemonCake extends CakeTemplate {

    @Override
    protected void makeDough() {
        System.out.println("Making dough with lemon");
    }

    @Override
    protected void addToppings() {
        System.out.println("No toppings!");
    }
}
```
### Test
```java
    @Test
    public void test() {
        CakeTemplate cake = new ChocolateCake();
        cake.makeCake();

        CakeTemplate cake2 = new LemonCake();
        cake2.makeCake();
    }
```
### Output
```
Making dough with chocolate chips
Heat In Oven at 300F
Adding ganache!
Cake completed! By the way, the cake is a lie.

Making dough with lemon
Heat In Oven at 300F
No toppings!
Cake completed! By the way, the cake is a lie.
```

By using the Template Method pattern, the overall structure of the algorithm (baking a cake) is defined in the `CakeTemplate` class, while the specific steps (`makeDough()`, `heatInOven()`, and `addToppings()`) are implemented by the concrete subclasses. This promotes code reuse by encapsulating the invariant parts of the algorithm in the base class and allows subclasses to customize the variable steps without changing the overall structure.

The Template Method pattern adheres to the Hollywood Principle ("Don't call us, we'll call you") by inverting the control flow between the base class and subclasses. The base class (`CakeTemplate`) controls the execution flow by calling the abstract methods implemented by the subclasses (`ChocolateCake` and `LemonCake`).


Tests found [here](../../../../../src/test/java/behavioral/template/method)