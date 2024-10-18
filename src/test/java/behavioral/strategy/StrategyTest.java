package behavioral.strategy;

import org.junit.Test;

public class StrategyTest {

    @Test
    public void test() {
        CardMachine cardMachine = new CardMachine();
        cardMachine.transact(10, new CreditCardStrategy());
        cardMachine.transact(10, new DebitCardStrategy());
    }
}
