package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.HashMap;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        MaxThread maxThread = new MaxThread(numbers);
        MinThread minThread = new MinThread(numbers);

        maxThread.start();
        LOGGER.info("Thread 1 " + maxThread.getName() + " started");
        minThread.start();
        LOGGER.info("Thread 2 " + minThread.getName() + " started");

        try {
            maxThread.join();
            LOGGER.info("Thread 1 " + maxThread.getName() + " finished");
            minThread.join();
            LOGGER.info("Thread 2 " + minThread.getName() + " finished");
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }

        return Map.of(
                "min", minThread.getMin(),
                "max", maxThread.getMax());
    }
    // END
}
