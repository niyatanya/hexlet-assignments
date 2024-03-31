package exercise;

// BEGIN
import java.lang.Math;

public class App {
    public static void printSquare(Circle circle) {
        try {
            int roundedSquare = Math.round(circle.getSquare());
            System.out.println(roundedSquare);
        } catch (NegativeRadiusException e) {
        System.out.println(e.getMessage());
        } finally {
        System.out.println("Вычисление окончено");
        }
    }
}
// END
