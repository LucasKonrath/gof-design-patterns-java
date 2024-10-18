# State Design Pattern

The State pattern is a behavioral design pattern that allows an object to alter its behavior when its internal state changes. The object appears to change its class when its state changes.

The pattern consists of the following components:

1. **Context**: Defines the interface of interest to clients and maintains an instance of a ConcreteState subclass that represents the current state of the Context.
2. **State**: An interface or abstract class that defines the methods that all Concrete States should implement.
3. **ConcreteState**: Implements the State interface and defines the behavior associated with a particular state of the Context.

The key benefits of using the State pattern include:

- Separating state-specific behavior from the Context class, making it easier to add new states or modify existing ones
- Eliminating complex conditional statements in the Context class
- Allowing the Context to change its behavior at runtime based on its internal state

## Java Code Example

```java
// State interface
public interface State {
    boolean doAction();
}

// Concrete State 1
public class AcOnState implements State {
    @Override
    public boolean doAction() {
        System.out.println("AC turned on");
        return true;
    }
}

// Concrete State 2
public class AcOffState implements State {
    @Override
    public boolean doAction() {
        System.out.println("AC turned off");
        return false;
    }
}

// Context
public class AcContext implements State {

    private State acState;

    public void setAcState(State acState) {
        this.acState = acState;
    }

    public State getAcState() {
        return acState;
    }


    @Override
    public boolean doAction() {
        return acState.doAction();
    }
}
```
### Test
```java
    @Test
    public void test() {
        AcContext acContext = new AcContext();

        State acOnState = new AcOnState();
        State acOffState = new AcOffState();

        acContext.setAcState(acOffState);
        assertFalse(acContext.doAction());

        acContext.setAcState(acOnState);
        assertTrue(acContext.doAction());
    }
```

In this example, we have a `State` interface that defines the `doAction` method. The `AcOn` and `AcOff` classes implement this interface and define the behavior associated with their respective states.

The `AcContext` class maintains an instance of the current state and provides methods to set the state and handle requests based on the current state.

By using the State pattern, the behavior of the `AcContext` class changes based on its internal state. The state-specific behavior is encapsulated in separate state classes, making it easier to add new states or modify existing ones without modifying the `AcContext` class itself.

The State pattern is useful when an object's behavior depends on its state, and the state needs to be represented as a separate object. It helps to eliminate complex conditional statements in the `AcContext` class and promotes better code organization and maintainability.

Tests found [here](../../../../../src/test/java/behavioral/state)