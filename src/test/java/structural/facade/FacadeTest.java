package structural.facade;

import org.junit.Test;

public class FacadeTest {

    @Test
    public void test() {
        KonamiCodeFacade facade = new KonamiCodeFacade();
        facade.konamiCode();
    }
}
