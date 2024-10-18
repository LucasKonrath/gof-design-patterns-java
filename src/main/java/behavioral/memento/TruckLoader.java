package behavioral.memento;

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
