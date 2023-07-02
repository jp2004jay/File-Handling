/*
 * Create an inventory file using the data shown below:
Part no Price Quantity  Reorder point   Minimum order
0123    1.23    23          20              20
0234    2.34    34          50              25
3456    34.56   56          50              10
4567    45.67   7           10              5
5678    6.78    75          75              25
 * Write a program to read the inventory file and create an inventory report. 
 * The report will contain the part number, price, quantity on hand, reorder point, 
   minimum order and order amount. 
 * The order amount is calculated when the quantity on hand falls below the reorder point. 
 * It is calculated as the sum of reorder point and the minimum order less the quantity on hand. 
 * Provide a report heading such as “inventory report” captions for each column 
   and an “end of report” message at the end of report. 
 * Print the part number with leading zeroes.
*/

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
