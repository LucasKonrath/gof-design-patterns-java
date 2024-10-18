# Observer Design Pattern

The Observer pattern is a behavioral design pattern that defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

The pattern consists of the following components:

1. **Subject**: An interface or abstract class that defines the methods for attaching, detaching, and notifying observers.
2. **ConcreteSubject**: Implements the Subject interface and maintains a list of observers. It also provides an interface for changing its state and notifying the observers.
3. **Observer**: An interface or abstract class that defines the method for receiving notifications from the subject.
4. **ConcreteObserver**: Implements the Observer interface and maintains a reference to the ConcreteSubject. It also implements the update logic based on the state of the subject.

The key benefits of using the Observer pattern include:

- Decoupling the subject and observer objects, promoting loose coupling
- Allowing for the dynamic addition or removal of observers at runtime
- Providing a way to propagate changes in an object's state to its dependents automatically

## Java Code Example

```java
// Subject interface
public class Topic {

    private String message;

    private List<Sub> subscriptions = new ArrayList<>();

    public void addSubscription(Sub subscription){
        this.subscriptions.add(subscription);
    }

    public void removeSubscription(Sub subscription){
        this.subscriptions.remove(subscription);
    }

    public void setMessage(String message){
        this.message = message;
        for(Sub subscription : subscriptions){
            subscription.receive(message);
        }
    }
}

// Interface Subject
public interface Sub {
    void receive(String message);
}

// Concrete Subject
public class QueueSub implements Sub {

    private String message;

    @Override
    public void receive(String message) {
        this.setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

```

### Test
```java
    @Test
    public void test() {
        Topic topic = new Topic();
        QueueSub sub_1 = new QueueSub();
        QueueSub sub_2 = new QueueSub();

        topic.setMessage("First message");

        assertNull(sub_2.getMessage());
        assertNull(sub_1.getMessage());

        topic.addSubscription(sub_1);
        topic.addSubscription(sub_2);

        topic.setMessage("Second message");
        assertEquals("Second message", sub_1.getMessage());
        assertEquals("Second message", sub_2.getMessage());
    }
```
By using the Observer pattern, the subject and observers are decoupled, allowing for dynamic addition or removal of observers at runtime. The subject doesn't need to know the specific observers or how they update themselves; it simply notifies them when its state changes.


Tests found [here](../../../../../src/test/java/behavioral/observer)