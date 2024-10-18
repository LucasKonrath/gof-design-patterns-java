package behavioral.state;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StateTest {

    @Test
    public void test() {
        AcContext acContext = new AcContext();

        State acOnState = new AcOnState();
        State acOffState = new AcOffState();

        acContext.setAcState(acOffState);
        assertFalse(acContext.doAction());

        acContext.setAcState(acOnState);
        assertTrue(acContext.doAction());
    }
}
