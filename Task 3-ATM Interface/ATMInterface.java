import java.util.Scanner;


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
}


class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void start() {
        int option;
        do {
            displayMenu();
            System.out.print("Select an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    handleWithdraw();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleCheckBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (option != 4);
    }

    private void displayMenu() {
        System.out.println("\n==== ATM MENU ====");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
        } else {
            System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
        }
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) {
            System.out.println("Deposit successful. New balance: $" + account.getBalance());
        } else {
            System.out.println("Deposit failed. Please enter a valid amount.");
        }
    }

    private void handleCheckBalance() {
        System.out.println("Current balance: $" + account.getBalance());
    }
}


public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(10000.00); // Initial balance
        ATM atmMachine = new ATM(userAccount);
        atmMachine.start();
    }
}
