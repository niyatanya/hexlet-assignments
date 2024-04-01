package exercise;

// BEGIN
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void save(Path path, Car car) throws Exception {
        String serializedCar = car.serialize();
        List<String> list = new ArrayList<String>(Arrays.asList(serializedCar.split("\\n")));
        Files.write(path, list, StandardCharsets.UTF_8);
    }
    public static Car extract(Path path) throws Exception {
        String resultString = Files.readString(path);
        return Car.unserialize(resultString);
    }
}
// END
