package structural.decorator;

import org.junit.Test;

public class DecoratorTest {

    @Test
    public void test() {
        Kart shifterKart = new ShifterKartDecorator(new BasicKart());

        Kart superKart = new SuperKartDecorator(new BasicKart());

        Kart superShifterKrazyKart = new ShifterKartDecorator(new SuperKartDecorator(new BasicKart()));

        shifterKart.assemble();
        superKart.assemble();
        superShifterKrazyKart.assemble();
    }
}
