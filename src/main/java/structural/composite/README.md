# Composite Design Pattern (Simplified)

## Intent
The Composite pattern allows you to compose objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions of objects uniformly.

## Problem
How can we treat a group of objects the same way as a single instance of the object?

## Solution
Define a unified Component interface for both part (Leaf) objects and whole (Composite) objects.

## Implementation

```java
public interface Expense {
    int getCost();
}

// Leaf
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

// Composite
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
```

## Test

```java
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
```

## Advantages
1. You can work with complex tree structures more conveniently: use polymorphism and recursion to your advantage.
2. Open/Closed Principle: You can introduce new element types into the app without breaking the existing code.
3. Provides a uniform interface for both part-whole hierarchies and individual objects.

## Disadvantages
1. It might be difficult to provide a common interface for classes whose functionality differs too much.
2. In certain scenarios, the Composite pattern can overly generalize the system design.

## Common Use Cases
1. When you want to represent part-whole hierarchies of objects.
2. When you want clients to be able to ignore the difference between compositions of objects and individual objects.
3. Graphical user interface components (nested elements).
4. File and folder structures.
5. Organizational hierarchies.

## Considerations
- The key to the Composite pattern is an abstract class that represents both primitives and their containers.
- The Composite pattern often leverages the Builder pattern for constructing complex composite structures.
- It's important to consider how to handle operations that only make sense for either leaves or composites. You might need to implement default behaviors or throw exceptions.
- Be cautious about shared leaf nodes if you're implementing a structure where a leaf can belong to multiple composites.

Tests found [here](../../../../../src/test/java/structural/composite)
