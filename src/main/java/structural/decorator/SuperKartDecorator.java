package structural.decorator;

public class SuperKartDecorator extends KartDecorator {

    public SuperKartDecorator(Kart kart) {
        super(kart);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.println("Adding 125cc to kart because it's a super kart");
    }
}
