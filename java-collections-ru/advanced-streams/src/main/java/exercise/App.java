package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

// BEGIN
public class App {
    public static String getForwardedVariables(String file) {
        List<String> list = Arrays.asList(file.split("\n"));

        return list.stream()
                .filter((line) -> line.startsWith("environment"))
                .filter((line) -> line.contains("X_FORWARDED_"))
                .map(line -> line.substring(13, line.length() - 1))
                .flatMap(line -> Arrays.stream(line.trim().split(",")))
                .filter(item -> item.startsWith("X_FORWARDED_"))
                .map(text -> text.replace("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
