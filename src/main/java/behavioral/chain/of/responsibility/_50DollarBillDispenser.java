package behavioral.chain.of.responsibility;

public class _50DollarBillDispenser implements BillDispenserChain {

    private BillDispenserChain chain;
    @Override
    public void setNextChain(BillDispenserChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispenseBill(WithdrawalRequest withdrawalRequest) {
        if(withdrawalRequest.getAmount() >= 50){
            int bills = withdrawalRequest.getAmount() / 50;
            int carryOver = withdrawalRequest.getAmount() % 50;
            System.out.println("Getting " + bills + " 50$ bills");
            if(carryOver > 0){
                this.chain.dispenseBill(new WithdrawalRequest(carryOver));
            }
        } else {
            this.chain.dispenseBill(withdrawalRequest);
        }
    }
}
