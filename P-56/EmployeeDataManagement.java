/*
 * In a small firm employee numbers are given in serial numerical order that is 1, 2, 3, etc.
 * Create a file of employee data with following information:
    - Employee number, name, sex, gross salary.
    - If more employees join, append their data to the file.
    - If an employee with serial number 25 (say) leaves, delete
    - The record by making gross salary 0.
    -If some employee’s gross salary increases, retrieve the record and update the salary.
 * Write a program to implement the above operations.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Employee {

    int empNo;
    String name;
    char sex;
    double grossSalary;
        
    /*
     * Constructor for the Employee class.
     * Initializes the properties of the employee.
     *
     * @param empNo        The employee number.
     * @param name         The name of the employee.
     * @param sex          The sex of the employee.
     * @param grossSalary  The gross salary of the employee.
    */
    public Employee(int empNo, String name, char sex, double grossSalary) {
        this.empNo = empNo;
        this.name = name;
        this.sex = sex;
        this.grossSalary = grossSalary;
    }

    /**
     * Returns a string representation of the employee.
     *
     * @return The string representation of the employee.
    */
    @Override
    public String toString() {
        return "Employee Number: " + empNo + ", Name: " + name + ", Sex: " + sex + ", Gross Salary: $" + grossSalary;
    }
}

public class EmployeeDataManagement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continueOperations = true;

        while (continueOperations) {

            System.out.println("Menu:");
            System.out.println("1. Create Employee Data File");
            System.out.println("2. Append Employee Data");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee Data");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            // Consume newline character
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createEmployeeDataFile();
                    break;
                case 2:
                    appendEmployeeData();
                    break;
                case 3:
                    updateEmployeeSalary();
                    break;
                case 4:
                    deleteEmployeeData();
                    break;
                case 5:
                    continueOperations = false;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Creates a new employee data file and saves employee data to it.
    */
    private static void createEmployeeDataFile() {
        try {
            FileWriter writer = new FileWriter("EmployeeData.txt");

            System.out.println("Enter employee data (Enter 'exit' to stop):");

            Scanner scanner = new Scanner(System.in);
            String input = "";

            while (!input.equalsIgnoreCase("exit")) {

                System.out.print("Employee Number: ");
                int empNo = scanner.nextInt();
                scanner.nextLine();

                if (empNo == 0) {
                    System.out.println("Invalid employee number. Please try again.");
                    continue;
                }

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Sex: ");
                char sex = scanner.next().charAt(0);
                scanner.nextLine(); // Consume newline character

                System.out.print("Gross Salary: ");
                double grossSalary = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character

                Employee employee = new Employee(empNo, name, sex, grossSalary);
                writer.write(employee.toString() + "\n");

                System.out.println("Employee data saved to file.");

                System.out.print("Enter 'exit' to stop or press Enter to continue: ");
                input = scanner.nextLine();
            }

            writer.close();
        } 

        catch (IOException e) {
            System.out.println("An error occurred while creating the EmployeeData.txt file.");
            e.printStackTrace();
        }
    }

    /**
     * Appends employee data to the existing employee data file.
    */
    private static void appendEmployeeData() {

        try {

            FileWriter writer = new FileWriter("EmployeeData.txt", true); // Append mode

            System.out.println("Enter employee data to append (Enter 'exit' to stop):");

            Scanner scanner = new Scanner(System.in);
            String input = "";

            while (!input.equalsIgnoreCase("exit")) {

                System.out.print("Employee Number: ");
                int empNo = scanner.nextInt();

                scanner.nextLine(); 

                if (empNo == 0) {
                    System.out.println("Invalid employee number. Please try again.");
                    continue;
                }

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Sex: ");
                char sex = scanner.next().charAt(0);
                scanner.nextLine(); 

                System.out.print("Gross Salary: ");
                double grossSalary = scanner.nextDouble();
                scanner.nextLine();

                Employee employee = new Employee(empNo, name, sex, grossSalary);
                writer.write(employee.toString() + "\n");

                System.out.println("Employee data appended to file.");

                System.out.print("Enter 'exit' to stop or press Enter to continue: ");
                input = scanner.nextLine();
            }

            writer.close();
        } 

        catch (IOException e) {
            System.out.println("An error occurred while appending to the EmployeeData.txt file.");
            e.printStackTrace();
        }
    }
    
    /**
     * Updates the salary of an employee in the employee data file.
    */
    private static void updateEmployeeSalary() {

        Scanner userInput = new Scanner(System.in);

        try {

            File inputFile = new File("EmployeeData.txt");
            File tempFile = new File("TempEmployeeData.txt");

            Scanner scanner = new Scanner(inputFile);
            FileWriter writer = new FileWriter(tempFile);

            System.out.print("Enter employee number to update salary: ");
            String empNo = userInput.nextLine();

            boolean employeeFound = false;

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                if (line.contains("Employee Number: " + empNo)) {
                    System.out.print("Enter new gross salary: ");
                    double newGrossSalary = userInput.nextDouble();

                    Employee employee = parseEmployeeData(line);
                    employee.grossSalary = newGrossSalary;

                    writer.write(employee.toString() + "\n");
                    employeeFound = true;

                    System.out.println("Employee salary updated successfully.");
                } 
                else {
                    writer.write(line + "\n");
                }
            }

            scanner.close();
            writer.close();

            if (!employeeFound) {
                System.out.println("Employee with the given employee number not found.");
            } 
            else {
                inputFile.delete();
                tempFile.renameTo(inputFile);
            }
        } 

        catch (IOException e) {
            System.out.println("An error occurred while updating the EmployeeData.txt file.");
            e.printStackTrace();
        }
    }
    
    /**
     * Deletes an employee's data from the employee data file.
    */
    private static void deleteEmployeeData() {

        Scanner userInput = new Scanner(System.in);

        try {

            File inputFile = new File("EmployeeData.txt");
            File tempFile = new File("TempEmployeeData.txt");

            Scanner scanner = new Scanner(inputFile);
            FileWriter writer = new FileWriter(tempFile);

            System.out.print("Enter employee number to delete: ");
            String empNo = userInput.nextLine();

            boolean employeeFound = false;

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                if (line.contains("Employee Number: " + empNo)) {
                    Employee employee = parseEmployeeData(line);
                    employee.grossSalary = 0;

                    writer.write(employee.toString() + "\n");
                    employeeFound = true;

                    System.out.println("Employee data deleted successfully.");
                } 
                else {
                    writer.write(line + "\n");
                }
            }

            scanner.close();
            writer.close();

            if (!employeeFound) {
                System.out.println("Employee with the given employee number not found.");
            } 
            else {
                inputFile.delete();
                tempFile.renameTo(inputFile);
            }
        } 

        catch (IOException e) {
            System.out.println("An error occurred while deleting employee data from the EmployeeData.txt file.");
            e.printStackTrace();
        }
    }

    /**
     * Set an employee's data from the employee object and return it.
    */
    private static Employee parseEmployeeData(String line) {

        String[] parts = line.split(", ");

        int empNo = Integer.parseInt(parts[0].split(": ")[1]);
        String name = parts[1].split(": ")[1];
        char sex = parts[2].split(": ")[1].charAt(0);
        double grossSalary = Double.parseDouble(parts[3].split(": ")[1].substring(1));

        return new Employee(empNo, name, sex, grossSalary);
    }
}
