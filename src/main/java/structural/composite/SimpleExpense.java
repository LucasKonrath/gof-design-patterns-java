package structural.composite;

public class SimpleExpense implements Expense {

    private int amount;
    private String description;

    SimpleExpense(int cost, String description) {
        this.amount = cost;
        this.description = description;
    }
    @Override
    public int getCost() {
        return amount;
    }
}
