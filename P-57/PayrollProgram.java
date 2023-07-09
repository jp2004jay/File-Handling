/*
 * Write a payroll program which reads the employee information 
   from a file and prints their pay slip. 
 * The pay slips are stored in pay.lst file.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * The Employee class represents an employee with their details and provides
 * functionality to calculate their salary.
*/
class Employee {

    private int empNo;
    private String name;
    private double hourlyRate;
    private int hoursWorked;

    /*
     * Constructs an Employee object with the specified details.
     *
     * @param empNo       the employee number
     * @param name        the employee name
     * @param hourlyRate  the hourly rate of the employee
     * @param hoursWorked the number of hours worked by the employee
    */
    public Employee(int empNo, String name, double hourlyRate, int hoursWorked) {
        this.empNo = empNo;
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    /*
     * Returns the employee number.
     *
     * @return the employee number
    */
    public int getEmpNo() {
        return empNo;
    }

    /*
     * Returns the employee name.
     *
     * @return the employee name
    */
    public String getName() {
        return name;
    }

    /*
     * Returns the hourly rate of the employee.
     *
     * @return the hourly rate
    */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /*
     * Returns the number of hours worked by the employee.
     *
     * @return the hours worked
    */
    public int getHoursWorked() {
        return hoursWorked;
    }

    /*
     * Calculates the salary of the employee based on their hourly rate and hours worked.
     * If the employee worked overtime (more than 40 hours), overtime pay is included.
     *
     * @return the calculated salary of the employee
    */
    public double calculateSalary() {
        double basePay = hourlyRate * hoursWorked;
        double overtimePay = 0.0;

        if (hoursWorked > 40) {
            basePay = hourlyRate * 40;
            int overtimeHours = hoursWorked - 40;
            overtimePay = overtimeHours * (hourlyRate * 1.5);
        }

        return basePay + overtimePay;
    }

    /*
     * Returns a string representation of the Employee object.
     *
     * @return a string representation of the Employee
    */
    @Override
    public String toString() {
        return "Employee Number: " + empNo + "\n" +
                "Name: " + name + "\n" +
                "Hourly Rate: $" + hourlyRate + "\n" +
                "Hours Worked: " + hoursWorked + "\n" +
                "Salary: $" + calculateSalary();
    }
}

public class PayrollProgram {

    public static void main(String[] args) {
        
        try {
            File inputFile = new File("employees.txt");
            Scanner scanner = new Scanner(inputFile);

            FileWriter writer = new FileWriter("pay1st.txt");
            
            // Read employee data from the file and generate pay slips
            while (scanner.hasNextLine()) {

                String[] parts = scanner.nextLine().split(", ");

                int empNo = Integer.parseInt(parts[0]);
                String name = parts[1];
                double hourlyRate = Double.parseDouble(parts[2]);
                int hoursWorked = Integer.parseInt(parts[3]);

                Employee employee = new Employee(empNo, name, hourlyRate, hoursWorked);

                writer.write(employee.toString() + "\n\n");
            }

            scanner.close();
            writer.close();

            System.out.println("Pay slips generated successfully!");

        } 

        catch (IOException e) {
            System.out.println("An error occurred while processing the payroll.");
            e.printStackTrace();
        }
    }
}
