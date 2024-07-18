

import java.util.*;

class ATM {
    private String userId;
    private int userPin;
    private double balance;
    private List<String> transactions;

    public ATM(String userId, int userPin, double balance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public void login(String userId, int userPin) {
        if (this.userId.equals(userId) && this.userPin == userPin) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    public void showTransactions() {
        System.out.println("Transactions:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add("Withdrawn: " + amount);
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount);
        System.out.println("Deposit successful!");
    }

    public void transfer(double amount, String recipientUserId) {
        // Implement transfer logic
    }

    public void quit() {
        System.out.println("Goodbye!");
    }
}

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM("user123", 1234, 1000.0);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter user PIN: ");
        int userPin = scanner.nextInt();

        atm.login(userId, userPin);

        while (true) {
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    atm.showTransactions();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 4:
                    // Implement transfer logic
                    break;
                case 5:
                    atm.quit();
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}

