package Modules.module6.hometask5;

public class MultiThreadTest {
    public static void main(String[] args) {
        Runnable task = () -> {
            ConfigurationManager config = ConfigurationManager.getInstance();
            config.setSetting(Thread.currentThread().getName(), "Thread-specific setting");
            config.showSettings();
        };

        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");

        thread1.start();
        thread2.start();
    }
}
