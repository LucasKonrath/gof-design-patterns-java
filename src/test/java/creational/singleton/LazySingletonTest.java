package creational.singleton;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LazySingletonTest {

    @Test
    public void test() {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();

        // Assert they're the same address.
        assertEquals(lazySingleton, lazySingleton2);
    }
}
