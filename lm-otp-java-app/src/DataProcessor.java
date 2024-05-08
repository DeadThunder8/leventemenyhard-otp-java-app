import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DataProcessor {
    private String customerPath;
    private String paymentPath;

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

        try {
            File file = new File(customerPath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try {

                    String[] parts = line.split(", ");
                    if (parts.length != 4) {
                        throw new InvalidLineSizeException("Data entry size is not 4. Read size: " + parts.length);
                    }
                    Customer customer = new Customer(parts[0], parts[1], parts[2], parts[3]);
                    if (checkForExisting(customer, customers)) {
                        throw new DuplicateCustomerException("Customer already exists: " + customer);
                    }
                    customers.add(customer);
                } catch (Exception e) {
                    Logger.log(line + "\n" + e.getMessage() + "\n");
                }

            }
            scanner.close();
        } catch (Exception e) {
            Logger.log("Unable to read customers.\n");
            Logger.log(e.getMessage() + "\n");
        }

        return customers;
    }

    public boolean checkForExisting(Customer newCustomer, ArrayList<Customer> customers) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(newCustomer.getCustomerId()) && customer.getWebshopId().equals(newCustomer.getWebshopId())) {
                return true;
            }
        }
        return false;
    }
}
