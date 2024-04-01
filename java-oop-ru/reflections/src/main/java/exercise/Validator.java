package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> result = new ArrayList<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            try {
                field.setAccessible(true);
                if (notNull != null && field.get(address) == null) {
                    result.add(field.getName());
                }
            }
            catch (IllegalAccessException e) {
                    System.out.println(e);
            }
        }
    return result;
    }
}
// END
