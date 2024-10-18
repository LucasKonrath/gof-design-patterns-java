package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
