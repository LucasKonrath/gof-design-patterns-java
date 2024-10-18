package behavioral.chain.of.responsibility;

public interface BillDispenserChain {
    void setNextChain(BillDispenserChain nextChain);
    void dispenseBill(WithdrawalRequest withdrawalRequest);
}
