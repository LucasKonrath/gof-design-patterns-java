package behavioral.iterator;

public interface WeekdayCollection {
    void addWeekday(Weekday weekday);
    void removeWeekday(Weekday weekday);
    WeekdayIterator getWeekdayIterator();
}
