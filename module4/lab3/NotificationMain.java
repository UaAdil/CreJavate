package Modules.module4.lab3;

interface INotificationService {
    void send(String message);
}

class EmailService implements INotificationService {
    @Override
    public void send(String message) {
        System.out.println("Отправка Email: " + message);
    }
}

class SMSService implements INotificationService {
    @Override
    public void send(String message) {
        System.out.println("Отправка SMS: " + message);
    }
}

class Notification {
    private INotificationService _notificationService;

    public Notification(INotificationService notificationService) {
        _notificationService = notificationService;
    }

    public void send(String message) {
        _notificationService.send(message);
    }
}

public class NotificationMain {
    public static void main(String[] args) {
        INotificationService emailService = new EmailService();
        Notification emailNotification = new Notification(emailService);
        emailNotification.send("Hello, This is testing notification in Email.");

        INotificationService smsService = new SMSService();
        Notification smsNotification = new Notification(smsService);
        smsNotification.send("Hello, This is testing notification in SMS.");
    }
}
