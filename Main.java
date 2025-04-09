import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        List<Date> dates = new ArrayList<>();

        dates.add(new Date(1, 1, 2025));
        dates.add(new Date(6, 4, 2025));
        dates.add(new Date(29, 2, 2024)); // leap year
        dates.add(new Date(30, 2, 2023)); // invalid

        for (Date d : dates) {
            d.printDate();
            if (d.isValidDate()) {
                System.out.println("Day of week: " + d.getDayOfWeek());
            } else {
                System.out.println("Invalid Date");
            }
            System.out.println();
        }

        Date d1 = new Date(8, 4, 2025);
        Date d2 = new Date(25, 3, 2025);
        System.out.println("Difference in days: " + d1.calculateDifference(d2));

        System.out.println("\nSorted Dates:");
        Collections.sort(dates);
        for (Date d : dates) {
            d.printDate();
        }
    }
}
