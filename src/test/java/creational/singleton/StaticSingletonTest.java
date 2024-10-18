package creational.singleton;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StaticSingletonTest {

    @Test
    public void test() {
        StaticSingleton staticSingleton = StaticSingleton.getInstance();
        StaticSingleton staticSingleton2 = StaticSingleton.getInstance();

        // Assert they're the same address.
        assertEquals(staticSingleton, staticSingleton2);
    }
}
