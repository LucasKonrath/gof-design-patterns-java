package behavioral.strategy;

public class CreditCardStrategy implements CardStrategy {
    @Override
    public void transact(int amount) {
        System.out.println("Paid " + amount + " with credit");
    }
}
