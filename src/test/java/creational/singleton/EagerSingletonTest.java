package creational.singleton;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EagerSingletonTest {

    @Test
    public void test() {
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();

        // Assert they're the same address.
        assertEquals(eagerSingleton, eagerSingleton2);
    }
}
