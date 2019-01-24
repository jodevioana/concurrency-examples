package concurrency.examples.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public final class ExampleUtils {

    public static void stop(ExecutorService executor) {
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(30, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.out.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.out.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}
