package exercise;

// BEGIN
import java.util.Arrays;

public class MaxThread extends Thread {

    static int[] numbers = new int[50];
    static int max;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    public static int getMax() {
        return max;
    }

    @Override
    public void run() {
        int[] sortedNums = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedNums);
        max = sortedNums[sortedNums.length - 1];
    }
}
// END
