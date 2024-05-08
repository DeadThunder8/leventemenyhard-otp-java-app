import java.time.LocalDate;

public class Payment {
    private String webshopId;
    private String customerId;
    private PaymentType paymentType;
    private double amount;
    private String accountNumber;
    private String cardNumber;
    private LocalDate paymentDate;

    public Payment(String webshopId, String customerId, PaymentType paymentType, double amount, String accountNumber, String cardNumber, LocalDate paymentDate) {
        this.webshopId = webshopId;
        this.customerId = customerId;
        this.paymentType = paymentType;
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.paymentDate = paymentDate;
    }
}
