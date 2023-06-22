public class Task2 {
    public static synchronized void message() throws InterruptedException {
        System.out.println("Task2 " + Thread.currentThread().getName());
        Task1.message();
    }
}
