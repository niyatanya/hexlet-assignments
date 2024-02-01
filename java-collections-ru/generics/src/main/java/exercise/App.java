package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> foundBooks = new ArrayList<>(books.size());

        return books.stream()
                .filter(map -> compareMaps(map, where))
                .toList();
    }

    public static boolean compareMaps(Map<String, String> map1, Map<String, String> map2) {
        for (var map2key : map2.keySet()) {
            if (!map2.get(map2key).equals(map1.get(map2key))) {
                return false;
            }
        }
        return true;
    }
}
//END
