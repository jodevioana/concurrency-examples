package concurrency.examples.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.IntStream;

import static concurrency.examples.util.ExampleUtils.stop;
import static java.lang.Thread.sleep;

public class LocksExamples {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);


        /********* Example 1 *********/
        LocksObject countObject = new LocksObject();
        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(() -> countObject.increment(i)));




        /********* Example 2 *********/
//        ReentrantLock lock = new ReentrantLock();
//
//        //other thread
//        executor.submit(() -> {
//            lock.lock();
//            try {
//                sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
//        });
//
//        //main thread
//        executor.submit(() -> {
//            System.out.println("Locked: " + lock.isLocked());
//            System.out.println("Held by me: " + lock.isHeldByCurrentThread());
//            boolean locked = lock.tryLock();
//            System.out.println("Lock acquired: " + locked);
//        });




        /********* Example 3 *********/
//        Map<String, String> map = new HashMap<>();
//        StampedLock lock = new StampedLock();
//
//        executor.submit(() -> {
//            long stamp = lock.writeLock();
//            try {
//                System.out.println("Writing bar 1");
//                map.put("foo", "bar 1");
//                TimeUnit.SECONDS.sleep(4);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlockWrite(stamp);
//            }
//        });
//
//        executor.submit(() -> {
//            long stamp = lock.writeLock();
//            try {
//                System.out.println("Writing bar 2");
//                map.put("foo", "bar 2");
//            } finally {
//                lock.unlockWrite(stamp);
//            }
//        });
//
//        Runnable readTask = () -> {
//            long stamp = lock.readLock();
//            try {
//                System.out.println("Reading foo - " + map.get("foo"));
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlockRead(stamp);
//            }
//        };
//
//        executor.submit(readTask);
//        executor.submit(readTask);


        stop(executor);
    }
}
