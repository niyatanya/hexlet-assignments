package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        for (Entry entry : storage.toMap().entrySet()) {
            storage.unset(entry.getKey().toString());
            storage.set(entry.getValue().toString(), entry.getKey().toString());
        }
    }
}
// END
