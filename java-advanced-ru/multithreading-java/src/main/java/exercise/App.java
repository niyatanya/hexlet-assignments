package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.HashMap;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        MaxThread maxThread = new MaxThread(numbers);
        maxThread.start();
        LOGGER.info("Thread 1 " + Thread.currentThread().getName() + " started");

        MinThread minThread = new MinThread(numbers);
        minThread.start();
        LOGGER.info("Thread 2 " + Thread.currentThread().getName() + " started");

        try {
            maxThread.join();
            minThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int max = MaxThread.getMax();
        LOGGER.info("Thread 1 " + Thread.currentThread().getName() + " finished");

        int min = MinThread.getMin();
        LOGGER.info("Thread 2 " + Thread.currentThread().getName() + " finished");

        return new HashMap<String, Integer>(Map.of("min", min, "max", max));
    }
    // END
}
