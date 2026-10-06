import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String type;
    private double amount;
    private double balanceAfter;
    private String timestamp;

    public Transaction(String type, double amount, double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.timestamp = dtf.format(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return String.format("[%s] %-10s | Amount: ₹%.2f | Balance: ₹%.2f", timestamp, type, amount, balanceAfter);
    }
}
