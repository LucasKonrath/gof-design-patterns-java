package behavioral.chain.of.responsibility;

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
