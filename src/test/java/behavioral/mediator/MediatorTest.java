package behavioral.mediator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MediatorTest {

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
}
