public class WebShop {
    private int id;

    private double totalCardPayments;

    private double totalTransferPayments;

    public WebShop(int id) {
        this.id = id;
        this.totalCardPayments = 0;
        this.totalTransferPayments = 0;
    }

    public int getId() {
        return id;
    }

    public double getTotalCardPayments() {
        return totalCardPayments;
    }

    public double getTotalTransferPayments() {
        return totalTransferPayments;
    }

    public void addCardPayment(double amount) {
        totalCardPayments += amount;
    }

    public void addTransferPayment(double amount) {
        totalTransferPayments += amount;
    }

    public String toString() {
        return id + "," + totalCardPayments + "," + totalTransferPayments;
    }
}
