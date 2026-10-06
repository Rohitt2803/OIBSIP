import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountId;
    private String pin;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String accountId, String pin, double initialBalance) {
        this.accountId = accountId;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public boolean validatePin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount, balance));
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        transactionHistory.add(new Transaction("Withdrawal", amount, balance));
        return true;
    }

    public boolean transfer(Account recipient, double amount) {
        if (amount > balance) {
            return false;
        }
        this.balance -= amount;
        this.transactionHistory.add(new Transaction("Transfer To " + recipient.getAccountId(), amount, this.balance));
        recipient.balance += amount;
        recipient.transactionHistory.add(new Transaction("Transfer From " + this.accountId, amount, recipient.balance));
        return true;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
