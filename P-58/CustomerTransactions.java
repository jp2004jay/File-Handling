import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Customer {
    private int accNo;
    private String name;
    private float balance;

    public Customer(int accNo, String name, float balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public int getAccNo() {
        return accNo;
    }

    public String getName() {
        return name;
    }

    public float getBalance() {
        return balance;
    }

    public void updateBalance(float amount, char transType) {
        if (transType == 'D') {
            balance += amount;
        } else if (transType == 'W') {
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

            while (transactionScanner.hasNextLine()) {
                String line = transactionScanner.nextLine();
                String[] parts = line.split(", ");

                int accNo = Integer.parseInt(parts[0].trim());
                char transType = parts[1].trim().charAt(0);
                float amount = Float.parseFloat(parts[2].trim());

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

            for (int i = 0; i < customerCount; i++) {
                Customer customer = customers[i];
                writer.write(customer.getAccNo() + ", " + customer.getName() + ", " + customer.getBalance() + "\n");
            }

            writer.close();

            System.out.println("Customer balances updated successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while updating customer balances.");
            e.printStackTrace();
        }
    }
}