import java.util.List;
import java.util.Scanner;

public class ATM {
    private Bank bank;
    private Scanner scanner;

    public ATM(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("==========================================");
        System.out.println("         WELCOME TO OASIS ATM SYSTEM      ");
        System.out.println("==========================================");

        int attempts = 0;
        Account currentAccount = null;

        while (attempts < 3) {
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine().trim();
            System.out.print("Enter 4-Digit PIN: ");
            String pin = scanner.nextLine().trim();

            currentAccount = bank.authenticate(userId, pin);
            if (currentAccount != null) {
                System.out.println("\nLogin Successful! Welcome, " + userId);
                break;
            } else {
                attempts++;
                System.out.println("Invalid User ID or PIN. Attempts remaining: " + (3 - attempts));
            }
        }

        if (currentAccount == null) {
            System.out.println("\nAccess Denied. Account locked after 3 failed attempts.");
            return;
        }

        boolean active = true;
        while (active) {
            System.out.println("\n---------------- MAIN MENU ----------------");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Quit");
            System.out.print("Choose an option (1-6): ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    showHistory(currentAccount);
                    break;
                case "2":
                    handleWithdrawal(currentAccount);
                    break;
                case "3":
                    handleDeposit(currentAccount);
                    break;
                case "4":
                    handleTransfer(currentAccount);
                    break;
                case "5":
                    System.out.printf("Current Balance: ₹%.2f\n", currentAccount.getBalance());
                    break;
                case "6":
                    System.out.println("\nThank you for banking with us. Goodbye!");
                    active = false;
                    break;
                default:
                    System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private void showHistory(Account account) {
        List<Transaction> history = account.getTransactionHistory();
        System.out.println("\n--- Transaction History ---");
        if (history.isEmpty()) {
            System.out.println("No transactions in this session.");
        } else {
            for (Transaction tx : history) {
                System.out.println(tx);
            }
        }
    }

    private void handleWithdrawal(Account account) {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = Double.parseDouble(scanner.nextLine().trim());
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        if (account.withdraw(amount)) {
            System.out.printf("Withdrawal successful. Current Balance: ₹%.2f\n", account.getBalance());
        } else {
            System.out.println("Error: Insufficient Funds!");
        }
    }

    private void handleDeposit(Account account) {
        System.out.print("Enter amount to deposit: ₹");
        double amount = Double.parseDouble(scanner.nextLine().trim());
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        account.deposit(amount);
        System.out.printf("Deposit successful. Current Balance: ₹%.2f\n", account.getBalance());
    }

    private void handleTransfer(Account account) {
        System.out.print("Enter Recipient User ID: ");
        String recipientId = scanner.nextLine().trim();
        Account recipient = bank.getAccount(recipientId);

        if (recipient == null) {
            System.out.println("Recipient account not found.");
            return;
        }
        if (recipient.getAccountId().equals(account.getAccountId())) {
            System.out.println("Cannot transfer funds to your own account.");
            return;
        }

        System.out.print("Enter transfer amount: ₹");
        double amount = Double.parseDouble(scanner.nextLine().trim());
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (account.transfer(recipient, amount)) {
            System.out.printf("Transferred ₹%.2f successfully to %s.\n", amount, recipientId);
            System.out.printf("Current Balance: ₹%.2f\n", account.getBalance());
        } else {
            System.out.println("Error: Insufficient Funds!");
        }
    }
}
