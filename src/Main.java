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
    }
}
