package exercise;

import java.util.Map;
import java.util.Map.Entry;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }

    @Override
    public String toString() {
        String result = "";
        for (Entry entry : this.attributes.entrySet()) {
            result = result
                    + " "
                    + entry.getKey()
                    + "=\""
                    + entry.getValue()
                    + "\"";
        }
        return "<"
                + this.name
                + result
                + ">";
    }
}
// END
