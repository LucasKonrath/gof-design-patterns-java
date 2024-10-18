package creational.builder;

import java.util.Objects;

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
