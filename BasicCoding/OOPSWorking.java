
public class OOPSWorking {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.0);
        account.deposit(100.0);

        System.out.println("Current balance: " + account.getBalance());

        PaymentMethod PM = new CreditCardPayment("TNX1", "437-298-287");

        PM.processPayment(300);
    }
}

//  Abstract class
abstract class PaymentMethod {
//  Encapsulated field

    private String transactionId;

    public PaymentMethod(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    // Abstract Method
    public abstract void processPayment(double amount);
}

class CreditCardPayment extends PaymentMethod {

    private String cardNumber;

    public CreditCardPayment(String transactionId, String cardNumber) {
        super(transactionId);
        this.cardNumber = cardNumber;
    }

    public void processPayment(double amount) {
        System.out.println("Processed Amt: " + amount + " transactionID: " + getTransactionId());
    }
}

//  Encapsulation Class
class BankAccount {

    private double balance;

    public BankAccount(double initBalance) {
        if (initBalance >= 0) {
            this.balance = initBalance;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        }
    }
}
