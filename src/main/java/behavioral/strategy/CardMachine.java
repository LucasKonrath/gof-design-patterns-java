package behavioral.strategy;

public class CardMachine {
    void transact(int amount, CardStrategy cardStrategy) {
        cardStrategy.transact(amount);
    }
}
