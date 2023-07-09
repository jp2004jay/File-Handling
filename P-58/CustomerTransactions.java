/* 
 * In the file ‘CUSTOMER.DAT’ there are 100 records with the following structure:
    struct customer
    {
        int accno ;
        char name[30] ;
        float balance ;
    } ;
 * In another file ‘TRANSACTIONS.DAT’ there are several records with the following structure:
    struct trans
    {
        int accno ,
        char trans_type ;float amount ;
    } ;
 * The parameter trans_type contains D/W indicating deposit or withdrawal of amount. 
 * Write a program to update ‘CUSTOMER.DAT’ file, i.e. if the trans_type is ‘D’ 
   then update the balance of ‘CUSTOMER.DAT’ by adding amount to balance for 
   the corresponding accno. 
 * Similarly, if trans_type is ‘W’ then subtract the amount from balance. 
   However, while subtracting the amount make sure that the amount should not get overdrawn, 
   i.e. at least 100 Rs. Should remain in the account.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * The Customer class represents a customer with their account details and provides
 * functionality to update their balance based on transactions.
 */
class Customer {

    private int accNo;
    private String name;
    private float balance;

    /*
     * Constructs a Customer object with the specified account details.
     *
     * @param accNo   the account number
     * @param name    the customer name
     * @param balance the current balance
    */
    public Customer(int accNo, String name, float balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    /*
     * Returns the account number.
     *
     * @return the account number
    */
    public int getAccNo() {
        return accNo;
    }

    /*
     * Returns the customer name.
     *
     * @return the customer name
    */
    public String getName() {
        return name;
    }

    /*
     * Returns the current balance.
     *
     * @return the current balance
    */
    public float getBalance() {
        return balance;
    }

     /*
     * Updates the balance based on the transaction type (Deposit or Withdrawal) and amount.
     *
     * @param amount    the amount of the transaction
     * @param transType the type of transaction ('D' for Deposit, 'W' for Withdrawal)
    */
    public void updateBalance(float amount, char transType) {

        if (transType == 'D') {
            balance += amount;
        } 
        else if (transType == 'W') {

            if((balance - amount) >= 100){
                balance -= amount;
            }
            else {
                System.out.println("SCAM! \nAnything Wrong!\n"+accNo+" is FRAUD!");
            } 
        }
        else{
            System.out.println("System CRASH!");
        }
    }

    /*
     * Returns a string representation of the Customer object.
     *
     * @return a string representation of the Customer
    */
    @Override
    public String toString() {
        return "Account Number: " + accNo + "\n" +
                "Name: " + name + "\n" +
                "Balance: " + balance;
    }
}

public class CustomerTransactions {

    public static void main(String[] args) {

        try {

            // Read customer data from CUSTOMER.DAT file
            File customerFile = new File("CUSTOMER.DAT");
            
            Scanner customerScanner = new Scanner(customerFile);

            Customer[] customers = new Customer[100];
            int customerCount = 0;
            
            // Process each line of customer data
            while (customerScanner.hasNextLine()) {

                String line = customerScanner.nextLine();
                String[] parts = line.split(", ");

                int accNo = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                float balance = Float.parseFloat(parts[2].trim());

                Customer customer = new Customer(accNo, name, balance);
                customers[customerCount] = customer;
                customerCount++;
            }

            customerScanner.close();

            // Update customer balances based on transactions in TRANSACTIONS.DAT file
            File transactionFile = new File("TRANSACTIONS.DAT");

            Scanner transactionScanner = new Scanner(transactionFile);
            
            // Process each line of transaction data
            while (transactionScanner.hasNextLine()) {

                String line = transactionScanner.nextLine();
                String[] parts = line.split(", ");

                int accNo = Integer.parseInt(parts[0].trim());
                char transType = parts[1].trim().charAt(0);
                float amount = Float.parseFloat(parts[2].trim());
                
                // Find the customer and update balance
                for (int i = 0; i < customerCount; i++) {

                    if (customers[i].getAccNo() == accNo) {
                        customers[i].updateBalance(amount, transType);
                        break;
                    }
                }
            }

            transactionScanner.close();

            // Write updated customer data back to CUSTOMER.DAT file
            FileWriter writer = new FileWriter("CUSTOMER.DAT");
            
            // Write each customer's data to the file
            for (int i = 0; i < customerCount; i++) {
                Customer customer = customers[i];
                writer.write(customer.getAccNo() + ", " + customer.getName() + ", " + customer.getBalance() + "\n");
            }

            writer.close();

            System.out.println("Customer balances updated successfully!");

        } 
        catch (IOException e) {
            System.out.println("An error occurred while updating customer balances.");
            e.printStackTrace();
        }
    }
}