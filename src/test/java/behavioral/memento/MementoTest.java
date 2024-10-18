package behavioral.memento;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MementoTest {

    @Test
    public void testMemento() {
        TruckLoader truckLoader = new TruckLoader(new Truck(0));
        truckLoader.load(10);
        truckLoader.load(20);
        truckLoader.hitSave();

        assertEquals(30, truckLoader.getCargo());

        truckLoader.load(70);
        assertEquals(100, truckLoader.getCargo());

        truckLoader.hitUndo();

        assertEquals(30, truckLoader.getCargo());
    }
}
