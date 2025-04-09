import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        updateDate(day, month, year);
    }

    public Date() {
        this(1, 1, 2000);
    }

    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }

    private boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    private boolean isValidDate(int d, int m, int y) {
        if (y < 1 || m < 1 || m > 12 || d < 1) return false;

        int[] daysInMonth = {
            31, isLeapYear(y) ? 29 : 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        return d <= daysInMonth[m - 1];
    }

    public boolean isValidDate() {
        return isValidDate(day, month, year);
    }

    public void updateDate(int d, int m, int y) {
        if (isValidDate(d, m, y)) {
            this.day = d;
            this.month = m;
            this.year = y;
        } else {
            System.out.println("Invalid date!");
        }
    }

    public String getDayOfWeek() {
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate.getDayOfWeek().toString();
    }

    public int calculateDifference(Date other) {
        LocalDate thisDate = LocalDate.of(year, month, day);
        LocalDate otherDate = LocalDate.of(other.year, other.month, other.day);
        return Math.abs((int) ChronoUnit.DAYS.between(thisDate, otherDate));
    }

    public void printDate() {
        System.out.printf("%02d-%02d-%d\n", day, month, year);
    }

    @Override
    public int compareTo(Date other) {
        if (this.year != other.year)
            return this.year - other.year;
        if (this.month != other.month)
            return this.month - other.month;
        return this.day - other.day;
    }
}
