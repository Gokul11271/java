import java.util.Scanner;

class User {
    String username;
    int pin;
    double balance;

    public User(String username, int pin, double balance) {
        this.username = username;
        this.pin = pin;
        this.balance = balance;
    }
}

public class MultiuserATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Create multiple users
        User[] users = {
            new User("user1", 1234, 1500),
            new User("user2", 2345, 2000),
            new User("user3", 3456, 12000)
        };

        User currentUser = null;
        boolean loggedIn = false;

        System.out.println("=== Welcome to Java ATM ===");

        // Step 2: Login with max 3 attempts
        for (int attempts = 3; attempts > 0; attempts--) {
            System.out.print("Enter username: ");
            String enteredUsername = sc.next();

            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();

            for (User user : users) {
                if (user.username.equals(enteredUsername) && user.pin == enteredPin) {
                    currentUser = user;
                    loggedIn = true;
                    break;
                }
            }

            if (loggedIn) {
                System.out.println("Login successful! Welcome, " + currentUser.username);
                break;
            } else {
                System.out.println("Invalid credentials. Attempts left: " + (attempts - 1));
            }
        }

        if (!loggedIn) {
            System.out.println("Too many failed attempts. Exiting...");
            sc.close();
            return;
        }

        // Step 3: ATM Menu
        int choice;
        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Withdraw Cash");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance: ₹" + currentUser.balance);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double deposit = sc.nextDouble();
                    if (deposit > 0) {
                        currentUser.balance += deposit;
                        System.out.println("Deposited: ₹" + deposit);
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdraw = sc.nextDouble();
                    if (withdraw > 0 && withdraw <= currentUser.balance) {
                        currentUser.balance -= withdraw;
                        System.out.println("Please collect your cash.");
                    } else {
                        System.out.println("Invalid or insufficient balance.");
                    }
                    break;
                case 4:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
