/*
 * Write a program that uses the inventory file produced in above program. 
 * The user present the program with a shopping list of items to be purchased. 
 * The program inputs the stored inventory file and then it decrements the 
   count for each item on the shopping list and charges the customer appropriately. 
 * The program must check for the presence of the item and for the sufficient quantities in stock. 
 * Before terminating the program, it must update the inventory 
   file to reflect the depletion in stock. 
 * It might also print a list of items that need to be restocked.
*/

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

    /*
     * Constructor for the Product class.
     * Initializes the properties of the product.
     *
     * @param itemName      The name of the item.
     * @param pricePerUnit  The price per unit of the item.
     * @param quantity      The quantity of the item.
     * @param dateReceived  The date when the item was received.
     * @param supplier      The supplier of the item.
     * @param count         The count of the item in stock.
    */
    public Product(String itemName, double pricePerUnit, int quantity, String dateReceived, String supplier,
            int count) {

        this.itemName = itemName;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
        this.dateReceived = dateReceived;
        this.supplier = supplier;
        this.count = count;
    }

    /*
     * Returns a string representation of the product.
     *
     * @return The string representation of the product.
    */
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
            } 
            else {

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
                    } 
                    else {
                        System.out.println("Insufficient quantity in stock for " + itemName + ".");
                    }

                } 

                else {
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
        } 
        else {

            for (Product product : restockList) {
                System.out.println(product);
            }
        }

        updateInventoryFile(products);

        scanner.close();
    }

    /*
     * Reads the inventory file and returns a list of products.
     *
     * @return A list of products read from the inventory file.
    */
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
        } 

        catch (IOException e) {
            System.out.println("An error occurred while reading the inventory file.");
            e.printStackTrace();
        }

        return products;
    }

    /*
     * Finds a product in the given list based on the item name.
     *
     * @param itemName  The name of the item to find.
     * @param products  The list of products to search in.
     * @return The found product or null if not found.
    */
    private static Product findProduct(String itemName, List<Product> products) {

        for (Product product : products) {

            if (product.itemName.equalsIgnoreCase(itemName)) {
                return product;
            }
        }
        return null;
    }

    /*
     * Updates the inventory file with the given list of products.
     *
     * @param products  The list of products to update in the inventory file.
    */
    private static void updateInventoryFile(List<Product> products) {

        try {

            FileWriter writer = new FileWriter("inventory.txt");

            for (Product product : products) {

                writer.write(
                        product.itemName + "," + product.pricePerUnit + "," + product.quantity + "," + product.dateReceived
                                + "," + product.supplier + "," + product.count + "\n");
            }

            writer.close();
        } 

        catch (IOException e) {
            System.out.println("An error occurred while updating the inventory file.");
            e.printStackTrace();
        }
    }
}