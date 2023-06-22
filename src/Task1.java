public class Task1 {
    public static synchronized void message() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Task1 " + Thread.currentThread().getName());
        Task2.message();
    }
}
