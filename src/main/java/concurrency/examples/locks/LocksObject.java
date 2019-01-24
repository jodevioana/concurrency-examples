package concurrency.examples.locks;

import java.util.concurrent.locks.ReentrantLock;

public class LocksObject {

    private static ReentrantLock lock = new ReentrantLock();
    private static int count = 0;

    public void increment(int thread) {
        lock.lock();
        try {
            System.out.println("Incrementing thread - " +thread + ". Current value " + count);
            count++;
        } finally {
            lock.unlock();
        }
    }
}
