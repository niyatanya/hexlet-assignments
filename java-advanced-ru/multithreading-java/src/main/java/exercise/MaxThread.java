package exercise;

// BEGIN
import java.util.Arrays;

class MaxThread extends Thread {

    private int[] numbers;
    private int max;

    MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int[] sortedNums = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedNums);
        max = sortedNums[sortedNums.length - 1];

//        int max = numbers[0];
//
//        for (int currentNumber : numbers) {
//            if (currentNumber > max) {
//                max = currentNumber;
//            }
//        }
//
//        maximum = max;
    }

    public int getMax() {
        return max;
    }
}
// END
