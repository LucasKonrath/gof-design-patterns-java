# Mediator Design Pattern

The Mediator pattern is a behavioral design pattern that defines an object that encapsulates how a set of objects interact. It promotes loose coupling by keeping objects from referring to each other explicitly, and it allows their interaction to be varied independently.

The pattern consists of the following components:

1. **Mediator**: An interface or abstract class that defines the contract for communication between Colleague objects.
2. **ConcreteMediator**: Implements the Mediator interface and coordinates the communication between Colleague objects.
3. **Colleague**: An interface or abstract class that defines the contract for communication with the Mediator.
4. **ConcreteColleague**: Implements the Colleague interface and communicates with the ConcreteMediator.

The key benefits of using the Mediator pattern include:

- Decoupling objects from each other, promoting loose coupling
- Simplifying object protocols by centralizing the communication logic in a single mediator
- Allowing for the introduction of new mediators without changing the original colleagues

## Java Code Example

```java
// Mediator interface
public interface IMessageMediator {

    void sendMessage(String message, User user);

    void addUser(User user);
}

// Concrete Mediator
public class IMessageMediatorImpl implements IMessageMediator {

    private List<User> users;

    public IMessageMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String msg, User user) {
        for(User u : users){
            if(u != user){
                u.receive(msg);
            }
        }
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}

// User abstract class
public abstract class User {

    protected IMessageMediator forumMediator;
    protected String name;
    protected List<String> receivedMessages = new ArrayList<>();

    public User(IMessageMediator forumMediator, String name) {
        this.forumMediator = forumMediator;
        this.name = name;
    }

    public IMessageMediator getForumMediator() {
        return forumMediator;
    }

    public void setForumMediator(IMessageMediator forumMediator) {
        this.forumMediator = forumMediator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getReceivedMessages() {
        return receivedMessages;
    }

    abstract void send(String message);

    abstract void receive(String message);
}

// Concrete User
public class UserImpl extends User {

    public UserImpl(IMessageMediator forumMediator, String name) {
        super(forumMediator, name);
    }

    @Override
    void send(String msg) {
        System.out.println("Adding message");
        forumMediator.sendMessage(msg, this);
    }

    @Override
    void receive(String message) {
        System.out.println("Receiving message for user " + this.getName());
        receivedMessages.add(message);
    }
}

```

### Test
```java
    @Test
    public void testMediator() {
        IMessageMediator forumMediator = new IMessageMediatorImpl();

        User user = new UserImpl(forumMediator, "First user");
        User user2 = new UserImpl(forumMediator, "Second user");
        User user3 = new UserImpl(forumMediator, "Third user");

        forumMediator.addUser(user);
        forumMediator.addUser(user2);
        forumMediator.addUser(user3);

        user.send("Sent message to all other users.");

        assertEquals(0, user.getReceivedMessages().size());
        assertEquals(1, user2.getReceivedMessages().size());
        assertEquals(1, user3.getReceivedMessages().size());
    }
```

Tests found [here](../../../../../src/test/java/behavioral/mediator)