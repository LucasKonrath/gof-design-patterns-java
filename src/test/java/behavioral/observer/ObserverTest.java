package behavioral.observer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ObserverTest {

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
}
