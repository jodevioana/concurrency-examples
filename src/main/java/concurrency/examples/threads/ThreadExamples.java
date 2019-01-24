package concurrency.examples.threads;

import java.util.concurrent.TimeUnit;

public class ThreadExamples {

    public static void main(String[] args) {


        /*************** Example 1 **********/
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");




        /*************** Example 2 **********/
//        Runnable runnable = () -> {
//            try {
//                String name = Thread.currentThread().getName();
//                System.out.println("Foo " + name);
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println("Bar " + name);
//            }
//            catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };
//
//        Thread thread = new Thread(runnable);
//        thread.start();
    }
}
