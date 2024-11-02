import java.text.SimpleDateFormat;
import java.util.Scanner;

public class BankTrans {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the first account
        System.out.println("Enter details for Account 1:");
        System.out.print("Account Number: ");
        String accountNumber1 = scanner.nextLine();
        System.out.print("Account Holder Name: ");
        String accountHolderName1 = scanner.nextLine();
        System.out.print("Initial Balance: ");
        double balance1 = scanner.nextDouble();
        scanner.nextLine(); // consume the leftover newline

        // Create the first account with user-provided details
        BankAccountn account1 = new BankAccountn(accountNumber1, accountHolderName1, balance1);

        // Taking input for the second account
        System.out.println("\nEnter details for Account 2:");
        System.out.print("Account Number: ");
        String accountNumber2 = scanner.nextLine();
        System.out.print("Account Holder Name: ");
        String accountHolderName2 = scanner.nextLine();
        System.out.print("Initial Balance: ");
        double balance2 = scanner.nextDouble();

        // Create the second account with user-provided details
        BankAccountn account2 = new BankAccountn(accountNumber2, accountHolderName2, balance2);

        System.out.println("\nBefore Transfer:");
        System.out.println("Account 1 Balance: " + account1.getBalance());
        System.out.println("Account 2 Balance: " + account2.getBalance());

        try {
            // Prompt user for transfer amount
            System.out.print("\nEnter amount to transfer from Account 1 to Account 2: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            String trcode = scanner.nextLine();

            // Perform the transfer
            Transaction transaction = BankUtils.transferFunds(account1, account2, amount, trcode);

            System.out.println("\nAfter Transfer:");
            System.out.println("Account 1 Balance: " + account1.getBalance());
            System.out.println("Account 2 Balance: " + account2.getBalance());

            // Display transaction details
            System.out.println("\nTransaction Details:");
            System.out.println("Transaction Code: " + transaction.getTransactionCode());
            System.out.println("Amount Transferred: " + transaction.getAmount());
            System.out.println("Timestamp: " + transaction.getTimestamp());

        } catch (InsufficientBalanceException e) {
            System.out.println("Transfer failed: " + e.getMessage());
        } finally {
            // Close the scanner
            scanner.close();
        }
    }
}

// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Transaction class to hold transaction details
class Transaction {
    private String transactionCode;
    private double amount;
    private String timestamp;

    public Transaction(String transactionCode, double amount, String timestamp) {
        this.transactionCode = transactionCode;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getTransactionCode() { return transactionCode; }
    public double getAmount() { return amount; }
    public String getTimestamp() { return timestamp; }
}

// Utility class for bank operations
class BankUtils {
    public static Transaction transferFunds(BankAccountn fromAccount, BankAccountn toAccount, double amount, String transactionCode) throws InsufficientBalanceException {
        // Check if the balance in fromAccount is sufficient
        if (fromAccount.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance in account " + fromAccount.getAccountNumber());
        }

        // Deduct from 'fromAccount' and add to 'toAccount'
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        // Record the transaction with a timestamp
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
        return new Transaction(transactionCode, amount, timestamp);
    }
}

// BankAccount class to represent a bank account
class BankAccountn {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccountn(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
