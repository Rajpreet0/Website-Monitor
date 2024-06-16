import java.util.List;

public class WebsiteMonitor {

    private List<WebsiteSubscription> subscriptions;


    public void addSubscription(WebsiteSubscription subscription) {
            subscriptions.add(subscription);
    }

    public void removeSubscription(String subscriptionId) {
            subscriptions.removeIf(sub -> sub.getSubscriptionId().equals(subscriptionId));
    }

    public void checkForUpdate() {

    }

    public void notifyUsers(String websiteUrl, String updateMessage) {
            for (WebsiteSubscription subscription : subscriptions) {
                if(subscription.getWebsiteUrl().equals(websiteUrl)) {
                    NotificationService notificationService = new NotificationService();
                    notificationService.sendNotification(subscription.getUserId(), updateMessage, subscription.getCommunicationChannel());
                }
            }
    }

}
