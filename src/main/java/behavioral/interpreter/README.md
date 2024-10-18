# Interpreter Design Pattern

The Interpreter pattern is a behavioral design pattern that defines a grammatical representation for a language and provides an interpreter to deal with this grammar.

The pattern consists of the following components:

1. **Expression**: An abstract class or interface that declares an abstract `interpret` operation that is common to all nodes in the abstract syntax tree.
2. **From**: Implements the `interpret` operation associated with from syntax in SQL.
3. **Where**: Implements the `interpret` operation associated with Where syntax in SQL.
4.  **Select**: Implements the `interpret` operation associated with Select syntax in SQL.
5.  **Row**: Represents the person names in each row of the DB.
6**Context**: Contains information that is global to the interpreter.

The key benefits of using the Interpreter pattern include:

- Defining a representation for a grammar as well as an interpreter to interpret expressions in the grammar
- Mapping a part of a grammar to a class, making it easy to modify or extend the grammar
- Implementing a language with a simple grammar

## Java Code Example

```java
// Abstract Expression
public interface Expression {
    List<String> interpret(Context context);
}

// From Expression
public class From implements Expression {

    private String table;
    private Where where;

    public From(String table) {
        this.table = table;
    }
    public From(String table, Where where) {
        this.table = table;
        this.where = where;
    }

    @Override
    public List<String> interpret(Context context) {
        context.setTable(table);
        if(where == null){
            return context.search();
        }
        return where.interpret(context);
    }
}

// Select Expression
public class Select implements Expression {
    private String column;
    private From from;

    public Select(String column, From from) {
        this.column = column;
        this.from = from;
    }

    @Override
    public List<String> interpret(Context context) {
        context.setColumn(column);
        return from.interpret(context);
    }
}

// Where Expression
public class Where implements Expression {

    private Predicate<String> filter;

    public Where(Predicate<String> filter) {
        this.filter = filter;
    }

    @Override
    public List<String> interpret(Context context) {
        context.setFilter(filter);
        return context.search();
    }
}

// Context
public class Context {

    private static Map<String, List<Row>> tables = new HashMap<>();

    static {
        List<Row> list = new ArrayList<>();
        list.add(new Row("John", "Doe"));
        list.add(new Row("Jan", "Kowalski"));
        list.add(new Row("Dominic", "Doom"));

        tables.put("people", list);
    }

    private String table;
    private String column;

    /**
     * Index of column to be shown in result.
     * Calculated in {@link #setColumnMapper()}
     */
    private int colIndex = -1;

    /**
     * Default setup, used for clearing the context for next queries.
     * See {@link Context#clear()}
     */
    private static final Predicate<String> matchAnyString = s -> s.length() > 0;
    private static final Function<String, Stream<? extends String>> matchAllColumns = Stream::of;
    /**
     * Varies based on setup in subclasses of {@link Expression}
     */
    private Predicate<String> whereFilter = matchAnyString;
    private Function<String, Stream<? extends String>> columnMapper = matchAllColumns;

    void setColumn(String column) {
        this.column = column;
        setColumnMapper();
    }

    void setTable(String table) {
        this.table = table;
    }

    void setFilter(Predicate<String> filter) {
        whereFilter = filter;
    }

    /**
     * Clears the context to defaults.
     * No filters, match all columns.
     */
    void clear() {
        column = "";
        columnMapper = matchAllColumns;
        whereFilter = matchAnyString;
    }

    List<String> search() {

        List<String> result = tables.entrySet()
                .stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(table))
                .flatMap(entry -> Stream.of(entry.getValue()))
                .flatMap(Collection::stream)
                .map(Row::toString)
                .flatMap(columnMapper)
                .filter(whereFilter)
                .collect(Collectors.toList());

        clear();

        return result;
    }

    /**
     * Sets column mapper based on {@link #column} attribute.
     * Note: If column is unknown, will remain to look for all columns.
     */
    private void setColumnMapper() {
        switch (column) {
            case "*":
                colIndex = -1;
                break;
            case "name":
                colIndex = 0;
                break;
            case "surname":
                colIndex = 1;
                break;
        }
        if (colIndex != -1) {
            columnMapper = s -> Stream.of(s.split(" ")[colIndex]);
        }
    }
}
```
### Test
```java
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
```
The Interpreter pattern is useful when you need to define a grammar and interpret expressions conforming to that grammar. It provides a way to map each rule in the grammar to a class, making it easy to modify or extend the grammar.


Tests found [here](../../../../../src/test/java/behavioral/interpreter)