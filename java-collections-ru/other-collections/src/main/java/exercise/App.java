package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, String> result = new LinkedHashMap<>();
        map1.forEach((key, value) -> result.put(key, "deleted"));
        map2.forEach((key, value) -> {
            if (!result.containsKey(key)) {
                result.put(key, "added");
            } else {
                if (map1.get(key).equals(value)) {
                    result.put(key, "unchanged");
                } else {
                    result.put(key, "changed");
                }
            }
        });

        LinkedHashMap<String, String> resultSortedLinked = result.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return resultSortedLinked;
    }
}
//END
