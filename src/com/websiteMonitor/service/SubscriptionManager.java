package com.websiteMonitor.service;

import com.websiteMonitor.model.WebsiteSubscription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubscriptionManager {

    private Map<String, WebsiteSubscription> subscriptions = new HashMap<>();


    public void registerSubscription(WebsiteSubscription subscription) {
            subscriptions.put(subscription.getSubscriptionId(), subscription);
    }

    public void modifySubscription(String subscriptionId, int newFrequency, String newChannel) {
            WebsiteSubscription subscription = subscriptions.get(subscriptionId);
            if (subscription != null) {
                subscription.setNotificationFrequency(newFrequency);
                subscription.setCommunicationChannel(newChannel);
            }
    }

    public void cancelSubscription(String subscriptionId) {
            subscriptions.remove(subscriptionId);
    }

    public List<WebsiteSubscription> getUserSubscription(String userId) {
        List<WebsiteSubscription> userSubscriptions = new ArrayList<>();
        for (WebsiteSubscription subscription : subscriptions.values()) {
            if(subscription.getUserId().equals(userId)) {
                userSubscriptions.add(subscription);
            }
        }

        return userSubscriptions;
    }

}
