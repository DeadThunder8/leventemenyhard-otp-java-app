import exceptions.DuplicateCustomerException;
import exceptions.EmptyStringException;
import exceptions.InvalidLineSizeException;
import exceptions.InvalidPaymentEntryException;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        try {
            File file = new File(paymentPath);
            Scanner scanner = new Scanner(file);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try {
                    String[] parts = line.split(",");
                    checkLength(parts, 7);
                    checkPaymentData(parts);
                    Payment payment = new Payment(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), PaymentType.valueOf(parts[2]), Double.parseDouble(parts[3]), parts[4], parts[5], LocalDate.parse(parts[6], formatter));
                    payments.add(payment);
                } catch (Exception e) {
                    Logger.log(line + "\n" + e.getMessage() + "\n");
                }
            }
            scanner.close();
        } catch (Exception e) {
            Logger.log("Unable to read payments.\n");
            Logger.log(e.getMessage() + "\n");
        }

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
                    String[] parts = line.split(",");
                    checkLength(parts, 4);
                    checkForEmptyString(parts);
                    Customer customer = new Customer(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[2], parts[3]);
                    checkForExistingCustomer(customer, customers);
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

    public void checkForExistingCustomer(Customer newCustomer, ArrayList<Customer> customers) throws DuplicateCustomerException {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == newCustomer.getCustomerId() && customer.getWebshopId() == newCustomer.getWebshopId()) {
                throw new DuplicateCustomerException("Customer already exists: " + newCustomer);
            }
        }
    }

    private void checkLength(String[] parts, int expectedLength) throws InvalidLineSizeException {
        if (parts.length != expectedLength) {
            throw new InvalidLineSizeException("Data entry size is not " + expectedLength + ". Read size: " + parts.length);
        }
    }

    private void checkForEmptyString(String[] parts) throws EmptyStringException {
        for (String part : parts) {
            if (part.isEmpty()) {
                throw new EmptyStringException("Empty string found in data entry.");
            }
        }
    }

    public void checkPaymentData(String[] parts) throws InvalidPaymentEntryException {
        if(parts[0].isEmpty() || parts[1].isEmpty() || parts[2].isEmpty() || parts[3].isEmpty() || parts[6].isEmpty()) {
            throw new InvalidPaymentEntryException("Empty string found in payment data entry.");
        }
        if (parts[2].equals("card") && parts[5].isEmpty()) {
            throw new InvalidPaymentEntryException("Card number is missing for payment type CARD.");
        }
        if (parts[2].equals("transfer") && parts[4].isEmpty()) {
            throw new InvalidPaymentEntryException("Account number is missing for payment type TRANSFER.");
        }
    }
}
