import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Money Deposited: " + amount);
        } else {
            System.out.println("Invalid amount for deposit!");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Money Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount for withdrawal!");
        }
    }
}

class User {
    private String userId;
    private String pin;

    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }
}

class Authentication {
   
    private static final User[] users = {
        new User("user1", "1234"),
        new User("user2", "5678"),
      
    };

    public static User authenticate(String userId, String pin) {
        for (User user : users) {
            if (user.getUserId().equals(userId) && user.getPin().equals(pin)) {
                return user; 
            }
        }
        return null;
    }
}

class Account {
    private BankAccount bankAccount;

    public Account(double initialBalance) {
        bankAccount = new BankAccount(initialBalance);
    }

    public double getBalance() {
        return bankAccount.getBalance();
    }

    public void deposit(double amount) {
        bankAccount.deposit(amount);
    }

    public void withdraw(double amount) {
        bankAccount.withdraw(amount);
    }
}

class ATMOperations {
    private Account userAccount;
    private Scanner scanner;

    public ATMOperations(Account account) {
        this.userAccount = account;
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("******** WELCOME TO ATM ********");
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Cash");
        System.out.println("3. Withdraw Cash");
        System.out.println("4. Exit");
    }

    public void start() {
        int choice;
        do {
            showMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank You!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option!");
            }
        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.println("Current Balance: " + userAccount.getBalance());
    }

    private void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        userAccount.withdraw(amount);
    }
}

public class Task{
    public static void main(String[] args) {
        try (Scanner inputScanner = new Scanner(System.in)) {
            System.out.print("Enter User ID: ");
            String userId = inputScanner.nextLine();
            System.out.print("Enter PIN: ");
            String pin = inputScanner.nextLine();
            
            User authenticatedUser = Authentication.authenticate(userId, pin);
            if (authenticatedUser != null) {
                Account userAccount = new Account(1000); 
                
                ATMOperations atm = new ATMOperations(userAccount);
                atm.start();
            } else {
                System.out.println("Authentication failed. Exiting...");
            }
        }
    }
}
