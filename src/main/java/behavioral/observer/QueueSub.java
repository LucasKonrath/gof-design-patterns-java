package behavioral.observer;

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
