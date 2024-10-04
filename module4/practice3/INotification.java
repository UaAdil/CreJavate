package Modules.module4.practice3;

public interface INotification {
    void sendNotification(String message);
}

class EmailNotification implements INotification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Отправка уведомления по Email: " + message);
    }
}

class SmsNotification implements INotification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Отправка уведомления по SMS: " + message);
    }
}
