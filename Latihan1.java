interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Mengirim Email: " + message);
    }
}

class SMSNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Mengirim SMS: " + message);
    }
}

class WhatsAppNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Mengirim WhatsApp: " + message);
    }
}

class TelegramNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Mengirim Telegram: " + message);
    }
}

class PushNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Mengirim Push Notification: " + message);
    }
}

class NotificationService {
    private final Notifier notifier;

    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void notify(String message) {
        notifier.send(message);
    }
}

public class Latihan1 {
    public static void main(String[] args) {
        NotificationService emailService =
                new NotificationService(new EmailNotifier());
        NotificationService smsService =
                new NotificationService(new SMSNotifier());
        NotificationService whatsAppService =
                new NotificationService(new WhatsAppNotifier());
        NotificationService telegramService =
                new NotificationService(new TelegramNotifier());
        NotificationService pushService =
                new NotificationService(new PushNotifier());

        emailService.notify("Halo, ini email test!");
        smsService.notify("Ini SMS test!");
        whatsAppService.notify("Ini pesan WhatsApp test!");
        telegramService.notify("Ini Telegram test!");
        pushService.notify("Ini Push Notification test!");
    }
}