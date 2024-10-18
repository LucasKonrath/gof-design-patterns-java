package behavioral.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IteratorTest {

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
}
