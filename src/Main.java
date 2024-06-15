import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        terminalUI();
    }

    public static void terminalUI() {
        System.out.println("************************************************\n" +
                           "*                                              *\n" +
                           "*        Welcome to the Website Monitor        *\n" +
                           "*                                              *\n" +
                           "************************************************\n");


        System.out.println("\nPlease choose Register to start the Monitor");
        System.out.println("---------------------------------------------");

        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.println("\n(1) Subscribe to a Website");
            System.out.println("(2) Manage your Subscription");
            System.out.println("(3) Cancel a Subscription");
            System.out.println("(0) Exit");

            System.out.print("\nYour Value: ");
            int choosing = scanner.nextInt();

            switch (choosing) {
                case 1:
                    //TODO: Subscribe to a Website
                    System.out.println("TODO: Subscribe to a Website");
                    break;
                case 2:
                    //TODO: Manage a Subscription
                    System.out.println("TODO: Manage a Subscription");
                    break;
                case 3:
                    //TODO: Cancel a Subscription
                    System.out.println("TODO: Cancel a Subscription");
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
}