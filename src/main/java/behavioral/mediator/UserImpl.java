package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

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
