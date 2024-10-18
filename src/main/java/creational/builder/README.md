# Builder Design Pattern (Simplified)

## Intent
The Builder pattern allows you to construct complex objects step by step. It's especially useful when an object needs to be created with many optional parameters.

## Implementation
```java
public class Smartphone {

    private final String make;
    private final String model;
    private final String color;
    private final int year;
    private final double price;

    @Override
    public int hashCode() {
        return Objects.hash(getMake(), getModel(), getColor(), getYear(), getPrice());
    }

    // Getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    private Smartphone(SmartphoneBuilder builder){
        this.make = builder.make;
        this.model = builder.model;
        this.color = builder.color;
        this.year = builder.year;
        this.price = builder.price;
    }

    public static class SmartphoneBuilder {

        private String make;
        private String model;
        private String color;
        private int year;
        private double price;

        public SmartphoneBuilder(){}

        public SmartphoneBuilder make(String make) {
            this.make = make;
            return this;
        }

        public SmartphoneBuilder model(String model) {
            this.model = model;
            return this;
        }

        public SmartphoneBuilder color(String color) {
            this.color = color;
            return this;
        }

        public SmartphoneBuilder year(int year) {
            this.year = year;
            return this;
        }

        public SmartphoneBuilder price(double price) {
            this.price = price;
            return this;
        }

        public Smartphone build() {
            return new Smartphone(this);
        }
    }
}
```

## Usage

```java
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
```


Tests found [here](../../../../../src/test/java/creational/builder)
