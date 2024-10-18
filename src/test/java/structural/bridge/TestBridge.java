package structural.bridge;

import org.junit.Test;
import structural.bridge.abstractions.Burger;
import structural.bridge.abstractions.Food;
import structural.bridge.abstractions.Pizza;
import structural.bridge.implementors.CookFood;
import structural.bridge.implementors.SeparateIngredients;

public class TestBridge {

    @Test
    public void test() {
        Food one = new Burger(new SeparateIngredients(), new CookFood());
        one.makeFood();
        Food two = new Pizza(new SeparateIngredients(), new CookFood());
        two.makeFood();
    }
}
