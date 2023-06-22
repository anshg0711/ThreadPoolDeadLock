import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService executor =
                new ThreadPoolExecutor(2, 3, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(3));
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+" Entered in Task1");
                    Task1.message();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" Entered in Task2");
                try {
                    Task2.message();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        executor.execute(runnable1); //r1
        executor.execute(runnable2); //r2
        executor.shutdown();


//    executorService.execute(runnableTask1);
//        executorService.execute(runnableTask2);
//        Future<String > ansh= executorService.submit(callableTask);
//        System.out.printf("Hello and welcome!");
//        value val= new value();
//        value1 val1= new value1();
//        val.start();
//        val1.start();
//        val1.run1();
//        val.run1();
//        Executor executor = Executors.newSingleThreadExecutor();
//        executor.execute(() -> System.out.println("Hello World"));
//
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        Future<String> future = executorService.submit(() -> "Hello World");
//        String result = future.get();
//        System.out.println(result);
//        Callable<String> callableTask = () -> {
//            TimeUnit.MILLISECONDS.sleep(300);
//            return "Task's execution";
//        };
//        System.out.print(callableTask.call());
//        Runnable runnableTask = () -> {
//            try {
//                TimeUnit.MILLISECONDS.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };
//
//        Callable<String> callableTask = () -> {
//            TimeUnit.MILLISECONDS.sleep(300);
//            return "Task's execution";
//        };
//
//        List<Callable<String>> callableTasks = new ArrayList<>();
//        callableTasks.add(callableTask);
//        callableTasks.add(callableTask);
//        callableTasks.add(callableTask);
//
//        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {
//
//            // Press Ctrl+D to start debugging your code. We have set one breakpoint
//            // for you, but you can always add more by pressing Cmd+F8.
//            System.out.println("i = " + i);
//        }

//        Runnable runnableTask1 = () -> {
//
//        };
//        Runnable runnableTask2 = () -> {
//            try {
//                TimeUnit.MILLISECONDS.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };
//        Callable<String> callableTask = () -> {
//            TimeUnit.MILLISECONDS.sleep(300);
//            return "Task's execution";
//        };
//        List<Callable<String>> callableTasks = new ArrayList<>();
//        callableTasks.add(callableTask);
//        callableTasks.add(callableTask);
//        callableTasks.add(callableTask);
//        ExecutorService executor = Executors.newFixedThreadPool(10);
    }
}