package behavioral.chain.of.responsibility;

import org.junit.Test;

public class ChainOfResponsibilityTest {

    @Test
    public void test(){
        ATMDispenserChain atmDispenserChain = new ATMDispenserChain();
        atmDispenserChain.dispense(new WithdrawalRequest(75));
    }
}
