package Modules.module4.homework3;

import java.util.ArrayList;
import java.util.List;

public class NotificationSystem {
    public static void main(String[] args) {
        List<MessageSender> senders = new ArrayList<>();
        senders.add(new EmailSender());
        senders.add(new SmsSender());
        senders.add(new MessengerSender());

        NotificationService notificationService = new NotificationService(senders);
        notificationService.sendNotification("This is a test message. Yeah)");
    }
}
