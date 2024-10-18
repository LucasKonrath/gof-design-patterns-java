package creational.factory.method;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FactoryMethodTests {

    @Test
    public void testFactoryMethod() {

        CarFactory amarokFactory = new VwAmarokCarFactory();
        Car amarok = amarokFactory.createCar();
        assertEquals("Volkswagen", amarok.make());
        assertEquals("Amarok", amarok.name());
        assertTrue(amarok instanceof VwAmarok);


        CarFactory jeepFactory = new JeepCompassCarFactory();
        Car jeep = jeepFactory.createCar();
        assertEquals("Jeep", jeep.make());
        assertEquals("Compass", jeep.name());
        assertTrue(jeep instanceof JeepCompass);
    }
}
