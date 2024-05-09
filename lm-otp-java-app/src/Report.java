import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Report {

    public static void reportTotalPurchases(ArrayList<Customer> customers) {

        File file = new File("report01.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (Customer customer : customers) {
                fileWriter.write(customer.getName() + "," + customer.getAddress() + "," + customer.getTotalPurchases()+"\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            Logger.log("Unable to write report.\n");
            Logger.log(e.getMessage() + "\n");
        }
    }

    public static void selectTop2 (String path) {
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            ArrayList<String> lines = new ArrayList<>();

            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();

            if (lines.size() < 2) {
                Logger.log("Not enough data to select top 2.\n");
                return;
            }

            lines.sort((a, b) -> {
                String[] partsA = a.split(",");
                String[] partsB = b.split(",");
                return Double.compare(Double.parseDouble(partsB[2]), Double.parseDouble(partsA[2]));
            });

            File file2 = new File("top.csv");
            FileWriter fileWriter = new FileWriter(file2);
            for (int i = 0; i < 2; i++) {
                fileWriter.write(lines.get(i) + "\n");
            }
            fileWriter.close();

        } catch (Exception e) {
            Logger.log("Unable to select top 2.\n");
            Logger.log(e.getMessage() + "\n");
        }
    }

    public static void reportTotalIncome(ArrayList<Payment> payments, String path) {

        ArrayList<WebShop> webshops = new ArrayList<>();

        for (Payment payment : payments) {
            if (!chekIfWebshopExists(payment.getWebshopId(), webshops)) {
                webshops.add(new WebShop(payment.getWebshopId()));
            }
        }

        for (Payment payment : payments) {
            for (WebShop shop : webshops) {
                if (shop.getId() == payment.getWebshopId()) {
                    if (payment.getType() == PaymentType.card) {
                        shop.addCardPayment(payment.getAmount());
                    } else {
                        shop.addTransferPayment(payment.getAmount());
                    }
                }
                System.out.println(shop.toString());
            }
        }

        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            for (WebShop shop : webshops) {
                fileWriter.write(shop.toString() + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            Logger.log("Unable to write report.\n");
            Logger.log(e.getMessage() + "\n");
        }

    }

    private static boolean chekIfWebshopExists(int id, ArrayList<WebShop> webshops)  {
        for (WebShop shop : webshops) {
            if (shop.getId() == id) {
                return true;
            }
        }
        return false;
    }


}
