import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DataProcessor {
    private String customerPath;
    private String paymentPath;
    private Scanner scanner;
    private File actFile;

    public DataProcessor(String customerPath, String paymentPath) {
        this.customerPath = customerPath;
        this.paymentPath = paymentPath;
    }

    public ArrayList<Payment> getPayments() {
        ArrayList<Payment> payments = new ArrayList<>();

        return payments;
    }

    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();

        return customers;
    }

    private void openFile(String filePath) {
        try {
            actFile = new File(filePath);
            scanner = new Scanner(actFile);
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
}
