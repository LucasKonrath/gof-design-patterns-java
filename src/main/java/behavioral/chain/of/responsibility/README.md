# Chain of Responsibility Design Pattern

The Chain of Responsibility pattern is a behavioral design pattern that allows an event to be handled by one of several handlers in a chain. Each handler in the chain decides whether to handle the request or pass it along to the next handler in the chain.

The pattern consists of the following components:

1. **Handler**: The base interface or abstract class that defines the handling operation and a reference to the next handler in the chain.
2. **Concrete Handlers**: Implementations of the Handler interface that can handle specific requests.
3. **Client**: The component that initiates the request to be handled.

The key benefits of using the Chain of Responsibility pattern include:

- Decoupling the sender and receiver of a request
- Allowing multiple handlers to handle a request
- Allowing new handlers to be added or removed dynamically

## Java Code Example

```java
// Handler interface
public interface BillDispenserChain {
    void setNextChain(BillDispenserChain nextChain);
    void dispenseBill(WithdrawalRequest withdrawalRequest);
}

// Concrete Handler 1
public class _5DollarBillDispenser implements BillDispenserChain {

    private BillDispenserChain chain;
    @Override
    public void setNextChain(BillDispenserChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispenseBill(WithdrawalRequest withdrawalRequest) {
        if(withdrawalRequest.getAmount() >= 5){
            int bills = withdrawalRequest.getAmount() / 5;
            int carryOver = withdrawalRequest.getAmount() % 5;
            System.out.println("Getting " + bills + " 5$ bills");
            if(carryOver > 0){
                this.chain.dispenseBill(new WithdrawalRequest(carryOver));
            }
        } else {
            this.chain.dispenseBill(withdrawalRequest);
        }
    }
}

// Concrete Handler 2
public class _10DollarBillDispenser implements BillDispenserChain {

    private BillDispenserChain chain;
    @Override
    public void setNextChain(BillDispenserChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispenseBill(WithdrawalRequest withdrawalRequest) {
        if(withdrawalRequest.getAmount() >= 10){
            int bills = withdrawalRequest.getAmount() / 10;
            int carryOver = withdrawalRequest.getAmount() % 10;
            System.out.println("Getting " + bills + " 10$ bills");
            if(carryOver > 0){
                this.chain.dispenseBill(new WithdrawalRequest(carryOver));
            }
        } else {
            this.chain.dispenseBill(withdrawalRequest);
        }
    }
}

// And also 20 dollar and 50 dollar dispensers

// Request class
public class WithdrawalRequest {

    private int amount;

    public WithdrawalRequest(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

// Client code
public class ATMDispenserChain {

    private BillDispenserChain billDispenserChain;

    public ATMDispenserChain() {
        this.billDispenserChain = new _50DollarBillDispenser();
        BillDispenserChain _20dollarChain = new _20DollarBillDispenser();
        BillDispenserChain _10dollarChain = new _10DollarBillDispenser();
        BillDispenserChain _5dollarChain = new _5DollarBillDispenser();

        this.billDispenserChain.setNextChain(_20dollarChain);
        _20dollarChain.setNextChain(_10dollarChain);
        _10dollarChain.setNextChain(_5dollarChain);
    }

    public void dispense(WithdrawalRequest withdrawalRequest){
        billDispenserChain.dispenseBill(withdrawalRequest);
    }
}
```

### Test
```java
    @Test
    public void test(){
        ATMDispenserChain atmDispenserChain = new ATMDispenserChain();
        atmDispenserChain.dispense(new WithdrawalRequest(75));
    }
```
### Output:
```
Getting 1 50$ bills
Getting 1 20$ bills
Getting 1 5$ bills
```

Tests found [here](../../../../../src/test/java/behavioral/chain/of/responsibility)