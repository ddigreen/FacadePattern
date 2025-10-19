// Subsystem: Notification
public class NotificationService {
    public void sendEmail(String to, String subject, String body) {
        System.out.println("[Email] To: " + to + " | " + subject + " | " + body);
    }
}
