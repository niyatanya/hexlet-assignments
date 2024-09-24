package exercise;

// BEGIN
import java.util.Arrays;

class MinThread extends Thread {

    private int[] numbers;
    private int min;

    MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int[] sortedNums = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedNums);
        min = sortedNums[0];

//        int minumum = numbers[0];
//
//        for (int currentNumber : numbers) {
//            if (currentNumber < minumum) {
//                minumum = currentNumber;
//            }
//        }
//
//        min = minumum;
    }

    public int getMin() {
        return min;
    }
}
// END
