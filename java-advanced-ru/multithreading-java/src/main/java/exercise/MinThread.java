package exercise;

// BEGIN
import java.util.Arrays;

public class MinThread extends Thread {

    static int[] numbers = new int[50];
    static int min;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    public static int getMin() {
        return min;
    }

    @Override
    public void run() {
        int[] sortedNums = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedNums);
        min = sortedNums[0];
    }
}
// END
