package behavioral.chain.of.responsibility;

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
