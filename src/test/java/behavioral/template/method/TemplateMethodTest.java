package behavioral.template.method;

import org.junit.Test;

public class TemplateMethodTest {

    @Test
    public void test() {
        CakeTemplate cake = new ChocolateCake();
        cake.makeCake();

        CakeTemplate cake2 = new LemonCake();
        cake2.makeCake();
    }
}
