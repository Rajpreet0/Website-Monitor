
public class WebsiteSubscription {

    private String subscriptionId;
    private String userId;
    private String websiteUrl;
    private String notificationFrequency;
    private String communicationChannel;

    public WebsiteSubscription(String subscriptionId, String userId, String websiteUrl, String notificationFrequency, String communicationChannel) {
        this.subscriptionId = subscriptionId;
        this.userId = userId;
        this.websiteUrl = websiteUrl;
        this.notificationFrequency = notificationFrequency;
        this.communicationChannel = communicationChannel;
    }

    // Getter methods
    public String getSubscriptionId() {
        return subscriptionId;
    }

    public String getUserId() {
        return userId;
    }


    public String getWebsiteUrl() {
        return websiteUrl;
    }


    public String getNotificationFrequency() {
        return notificationFrequency;
    }


    public String getCommunicationChannel() {
        return communicationChannel;
    }


    // Setter Methods
    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public void setNotificationFrequency(String notificationFrequency) {
        this.notificationFrequency = notificationFrequency;
    }

    public void setCommunicationChannel(String communicationChannel) {
        this.communicationChannel = communicationChannel;
    }


}
