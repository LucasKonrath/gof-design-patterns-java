package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Bill implements Expense {

    private String description;
    private List<Expense> expenses;

    public Bill(String description) {
        this.description = description;
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void removeExpense(Expense expense) {
        expenses.remove(expense);
    }

    @Override
    public int getCost() {
        return expenses.stream().mapToInt(Expense::getCost).sum();
    }
}
