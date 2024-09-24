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
        LOGGER.info("Thread " + Thread.currentThread().getName() + " started");
        int max = MaxThread.getMax();
        LOGGER.info("Thread " + Thread.currentThread().getName() + " finished");

        MinThread minThread = new MinThread(numbers);
        minThread.start();
        LOGGER.info("Thread " + Thread.currentThread().getName() + " started");
        int min = MinThread.getMin();
        LOGGER.info("Thread " + Thread.currentThread().getName() + " finished");

        return new HashMap<String, Integer>(Map.of("min", min, "max", max));
    }
    // END
}
