import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
        // Pre-seeded accounts for simulation
        accounts.put("user101", new Account("user101", "1234", 15000.0));
        accounts.put("user102", new Account("user102", "5678", 8500.0));
    }

    public Account authenticate(String accountId, String pin) {
        Account acc = accounts.get(accountId);
        if (acc != null && acc.validatePin(pin)) {
            return acc;
        }
        return null;
    }

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }
}
