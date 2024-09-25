package exercise;

// BEGIN
import java.util.Random;

public class ListThread extends Thread {

    private SafetyList safetyList;

    public ListThread(SafetyList safetyList) {
        this.safetyList = safetyList;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {

            try {
                this.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            safetyList.add(random.nextInt());
        }
    }
}
// END
