package behavioral.interpreter;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InterpreterTest {

    @Test
    public void test() {
        Expression sql = new Select("name", new From("people"));
        Context context = new Context();
        List<String> result = sql.interpret(context);
        assertEquals(3, result.size());

        sql = new Select("name", new From("people",
             new Where( name -> name.startsWith("D"))));

        result = sql.interpret(context);

        assertEquals("Dominic", result.get(0));
    }
}
