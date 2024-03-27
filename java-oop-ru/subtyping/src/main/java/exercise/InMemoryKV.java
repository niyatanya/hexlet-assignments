package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> data;

    public InMemoryKV(Map<String, String> data) {
        this.data = new HashMap<>(data);
    }

    public void set(String key, String value) {
        data.put(key, value);
    }

    public String get(String key, String defaultValue) {
        return this.data.getOrDefault(key, defaultValue);
    }

    public void unset(String key) {
        this.data.remove(key);
    }

    public Map<String, String> toMap() {
        return new HashMap<>(data);
    }
}
// END
