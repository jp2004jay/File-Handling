/*
 * Write a program to record information about stock received at the store. 
 * The user enter the information about each product received the item name, 
   the price per user, the price per unit, the quantity and date received and the supplier. 
 * Each product is represented by a structure which is stored as a record in a file called "inventory". 
 * The structure also contains a member named "count". 
 * Which is used to record the number of units the number of 
   unit of the product in the store at any time. 
 * This member is initialized to "quantity received" and would be 
   decremented by 1 each time a unit of the product purchased.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
     * @param quantity      The quantity of the item received.
     * @param dateReceived  The date when the item was received.
     * @param supplier      The supplier of the item.
     */
    public Product(String itemName, double pricePerUnit, int quantity, String dateReceived, String supplier) {
        this.itemName = itemName;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
        this.dateReceived = dateReceived;
        this.supplier = supplier;
        this.count = quantity;
    }
}

public class StockManagement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FileWriter writer = null;

        try {

            // Append to the existing file
            writer = new FileWriter("inventory.txt", true); 
            
            boolean continueInput = true;

            while (continueInput) {

                System.out.print("Enter the item name: ");
                String itemName = scanner.nextLine();

                System.out.print("Enter the price per unit: ");
                double pricePerUnit = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Enter the quantity received: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter the date received: ");
                String dateReceived = scanner.nextLine();

                System.out.print("Enter the supplier: ");
                String supplier = scanner.nextLine();

                // Create a Product object with the entered information
                Product product = new Product(itemName, pricePerUnit, quantity, dateReceived, supplier);

                // Save the product information to the inventory file
                writer.write(product.itemName + "," + product.pricePerUnit + "," + product.quantity + ","
                        + product.dateReceived + "," + product.supplier + "," + product.count + "\n");

                System.out.print("Do you want to enter information for another product (yes/no)? ");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("no")) {
                    continueInput = false;
                }

            }
        } 

        catch (IOException e) {
            System.out.println("An error occurred while writing to the inventory file.");
            e.printStackTrace();
        } 

        finally {

            try {
                if (writer != null) {
                    writer.close();
                }
            } 
            catch (IOException e) {
                System.out.println("An error occurred while closing the inventory file.");
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
