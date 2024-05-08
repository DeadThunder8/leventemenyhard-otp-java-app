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

    public int getWebshopId() {
        return webshopId;
    }

    public int getCustomerId() {
        return customerId;
    }
}
