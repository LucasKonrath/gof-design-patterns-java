package creational.prototype;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrototypeTest {

    @Test
    public void testPrototype() {
        Fruit prototype = new Grape("Cabernet");

        FruitClient fruitClient = new FruitClient(prototype);

        Fruit cabernet = fruitClient.createFruit();

        assertEquals("Squeezing Cabernet grapes to get juice", cabernet.getJuice());
    }
}
