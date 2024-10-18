package behavioral.strategy;

public class DebitCardStrategy implements CardStrategy {
    @Override
    public void transact(int amount) {
        System.out.println("Paid " + amount + " with debit");
    }
}
