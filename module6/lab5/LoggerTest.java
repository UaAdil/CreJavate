package Modules.module6.lab5;

public class LoggerTest {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.setLogLevel(LogLevel.INFO);  // Устанавливаем уровень логирования
        logger.setLogFilePath("application.log");

        // Создаем несколько потоков для логирования
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                logger.log("Message from thread 1 - INFO", LogLevel.INFO);
                try { Thread.sleep(100); } catch (InterruptedException e) { }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                logger.log("Message from thread 2 - WARNING", LogLevel.WARNING);
                try { Thread.sleep(100); } catch (InterruptedException e) { }
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                logger.log("Message from thread 3 - ERROR", LogLevel.ERROR);
                try { Thread.sleep(100); } catch (InterruptedException e) { }
            }
        });

        // Запускаем потоки
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Чтение логов
        logger.readLogs();
        logger.close(); // Закрытие ресурса по завершению
    }
}
