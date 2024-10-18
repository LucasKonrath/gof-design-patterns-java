package creational.builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuilderTest {

    @Test
    public void test() {
        // Does not compile. Must use builder.
        //Smartphone smartphone = new Smartphone();
        Smartphone smartphone = new Smartphone.SmartphoneBuilder()
                .make("Apple")
                .model("iPhone 16")
                .price(900.0)
                .color("Titanium Blue")
                .year(2024)
                .build();

        assertEquals("Apple", smartphone.getMake());
        assertEquals("iPhone 16", smartphone.getModel());
        assertEquals(900.0, smartphone.getPrice(), 0.0);
        assertEquals("Titanium Blue", smartphone.getColor());
        assertEquals(2024, smartphone.getYear());

    }
}
