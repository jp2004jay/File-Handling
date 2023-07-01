import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InventoryReportGenerator {
    public static void main(String[] args) {
        File file = new File("inventory.txt");

        try {
            Scanner scanner = new Scanner(file);

            // Print report heading
            System.out.println("Inventory Report");
            System.out.println("----------------");
            System.out.printf("%-6s %-6s %-10s %-12s %-9s %-12s\n",
                    "Part", "Price", "Quantity", "Reorder", "Minimum", "Order");

            FileWriter writer = new FileWriter("inventory_report.txt");

            // Write report heading to file
            writer.write("Inventory Report\n");
            writer.write("----------------\n");
            writer.write(String.format("%-6s %-6s %-10s %-12s %-9s %-12s\n",
                    "Part", "Price", "Quantity", "Reorder", "Minimum", "Order"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\s+");

                String partNumber = String.format("%04d", Integer.parseInt(parts[0]));
                double price = Double.parseDouble(parts[1]);
                int quantity = Integer.parseInt(parts[2]);
                int reorderPoint = Integer.parseInt(parts[3]);
                int minimumOrder = Integer.parseInt(parts[4]);

                int orderAmount = 0;
                if (quantity < reorderPoint) {
                    orderAmount = reorderPoint + minimumOrder - quantity;
                }

                // Print inventory details
                System.out.printf("%-6s $%.2f \t %-10d %-12d %-9d %-12d\n",
                        partNumber, price, quantity, reorderPoint, minimumOrder, orderAmount);

                // Write inventory details to file
                writer.write(String.format("%-6s $%.2f \t %-10d %-12d %-9d %-12d\n",
                        partNumber, price, quantity, reorderPoint, minimumOrder, orderAmount));
            }

            scanner.close();
            writer.close();

            // Print end of report message
            System.out.println("----------------");
            System.out.println("End of Report");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the inventory file.");
            e.printStackTrace();
        }
    }
}
