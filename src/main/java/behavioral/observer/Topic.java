package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

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
