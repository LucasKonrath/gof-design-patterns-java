# Memento Design Pattern

The Memento pattern is a behavioral design pattern that provides a way to capture and restore the internal state of an object without violating encapsulation. It allows an object to be restored to its previous state without exposing its implementation details.

The pattern consists of the following components:

1. **Originator**: The object whose state needs to be saved and restored.
2. **Memento**: An object that stores the internal state of the Originator.
3. **Caretaker**: An object that is responsible for storing and restoring the Memento objects.

The key benefits of using the Memento pattern include:

- Preserving the encapsulation of the Originator by separating the state storage from the Originator
- Simplifying the Originator by delegating the state storage and restoration to the Memento and Caretaker
- Allowing the Originator to restore its previous state without violating its encapsulation

## Java Code Example

```java
// Memento
public class TruckState {

    private int cargo;

    public TruckState(int cargo) {
        this.cargo = cargo;
    }

    public int getCargo() {
        return cargo;
    }
}

// Originator
public class Truck {

    TruckState state;

    int cargo = 0;

    public Truck(int cargo) {
        this.cargo = cargo;
    }

    public int getCargo() {
        return cargo;
    }

    public void addCargo(int cargo) {
        this.cargo += cargo;
    }

    public TruckState save(){
        return new TruckState(this.cargo);
    }

    public void restore(TruckState truckState){
        this.cargo = truckState.getCargo();
    }
}

// Caretaker
public class TruckLoader {

    private Truck truck;
    private TruckState truckState;

    public TruckLoader(Truck truck){
        this.truck = truck;
    }

    public void load(int cargo){
        truck.addCargo(cargo);
    }

    public void hitSave(){
        truckState = truck.save();
    }

    public void hitUndo(){
        truck.restore(truckState);
    }

    public int getCargo(){
        return truck.getCargo();
    }
}
```

### Test
```java
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
```

Tests found [here](../../../../../src/test/java/behavioral/memento)