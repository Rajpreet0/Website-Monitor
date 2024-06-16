package com.websiteMonitor.model;

import com.websiteMonitor.strategy.ComparisonStrategy;

public class WebsiteSubscription {

    private String subscriptionId;
    private String userId;
    private String websiteUrl;
    private int notificationFrequency;
    private String communicationChannel;
    private String lastFetchedContent;
    private ComparisonStrategy comparisonStrategy;

    public WebsiteSubscription(String subscriptionId, String userId, String websiteUrl, int notificationFrequency, String communicationChannel, ComparisonStrategy comparisonStrategy) {
        this.subscriptionId = subscriptionId;
        this.userId = userId;
        this.websiteUrl = websiteUrl;
        this.notificationFrequency = notificationFrequency;
        this.communicationChannel = communicationChannel;
        this.lastFetchedContent = "";
        this.comparisonStrategy = comparisonStrategy;
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

    public String getLastFetchedContent() {
        return lastFetchedContent;
    }


    public int getNotificationFrequency() {
        return notificationFrequency;
    }


    public String getCommunicationChannel() {
        return communicationChannel;
    }

    public ComparisonStrategy getComparisonStrategy() {
        return comparisonStrategy;
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

    public void setLastFetchedContent(String lastFetchedContent) {
        this.lastFetchedContent = lastFetchedContent;
    }

    public void setNotificationFrequency(int notificationFrequency) {
        this.notificationFrequency = notificationFrequency;
    }

    public void setCommunicationChannel(String communicationChannel) {
        this.communicationChannel = communicationChannel;
    }

    public void setComparisonStrategy(ComparisonStrategy comparisonStrategy) {
        this.comparisonStrategy = comparisonStrategy;
    }

}
