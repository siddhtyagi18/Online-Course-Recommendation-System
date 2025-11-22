package threads;

public class CourseLoaderThread extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Loading recommended courses... " + i);
                Thread.sleep(500); // 0.5 second
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
}
