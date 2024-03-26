package exercise;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> property, int num) {
        if (num > property.size()) {
            num = property.size();
        }

        List<Home> sortedList = new ArrayList<>(property);
        Collections.sort(sortedList, Comparator.comparingDouble(Home::getArea));
        return sortedList.subList(0, num).stream()
                .map(Home::toString)
                .toList();
    }
}
// END
