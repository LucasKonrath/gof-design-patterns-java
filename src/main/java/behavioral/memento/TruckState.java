package behavioral.memento;

public class TruckState {

    private int cargo;

    public TruckState(int cargo) {
        this.cargo = cargo;
    }

    public int getCargo() {
        return cargo;
    }
}
