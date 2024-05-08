import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Test logging feature
        Logger.log("I can log anything");

        DataProcessor dataProcessor = new DataProcessor("./customers.csv", "./payments.csv");

        ArrayList<Customer> customers = dataProcessor.getCustomers();

        ArrayList<Payment> payments = dataProcessor.getPayments();

        for (Customer customer : customers) {
            System.out.println(customer);
        }

        for (Payment payment : payments) {
            System.out.println(payment);
        }

    }
}
