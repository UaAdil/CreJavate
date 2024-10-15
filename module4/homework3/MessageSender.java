package Modules.module4.homework3;

import java.util.List;

public interface MessageSender {
    void sendMessage(String message);
}

class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Email sent: " + message);
    }
}

class SmsSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS sent: " + message);
    }
}

class NotificationService {
    private final List<MessageSender> messageSenders;
    public NotificationService(List<MessageSender> messageSenders) {
        this.messageSenders = messageSenders;
    }
    public void sendNotification(String message) {
        for (MessageSender sender : messageSenders) {
            sender.sendMessage(message);
        }
    }
}

class MessengerSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Message sent via Messenger: " + message);
    }
}


