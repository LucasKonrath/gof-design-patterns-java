package behavioral.memento;

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
