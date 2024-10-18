package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

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
