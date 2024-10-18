package behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

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
