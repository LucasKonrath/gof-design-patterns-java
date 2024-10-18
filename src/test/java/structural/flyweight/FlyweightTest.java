package structural.flyweight;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.UUID;

import static org.junit.Assert.assertTrue;

public class FlyweightTest {

    @Test
    public void test() {
        SessionFactory sessionFactory = new SessionFactory();

        String id = UUID.randomUUID().toString();
        Instant then = Instant.now();
        for (int i = 0; i < 10000; i++) {
            Session session = sessionFactory.getSession(id);
            session.login();
        }
        Instant now = Instant.now();

        long flyweightDelta = Duration.between(then, now).toMillis();

        then = Instant.now();

        for (int i = 0; i < 10000; i++) {
            Session session = new SimpleSession(id);
            session.login();
        }

        now = Instant.now();

        long standardDelta = Duration.between(then, now).toMillis();

        System.out.printf("Flyweight Delta " + flyweightDelta + "ms\n");
        System.out.printf("Standard Delta " + standardDelta + "ms\n");

        assertTrue(flyweightDelta < standardDelta);
    }
}
