package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for (Method method : Address.class.getDeclaredMethods())
            if (method.isAnnotationPresent(Inspect.class)) {
                String methodName = method.getName();
                String valueType = method.getReturnType().toString();
                if (valueType.contains("java.lang.")) {
                    valueType = valueType.substring(valueType.lastIndexOf(".") + 1);
                }
                System.out.println("Method " + methodName + " returns a value of type " + valueType);
            }
        // END
    }
}
