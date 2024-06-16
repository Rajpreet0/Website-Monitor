package com.websiteMonitor.service;

import com.websiteMonitor.observer.Observer;

public class NotificationService implements Observer {

    @Override
    public void update(String message, String websiteUrl) {
        System.out.println("Console Notification for Website: " + websiteUrl + " - " + message);
    }

    public void sendNotification(String userId, String message, String communicationChannel, String websiteUrl) {
        if (communicationChannel.equals("Email")) {
            // TODO: Send Email
        } else if(communicationChannel.equalsIgnoreCase("console")) {
            System.out.println("Console Notification for com.websiteMonitor.model.User ID: " + userId + " , for Website: " + websiteUrl + " - " + message );
        }
    }
}
