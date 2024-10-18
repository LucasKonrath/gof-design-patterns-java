package structural.decorator;

public class ShifterKartDecorator extends KartDecorator {

    public ShifterKartDecorator(Kart kart) {
        super(kart);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.println("Adding Gears to kart because it's a shifter kart");
    }
}
