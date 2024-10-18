package behavioral.mediator;

public interface IMessageMediator {

    void sendMessage(String message, User user);

    void addUser(User user);
}
