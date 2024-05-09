import java.time.LocalDate;

public class Payment {
    private int webshopId;
    private int customerId;
    private PaymentType paymentType;
    private double amount;
    private String accountNumber;
    private String cardNumber;
    private LocalDate paymentDate;

    public Payment(int webshopId, int customerId, PaymentType paymentType, double amount, String accountNumber, String cardNumber, LocalDate paymentDate) {
        this.webshopId = webshopId;
        this.customerId = customerId;
        this.paymentType = paymentType;
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.paymentDate = paymentDate;
    }

    public String toString() {
        return "WebShop ID: " + webshopId + ", Customer ID: " + customerId + ", Payment Type: " + paymentType + ", Amount: " + amount + ", Account Number: " + accountNumber + ", Card Number: " + cardNumber + ", Payment Date: " + paymentDate;
    }

    public int getWebshopId() {
        return webshopId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentType getType() {
        return paymentType;
    }
}
