public class NotificationService {

    public void sendNotification(String userId, String message, String communicationChannel) {
        if (communicationChannel.equals("email")) {
            // TODO: Send Email
        } else if(communicationChannel.equals("SMS")) {
            // TODO: Send SMS
        }
    }
}
