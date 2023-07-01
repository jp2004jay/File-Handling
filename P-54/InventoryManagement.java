import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    String itemName;
    double pricePerUnit;
    int quantity;
    String dateReceived;
    String supplier;
    int count;

    public Product(String itemName, double pricePerUnit, int quantity, String dateReceived, String supplier,
            int count) {
        this.itemName = itemName;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
        this.dateReceived = dateReceived;
        this.supplier = supplier;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Item Name: " + itemName + ", Price per Unit: $" + pricePerUnit + ", Quantity: " + quantity
                + ", Date Received: " + dateReceived + ", Supplier: " + supplier + ", Count: " + count;
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = readInventoryFile();
        List<Product> restockList = new ArrayList<>();

        System.out.println("Welcome to the Inventory Management System!");
        System.out.println("--------------------------------------------");

        boolean continueShopping = true;
        double totalCost = 0;

        while (continueShopping) {
            System.out.print("Enter the item name to purchase (or 'done' to finish shopping): ");
            String itemName = scanner.nextLine();

            if (itemName.equalsIgnoreCase("done")) {
                continueShopping = false;
            } else {
                Product product = findProduct(itemName, products);
                if (product != null) {
                    System.out.print("Enter the quantity to purchase: ");
                    int quantityToPurchase = scanner.nextInt();
                    scanner.nextLine();

                    if (quantityToPurchase <= product.count) {
                        double itemCost = quantityToPurchase * product.pricePerUnit;
                        totalCost += itemCost;

                        // Update the count for the purchased item
                        product.count -= quantityToPurchase;

                        System.out.println("Purchased " + quantityToPurchase + " units of " + itemName + " for $"
                                + itemCost + ".");
                    } else {
                        System.out.println("Insufficient quantity in stock for " + itemName + ".");
                    }
                } else {
                    System.out.println("Item " + itemName + " not found in stock.");
                }
            }
        }

        System.out.println("--------------------------------------------");
        System.out.println("Total cost: $" + totalCost);
        System.out.println("--------------------------------------------");

        System.out.println("Items to be restocked:");
        for (Product product : products) {
            if (product.count < product.quantity) {
                restockList.add(product);
            }
        }

        if (restockList.isEmpty()) {
            System.out.println("No items need to be restocked.");
        } else {
            for (Product product : restockList) {
                System.out.println(product);
            }
        }

        updateInventoryFile(products);

        scanner.close();
    }

    private static List<Product> readInventoryFile() {
        List<Product> products = new ArrayList<>();

        try {
            File file = new File("inventory.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                String itemName = parts[0];
                double pricePerUnit = Double.parseDouble(parts[1]);
                int quantity = Integer.parseInt(parts[2]);
                String dateReceived = parts[3];
                String supplier = parts[4];
                int count = Integer.parseInt(parts[5]);

                Product product = new Product(itemName, pricePerUnit, quantity, dateReceived, supplier, count);
                products.add(product);
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the inventory file.");
            e.printStackTrace();
        }

        return products;
    }

    private static Product findProduct(String itemName, List<Product> products) {
        for (Product product : products) {
            if (product.itemName.equalsIgnoreCase(itemName)) {
                return product;
            }
        }
        return null;
    }

    private static void updateInventoryFile(List<Product> products) {
        try {
            FileWriter writer = new FileWriter("inventory.txt");
            for (Product product : products) {
                writer.write(
                        product.itemName + "," + product.pricePerUnit + "," + product.quantity + "," + product.dateReceived
                                + "," + product.supplier + "," + product.count + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while updating the inventory file.");
            e.printStackTrace();
        }
    }
}
