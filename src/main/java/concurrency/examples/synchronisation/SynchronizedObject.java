package concurrency.examples.synchronisation;

public class SynchronizedObject {

    private static int count = 0;

    synchronized void incrementMethodSync(int thread) {
        System.out.println("Incrementing thread - " +thread + ". Current value " + count);
        count = count + 1;
    }

    public int getCount() {
        return count;
    }
}
