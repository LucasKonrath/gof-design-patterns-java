package structural.composite;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompositeTest {

    @Test
    public void test() {
        Expense expenseOne = new SimpleExpense(10, "Coffee");
        Expense expenseTwo = new SimpleExpense(15, "Burger");

        Bill totalBill = new Bill("Restaurant Bill");
        totalBill.addExpense(expenseOne);
        totalBill.addExpense(expenseTwo);

        // Nested bills.
        Bill additionalBills = new Bill("Additional Bills");
        additionalBills.addExpense(new SimpleExpense(3, "Tip"));

        totalBill.addExpense(additionalBills);

        assertEquals(28, totalBill.getCost());
    }
}
