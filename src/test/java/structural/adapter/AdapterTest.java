package structural.adapter;

import org.junit.Test;

public class AdapterTest {

    @Test
    public void test() {
        iPhone16 iPhone16 = new iPhone16(new LightningPortToUsbCAdapter());
        iPhone16.charge();
    }
}
