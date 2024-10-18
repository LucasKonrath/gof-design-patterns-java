# Iterator Design Pattern

The Iterator pattern is a behavioral design pattern that provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

The pattern consists of the following components:

1. **Iterator**: An interface or abstract class that defines the operations for traversing and accessing the elements of an aggregate object.
2. **ConcreteIterator**: Implements the Iterator interface and keeps track of the current position in the traversal of the aggregate object.
3. **Aggregate**: An interface or abstract class that defines the operations for creating an Iterator object.
4. **ConcreteAggregate**: Implements the Aggregate interface and returns an instance of the ConcreteIterator class.

The key benefits of using the Iterator pattern include:

- Providing a uniform way to access elements of different types of collections (e.g., lists, trees, graphs)
- Decoupling the collection from the traversal algorithm
- Allowing multiple traversals of the same collection concurrently

## Java Code Example

```java
// Iterator interface
public interface WeekdayIterator {
    boolean hasNext();
    Weekday next();
}

// Weekday
public enum Weekday {
    MONDAY,TUESDAY, WEDNESDAY,THURSDAY, FRIDAY
}

// Collection
public interface WeekdayCollection {
    void addWeekday(Weekday weekday);
    void removeWeekday(Weekday weekday);
    WeekdayIterator getWeekdayIterator();
}

// Collection Implementation
public class WeekdayCollectionImpl implements WeekdayCollection {

    private List<Weekday> weekdays;

    public WeekdayCollectionImpl() {
        weekdays = new ArrayList<>();
    }

    @Override
    public void addWeekday(Weekday weekday) {
        this.weekdays.add(weekday);
    }

    @Override
    public void removeWeekday(Weekday weekday) {
        this.weekdays.remove(weekday);
    }

    @Override
    public WeekdayIterator getWeekdayIterator() {
        return new WeekdayIteratorImpl(weekdays);
    }

    private class WeekdayIteratorImpl implements WeekdayIterator {

        List<Weekday> weekdays;
        int position;

        public WeekdayIteratorImpl(List<Weekday> weekdays) {
            this.weekdays = weekdays;
        }

        @Override
        public boolean hasNext() {
            return position < weekdays.size();
        }

        @Override
        public Weekday next() {
            Weekday weekday = weekdays.get(position);
            position++;
            return weekday;
        }
    }
}

```

In this example, we have an `WeekdayIterator` interface that defines the `hasNext` and `next` methods for traversing a collection. 

By using the Iterator pattern, the client code can traverse the collection without knowing its underlying implementation details. Additionally, the pattern allows for multiple traversals of the same collection concurrently, as each iterator maintains its own state.

The Iterator pattern is commonly used in Java collections, such as `ArrayList`, `LinkedList`, and `HashSet`, where the `Iterator` interface is implemented by their respective iterator classes.

### Test
```java
    @Test
    public void testIterator() {
        WeekdayCollection weekdays = new WeekdayCollectionImpl();
        weekdays.addWeekday(Weekday.MONDAY);
        weekdays.addWeekday(Weekday.TUESDAY);
        weekdays.addWeekday(Weekday.WEDNESDAY);
        weekdays.addWeekday(Weekday.THURSDAY);
        weekdays.addWeekday(Weekday.FRIDAY);

        WeekdayIterator weekdayIterator = weekdays.getWeekdayIterator();
        List<Weekday> actual = new ArrayList<>();

        while (weekdayIterator.hasNext()) {
            actual.add(weekdayIterator.next());
        }

        assertEquals(5, actual.size());
    }
```

Tests found [here](../../../../../src/test/java/behavioral/iterator)