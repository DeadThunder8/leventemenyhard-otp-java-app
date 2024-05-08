public class Customer {
    private String webshopId;
    private String customerId;
    private String customerName;
    private String customerAddress;

    public Customer(String webshopId, String customerId, String customerName, String customerAddress) {
        this.webshopId = webshopId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }

    public String toString() {
        return "Customer ID: " + customerId + ", WebShop ID: " + webshopId + ", Name: " + customerName + ", Address: " + customerAddress;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getWebshopId() {
        return webshopId;
    }




}
