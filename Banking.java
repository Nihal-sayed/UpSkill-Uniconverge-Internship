import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String name;
    private String accountNumber;
    private double balance;

    public User(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void transfer(User receiver, double amount) {
        if (withdraw(amount)) {
            receiver.deposit(amount);
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Insufficient funds!");
        }
    }
}

class Bank {
    private List<User> users;

    public Bank() {
        this.users = new ArrayList<>();
    }

    public void registerUser(String name) {
        String accountNumber = generateAccountNumber();
        User user = new User(name, accountNumber);
        users.add(user);
        System.out.println("Registration successful! Your account number is: " + accountNumber);
    }

    private String generateAccountNumber() {
        int accountNumber = users.size() + 1;
        return String.format("%06d", accountNumber);
    }

    public User login(String accountNumber) {
        for (User user : users) {
            if (user.getAccountNumber().equals(accountNumber)) {
                return user;
            }
        }
        return null;
    }
}

public class BankingSystemPrototype {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        User currentUser = null;

        while (!exit) {
            System.out.println("==== Banking Information System ====");
            System.out.println("1. Register User");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    bank.registerUser(name);
                    break;

                case 2:
                    System.out.print("Enter your account number: ");
                    String accountNumber = scanner.nextLine();
                    currentUser = bank.login(accountNumber);
                    if (currentUser != null) {
                        System.out.println("Welcome, " + currentUser.getName() + "!");
                        performBankingOperations(currentUser, scanner);
                    } else {
                        System.out.println("Invalid account number!");
                    }
                    break;

                case 3:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }

    public static void performBankingOperations(User user, Scanner scanner) {
        boolean logout = false;

        while (!logout) {
            System.out.println("\n==== Banking Operations ====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Fund Transfer");
            System.out.println("4. Account Statement");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    user.deposit(depositAmount);
                    System.out.println("Deposit successful! Current balance: " + user.getBalance());
                    break;

                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (user.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful! Current balance: " + user.getBalance());
                    } else {
                        System.out.println("Insufficient funds!");
                    }
                    break;

                case 3:
                    System.out.print("Enter the account number of the receiver: ");
                    String receiverAccountNumber = scanner.nextLine();
                    User receiver = bank.login(receiverAccountNumber);
                    if (receiver != null) {
                        System.out.print("Enter the amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        user.transfer(receiver, transferAmount);
                    } else {
                        System.out.println("Invalid receiver account number!");
                    }
                    break;

                case 4:
                    System.out.println("Account Statement");
                    System.out.println("Account Number: " + user.getAccountNumber());
                    System.out.println("Name: " + user.getName());
                    System.out.println("Balance: " + user.getBalance());
                    break;

                case 5:
                    logout = true;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
