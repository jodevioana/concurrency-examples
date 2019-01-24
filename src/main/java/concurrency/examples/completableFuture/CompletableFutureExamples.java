package concurrency.examples.completableFuture;

import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureExamples {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        /********** Example 1 ***************/
        CompletableFuture<String> completableFuture1 = CompletableFuture
                //defining the initial callable
                .supplyAsync(() -> "Hello")
                //process the callable result, modifying it
                .thenApply(resultFromPrevious -> resultFromPrevious + " World")
                //do an action after completion
                .whenComplete((resultFromPrevious, throwable) -> System.out.println("Completed with result " + resultFromPrevious));
        String result1 = completableFuture1.get();
        System.out.println(result1);


        /********** Example 2 ***************/
//        CompletableFuture<Integer> completableFuture2 = CompletableFuture
//                //defining the initial callable
//                .supplyAsync(() -> Integer.valueOf("no number"))
//                .exceptionally(throwable -> {
//                    System.out.println("Log the error " + throwable.getMessage());
//                    //return a default number
//                    return 124;
//                })
//                //process the callable result, modifying it
//                .thenApply(resultFromPrevious -> resultFromPrevious + 1)
//                //do an action after completion
//                .whenComplete((resultFromPrevious, throwable) -> System.out.println("Completed with result " + resultFromPrevious));
//        Integer result2 = completableFuture2.get();
//        System.out.println(result2);

        /********** Example 3 ***************/
//        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(() -> "Hello")
//                .thenCompose(resultFromPrevious ->
//                        //only a new callable
//                        CompletableFuture.supplyAsync(() -> resultFromPrevious + " World")
//                );
//        String result3 = completableFuture3.get();
//        System.out.println(result3);

        /********** Example 4 ***************/
//        CompletableFuture<String> completableFuture4 = CompletableFuture.supplyAsync(() -> "Hello")
//                .thenCombine(
//                        //a new callable
//                        CompletableFuture.supplyAsync(() -> " World"),
//                        //how to combine the results
//                        (resultFromFirst, resultFromSecond) -> resultFromFirst + resultFromSecond
//                );
//        String result4 = completableFuture4.get();
//        System.out.println(result4);

        /********** Example 5 ***************/
//        CompletableFuture<String> completableFuture5 = CompletableFuture.supplyAsync(() -> "Hello")
//                .thenCombine(
//                        //a new callable
//                        CompletableFuture.supplyAsync(() -> " World"),
//                        //how to combine the results
//                        (resultFromFirst, resultFromSecond) -> resultFromFirst + resultFromSecond
//                )
//                .thenCombine(
//                        //a new callable
//                        CompletableFuture.supplyAsync(() -> Integer.valueOf("no number")),
//                        //how to combine the results
//                        (resultFromFirst, resultFromSecond) -> resultFromFirst + resultFromSecond
//                )
//                .exceptionally(throwable -> {
//                    System.out.println("Log error " + throwable.getMessage());
//                    return " new error string!";
//                });
//        String result5 = completableFuture5.get();
//        System.out.println(result5);

        /********** Example 6 ***************/
//        CompletableFuture<String> completableFuture6 = CompletableFuture.supplyAsync(() -> "Hello")
//                .thenCombine(
//                        //a new callable
//                        CompletableFuture.supplyAsync(() -> " World"),
//                        //how to combine the results
//                        (resultFromFirst, resultFromSecond) -> resultFromFirst + resultFromSecond
//                )
//                .exceptionally(throwable -> {
//                    System.out.println("Log error " + throwable.getMessage());
//                    return " new error string!";
//                })
//                .thenCombine(
//                        //a new callable
//                        CompletableFuture.supplyAsync(() -> Integer.valueOf("no number")),
//                        //how to combine the results
//                        (resultFromFirst, resultFromSecond) -> resultFromFirst + resultFromSecond
//                );
//        String result6 = completableFuture6.get();
//        System.out.println(result6);

        /********** Example 7 - Futures in parallel ***************/
//        CompletableFuture<String> future1
//                = CompletableFuture.supplyAsync(() -> "Hello");
//        CompletableFuture<String> future2
//                = CompletableFuture.supplyAsync(() -> "Beautiful");
//        CompletableFuture<String> future3
//                = CompletableFuture.supplyAsync(() -> "World");
//
//        CompletableFuture<Void> combinedFuture
//                = CompletableFuture.allOf(future1, future2, future3);
//
//        //awaits for all to be completed
//        combinedFuture.get();
//
//        String combined = Stream.of(future1, future2, future3)
//                .map(CompletableFuture::join)
//                .collect(Collectors.joining(" "));
//        System.out.println(combined);

        /********** Example 8 - Executors ***************/
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        ExecutorService executor = Executors.newFixedThreadPool(5);
//        ExecutorService executor = Executors.newCachedThreadPool();
//        CompletableFuture<String> executorFuture1 = CompletableFuture.supplyAsync(() -> callableImplementation("Hello 1"), executor);
//        CompletableFuture<String> executorFuture2 = CompletableFuture.supplyAsync(() -> callableImplementation("Hello 2"), executor);
//        CompletableFuture<String> executorFuture3 = CompletableFuture.supplyAsync(() -> callableImplementation("Hello 3"), executor);
//        CompletableFuture<String> executorFuture4 = CompletableFuture.supplyAsync(() -> callableImplementation("Hello 4"), executor);
//        CompletableFuture<String> executorFuture5 = CompletableFuture.supplyAsync(() -> callableImplementation("Hello 5"), executor);
//        CompletableFuture<Void> combinedFutureExecutor = CompletableFuture.allOf(
//                executorFuture1,
//                executorFuture2,
//                executorFuture3,
//                executorFuture4,
//                executorFuture5
//        );
//
//        //awaits for all to be completed
//        combinedFutureExecutor.get();
//
//        String combinedFutureResult = Stream.of(executorFuture1, executorFuture2, executorFuture3, executorFuture4, executorFuture5)
//                .map(CompletableFuture::join)
//                .collect(Collectors.joining("\n"));
//        System.out.println(combinedFutureResult);
    }

    private static String callableImplementation(String input) {
        try {
            System.out.println("Running input " + input);
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input;
    }
}
