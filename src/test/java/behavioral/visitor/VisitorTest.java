package behavioral.visitor;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    @Test
    public void test(){
        List<GameStoreItem> items = new ArrayList<>();
        items.add(new BaseGame(0, "Deadlock"));
        items.add(new DeluxePack(50,
             "Warhammer 40k Space Marine Battle Pass", new BaseGame(40, "Warhammer 40K Space Marine 2")));

        GameStoreVisitor visitor = new GameStoreVisitorImpl();

        assertEquals(90L, items.stream()
                .mapToLong(item -> item.accept(visitor))
                .sum());

    }
}
