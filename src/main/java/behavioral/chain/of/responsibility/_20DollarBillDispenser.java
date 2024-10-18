package behavioral.chain.of.responsibility;

public class _20DollarBillDispenser implements BillDispenserChain {

    private BillDispenserChain chain;
    @Override
    public void setNextChain(BillDispenserChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispenseBill(WithdrawalRequest withdrawalRequest) {
        if(withdrawalRequest.getAmount() >= 20){
            int bills = withdrawalRequest.getAmount() / 20;
            int carryOver = withdrawalRequest.getAmount() % 20;
            System.out.println("Getting " + bills + " 20$ bills");
            if(carryOver > 0){
                this.chain.dispenseBill(new WithdrawalRequest(carryOver));
            }
        } else {
            this.chain.dispenseBill(withdrawalRequest);
        }
    }
}
