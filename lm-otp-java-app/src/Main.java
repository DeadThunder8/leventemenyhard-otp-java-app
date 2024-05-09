import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DataProcessor dataProcessor = new DataProcessor("./customers.csv", "./payments.csv");

        ArrayList<Customer> customers = dataProcessor.getCustomers();

        ArrayList<Payment> payments = dataProcessor.getPayments();

        for (Customer customer : customers) {
            customer.setPayments(payments);
        }

        Report.reportTotalPurchases(customers);
        Report.selectTop2("report01.csv");
        System.out.println(payments);
        Report.reportTotalIncome(payments, "report02.csv");
    }
}
