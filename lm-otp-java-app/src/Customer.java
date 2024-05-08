import java.util.ArrayList;

public class Customer {
    private int webshopId;
    private int customerId;
    private String customerName;
    private String customerAddress;

    private ArrayList<Payment> payments;

    public Customer(int webshopId, int customerId, String customerName, String customerAddress) {
        this.webshopId = webshopId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.payments = new ArrayList<>();
    }

    public String toString() {
        return "Customer ID: " + customerId + ", WebShop ID: " + webshopId + ", Name: " + customerName + ", Address: " + customerAddress;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getWebshopId() {
        return webshopId;
    }

    public String getName() {
        return customerName;
    }

    public String getAddress() {
        return customerAddress;
    }

    public void setPayments(ArrayList<Payment> payments) {
        for (Payment payment : payments) {
            if (payment.getCustomerId() == customerId && payment.getWebshopId() == webshopId) {
                this.payments.add(payment);
            }
        }
    }

    public double getTotalPurchases() {
        double total = 0;
        for (Payment payment : payments) {
            total += payment.getAmount();
        }
        return total;
    }




}
