import java.util.Scanner;
import java.util.UUID;

public class Main {

    private static SubscriptionManager subscriptionManager = new SubscriptionManager();

    public static void main(String[] args) {
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
                    cancelSubscription(scanner);-
                    break;
                case 0:
                    System.out.println("Exiting...");
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

        System.out.print("Enter Notification Frequency: ");
        String frequency = scanner.next();

        System.out.print("Enter Communication Channel: ");
        String channel = scanner.next();

        String subscriptionId = UUID.randomUUID().toString();
        WebsiteSubscription subscription = new WebsiteSubscription(subscriptionId, String.valueOf(user.getUserId()), websiteUrl, frequency, channel);
        subscriptionManager.registerSubscription(subscription);

        System.out.println("Subscription added successfully!");
        System.out.println("Subscription ID: " + subscriptionId);

    }


    private static void cancelSubscription(Scanner scanner) {
        System.out.print("Enter subscription ID to cancel: ");
        String subscriptionID = scanner.next();

        subscriptionManager.cancelSubscription(subscriptionID);
        System.out.println("Subscription cancelled successfully!");
    }

}