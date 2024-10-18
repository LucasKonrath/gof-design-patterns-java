package structural.decorator;

public class BasicKart implements Kart {

    @Override
    public void assemble() {
        System.out.println("Standard Kart");
    }
}
