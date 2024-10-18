package creational.abstractFactory;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AbstractFactoryTest {

    @Test
    public void testAbstractFactory() {
        Console xbox = ConsoleFactory.createConsole(new XboxSeriesXFactory());
        Console ps5 = ConsoleFactory.createConsole(new PS5Factory());

        assertTrue(xbox instanceof XboxSeriesX);
        assertTrue(ps5 instanceof PS5);
    }
}
