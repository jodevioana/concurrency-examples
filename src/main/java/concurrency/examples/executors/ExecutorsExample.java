package concurrency.examples.executors;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static concurrency.examples.util.ExampleUtils.stop;

public class ExecutorsExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        /*************** Example 1 **********/
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> threadImplementation("Hello 1 "));
        executor.submit(() -> threadImplementation("Hello 2 "));
        executor.submit(() -> threadImplementation("Hello 3 "));
        executor.submit(() -> threadImplementation("Hello 4 "));
        executor.submit(() -> threadImplementation("Hello 5 "));
        executor.submit(() -> threadImplementation("Hello 6 "));
        executor.submit(() -> threadImplementation("Hello 7 "));
        executor.submit(() -> threadImplementation("Hello 8 "));

        /*************** Example 2 **********/
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//        Future<String> future1 = executor.submit(() -> returningThreadImplementation("Hello 1 "));
//        Future<String> future2 = executor.submit(() -> returningThreadImplementation("Hello 2 "));
//        Future<String> future3 = executor.submit(() -> returningThreadImplementation("Hello 3 "));
//        Future<String> future4 = executor.submit(() -> returningThreadImplementation("Hello 4 "));
//        Future<String> future5 = executor.submit(() -> returningThreadImplementation("Hello 5 "));
//        Future<String> future6 = executor.submit(() -> returningThreadImplementation("Hello 6 "));
//        Future<String> future7 = executor.submit(() -> returningThreadImplementation("Hello 7 "));
//        Future<String> future8 = executor.submit(() -> returningThreadImplementation("Hello 8 "));
//
//        System.out.println(future1.get());
//        System.out.println(future2.get());
//        System.out.println(future3.get());
//        System.out.println(future4.get());
//        System.out.println(future5.get());
//        System.out.println(future6.get());
//        System.out.println(future7.get());



        /*************** Example 3 **********/
//        ExecutorService executor = Executors.newFixedThreadPool(4);
//        executor.submit(() -> threadImplementation("Hello 1 "));
//        executor.submit(() -> threadImplementation("Hello 2 "));
//        executor.submit(() -> threadImplementation("Hello 3 "));
//        executor.submit(() -> threadImplementation("Hello 4 "));
//        executor.submit(() -> threadImplementation("Hello 5 "));
//        executor.submit(() -> threadImplementation("Hello 6 "));
//        executor.submit(() -> threadImplementation("Hello 7 "));
//        executor.submit(() -> threadImplementation("Hello 8 "));

        /*************** Example 4 **********/
//        ExecutorService executor = Executors.newCachedThreadPool();
//       executor.submit(() -> threadImplementation("Hello 1 "));
//        executor.submit(() -> threadImplementation("Hello 2 "));
//        executor.submit(() -> threadImplementation("Hello 3 "));
//        executor.submit(() -> threadImplementation("Hello 4 "));
//        executor.submit(() -> threadImplementation("Hello 5 "));
//        executor.submit(() -> threadImplementation("Hello 6 "));
//        executor.submit(() -> threadImplementation("Hello 7 "));
//        executor.submit(() -> threadImplementation("Hello 8 "));

        /*************** Example 5 **********/
//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
//        executor.schedule(() -> threadImplementation("Hello 1 "), 3, TimeUnit.SECONDS);
//        executor.schedule(() -> threadImplementation("Hello 2 "), 1, TimeUnit.SECONDS);
//        executor.schedule(() -> threadImplementation("Hello 3 "), 1, TimeUnit.SECONDS);
//        executor.schedule(() -> threadImplementation("Hello 4 "), 7, TimeUnit.SECONDS);
//        executor.schedule(() -> threadImplementation("Hello 5 "), 8, TimeUnit.SECONDS);
//        executor.schedule(() -> threadImplementation("Hello 6 "), 2, TimeUnit.SECONDS);
//        executor.schedule(() -> threadImplementation("Hello 7 "), 2, TimeUnit.SECONDS);
//        executor.schedule(() -> threadImplementation("Hello 8 "), 10, TimeUnit.SECONDS);


        /*************** Example 6 **********/
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//        List<Callable<String>> callables = Arrays.asList(
//                () -> returningThreadImplementation("Hello 1 "),
//                () -> returningThreadImplementation("Hello 2 "),
//                () -> returningThreadImplementation("Hello 3 "),
//                () -> returningThreadImplementation("Hello 4 "),
//                () -> returningThreadImplementation("Hello 5 "),
//                () -> returningThreadImplementation("Hello 6 "),
//                () -> returningThreadImplementation("Hello 7 "),
//                () -> returningThreadImplementation("Hello 8 "));
//
//        executor.invokeAll(callables)
//                .stream()
//                .map(future -> {
//                    try {
//                        return future.get();
//                    }
//                    catch (Exception e) {
//                        throw new IllegalStateException(e);
//                    }
//                })
//                .forEach(System.out::println);


        /*************** Example 7 **********/
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//        List<Callable<String>> callables = Arrays.asList(
//                () -> returningThreadImplementation("Hello 1 "),
//                () -> returningThreadImplementation("Hello 2 "),
//                () -> returningThreadImplementation("Hello 3 "),
//                () -> returningThreadImplementation("Hello 4 "),
//                () -> returningThreadImplementation("Hello 5 "),
//                () -> returningThreadImplementation("Hello 6 "),
//                () -> returningThreadImplementation("Hello 7 "),
//                () -> returningThreadImplementation("Hello 8 "));
//
//        String result = executor.invokeAny(callables);
//        System.out.println(result);
//        System.out.println("************************");


        /*************** Shutdown the executor **********/
        stop(executor);

    }

    private static String returningThreadImplementation(String s) {
        String threadName = Thread.currentThread().getName();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return s + threadName;
    }

    private static void threadImplementation(String s) {
        String threadName = Thread.currentThread().getName();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(s + threadName);
    }
}
