package creational.singleton;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreadSafeSingletonTest {

    @Test
    public void test() {
        ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton threadSafeSingleton2 = ThreadSafeSingleton.getInstance();

        // Assert they're the same address.
        assertEquals(threadSafeSingleton, threadSafeSingleton2);
    }
}
