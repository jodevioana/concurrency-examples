package concurrency.examples.synchronisation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static concurrency.examples.util.ExampleUtils.stop;

public class SynchornizedExamples {

    public static void main(String[] args) {

        SynchronizedObject countObject = new SynchronizedObject();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(() -> countObject.incrementMethodSync(i)));
        stop(executor);
    }
}
