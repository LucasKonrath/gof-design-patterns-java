package structural.decorator;

abstract class KartDecorator implements Kart {

    private Kart kart;

    public KartDecorator(Kart kart) {
        this.kart = kart;
    }

    @Override
    public void assemble() {
        this.kart.assemble();
    }
}
