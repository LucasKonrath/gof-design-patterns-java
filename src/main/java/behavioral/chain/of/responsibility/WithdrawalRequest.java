package behavioral.chain.of.responsibility;

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
