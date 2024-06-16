package com.websiteMonitor.main;

import com.websiteMonitor.model.User;
import com.websiteMonitor.model.WebsiteSubscription;
import com.websiteMonitor.service.NotificationService;
import com.websiteMonitor.service.SubscriptionManager;
import com.websiteMonitor.service.WebsiteMonitor;
import com.websiteMonitor.strategy.ComparisonStrategy;
import com.websiteMonitor.strategy.ContentSizeStrategy;
import com.websiteMonitor.strategy.HtmlContentStrategy;
import com.websiteMonitor.strategy.TextContentStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    private static SubscriptionManager subscriptionManager = new SubscriptionManager();
    private static List<WebsiteSubscription> subscriptions = new ArrayList<>();
    private static WebsiteMonitor monitor;
    private static NotificationService notificationService = new NotificationService();

    public static void main(String[] args) {
        monitor = new WebsiteMonitor(subscriptions);
        monitor.addObserver(notificationService);
        monitor.startMonitoring();
        terminalUI();
    }

    public static void terminalUI() {
        System.out.println("************************************************\n" +
                           "*                                              *\n" +
                           "*        Welcome to the Website Monitor        *\n" +
                           "*                                              *\n" +
                           "************************************************\n");


        Scanner scanner = new Scanner(System.in);

        System.out.println("**************** LOGIN ****************");
        System.out.println("---------------------------------------------");

        System.out.print("Your name: ");
        String username = scanner.next();

        System.out.print("Your email: ");
        String email = scanner.next();


        User user = new User(1, username, email);

        System.out.println("UserID: " + user.getUserId() + " ,Username: " + user.getName() + " ,Email: " + user.getEmail());

        while(true) {

            System.out.println("\n(1) Subscribe to a Website");
            System.out.println("(2) Manage your Subscription");
            System.out.println("(3) Cancel a Subscription");
            System.out.println("(0) Exit");

            System.out.print("\nYour Value: ");
            int choosing = scanner.nextInt();

            switch (choosing) {
                case 1:
                    subscribeToWebsite(scanner, user);
                    break;
                case 2:
                    //TODO: Manage a Subscription
                    System.out.println("TODO: Manage a Subscription");
                    break;
                case 3:
                    cancelSubscription(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    monitor.stopMonitoring();
                    return;
                default:
                    System.out.println("Please only enter a valid Number");
                    break;
            }

        }
    }

    public static void subscribeToWebsite(Scanner scanner, User user) {
        System.out.print("Enter a Website URL: ");
        String websiteUrl = scanner.next();

        System.out.print("Enter Notification Frequency (in sec): ");
        int frequency = scanner.nextInt();

        System.out.println("Choose Comparison Strategy:");
        System.out.println("(1) Identical Content Size");
        System.out.println("(2) Identical HTML Content");
        System.out.println("(3) Identical Text Content");
        System.out.print("Your Value: ");
        int strategyChoice = scanner.nextInt();
        ComparisonStrategy strategy;

        switch (strategyChoice) {
            case 1:
                strategy = new ContentSizeStrategy();
                break;
            case 2:
                strategy = new HtmlContentStrategy();
                break;
            case 3:
                strategy = new TextContentStrategy();
                break;
            default:
                System.out.println("Invalid choice, using default (Identical Text Content).");
                strategy = new TextContentStrategy();
                break;
        }

        System.out.print("Enter Communication Channel: ");
        String channel = scanner.next();

        String subscriptionId = UUID.randomUUID().toString();
        WebsiteSubscription subscription = new WebsiteSubscription(subscriptionId, String.valueOf(user.getUserId()), websiteUrl, frequency, channel, strategy);
        subscriptionManager.registerSubscription(subscription);
        subscriptions.add(subscription);

        System.out.println("Subscription added successfully!");
        System.out.println("Subscription ID: " + subscriptionId);

    }


    private static void cancelSubscription(Scanner scanner) {
        System.out.print("Enter subscription ID to cancel: ");
        String subscriptionID = scanner.next();

        subscriptionManager.cancelSubscription(subscriptionID);
        subscriptions.removeIf(sub -> sub.getSubscriptionId().equals(subscriptionID));
        System.out.println("Subscription cancelled successfully!");
    }

}