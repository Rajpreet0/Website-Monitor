package com.websiteMonitor.service;

import com.websiteMonitor.model.WebsiteSubscription;
import com.websiteMonitor.observer.Observer;
import com.websiteMonitor.observer.Subject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class WebsiteMonitor implements Subject {

    private List<WebsiteSubscription> subscriptions;
    private List<Observer> observers;
    private Timer timer;

    public WebsiteMonitor(List<WebsiteSubscription> subscriptions) {
        this.subscriptions = subscriptions;
        this.observers = new ArrayList<>();
    }

    public void startMonitoring() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                checkForUpdates();
            }
        }, 0, 10000);
    }

    public void stopMonitoring() {
        if (timer != null) {
            timer.cancel();
        }
    }

    public void addSubscription(WebsiteSubscription subscription) {
            subscriptions.add(subscription);
    }

    public void removeSubscription(String subscriptionId) {
            subscriptions.removeIf(sub -> sub.getSubscriptionId().equals(subscriptionId));
    }

    public void checkForUpdates() {
        for (WebsiteSubscription subscription : subscriptions) {
            try {
                Document doc = Jsoup.connect(subscription.getWebsiteUrl()).get();
                String currentContent = doc.text();

                if(!currentContent.equals(subscription.getLastFetchedContent())) {
                    subscription.setLastFetchedContent(currentContent);
                    notifyObserver("Website content has changed!", subscription.getWebsiteUrl());
                }

            } catch (IOException e) {
                System.out.println("Error fetching website content: " + e.getMessage());
            }
        }
    }


    @Override
    public void addObserver(Observer observer) {
            observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
            observers.remove(observer);
    }

    @Override
    public void notifyObserver(String message, String websiteUrl) {
            for (Observer observer : observers) {
                observer.update(message, websiteUrl);
            }
    }
}
