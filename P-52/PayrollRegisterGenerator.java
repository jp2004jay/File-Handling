/* 
 * Create an employee file as shown in below table:
Employee_no Department Pay_rate Exempt Hours_worked
0101        41          8.11       Y       49
0722        32          7.22       N       40
1273        23          5.43       Y       39
2584        14          6.74       N       45
 * Write a program that read the employee file and create a payroll register. 
   The register will contain the following data.
 * 1. Employee number
 * 2. Department
 * 3. Pay rate
 * 4. Exempt
 * 5. Hours worked
 * 6. Base pay
 * 7. Over time (over time pay is only for non exempt employees. 
   An employee is exempt if Y appears in the exempt column. 
   Over time is paid at time and one half for all hours worked over 40.
 * 8. Total pay
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PayrollRegisterGenerator {
    public static void main(String[] args) {
        File file = new File("employee_file.txt");

        try {
            Scanner scanner = new Scanner(file);

            // Print register heading
            System.out.println("Payroll Register");
            System.out.println("----------------");
            System.out.printf("%-12s %-10s %-8s %-6s %-13s %-9s %-9s %-9s\n",
                    "Emp. Number", "Dept.", "Pay Rate", "Exempt", "Hours Worked", "Base Pay", "Overtime", "Total Pay");

            FileWriter writer = new FileWriter("payroll_register.txt");

            // Write register heading to file
            writer.write("Payroll Register\n");
            writer.write("----------------\n");
            writer.write(String.format("%-12s %-10s %-8s %-6s %-13s %-9s %-9s %-9s\n",
                    "Emp. Number", "Dept.", "Pay Rate", "Exempt", "Hours Worked", "Base Pay", "Overtime", "Total Pay"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\s+");

                String empNumber = parts[0];
                int department = Integer.parseInt(parts[1]);
                double payRate = Double.parseDouble(parts[2]);
                boolean isExempt = parts[3].equalsIgnoreCase("Y");
                int hoursWorked = Integer.parseInt(parts[4]);

                double basePay = payRate * hoursWorked;
                double overtimePay = 0;

                if (!isExempt && hoursWorked > 40) {
                    int overtimeHours = hoursWorked - 40;
                    overtimePay = (payRate * 1.5) * overtimeHours;
                }

                double totalPay = basePay + overtimePay;

                // Print payroll details
                System.out.printf("%-12s %-10d $%-7.2f %-6s %-13d $%-8.2f $%-8.2f $%-8.2f\n",
                        empNumber, department, payRate, isExempt ? "Y" : "N", hoursWorked, basePay, overtimePay, totalPay);

                // Write payroll details to file
                writer.write(String.format("%-12s %-10d $%-7.2f %-6s %-13d $%-8.2f $%-8.2f $%-8.2f\n",
                        empNumber, department, payRate, isExempt ? "Y" : "N", hoursWorked, basePay, overtimePay, totalPay));
            }

            scanner.close();
            writer.close();

            // Print end of register message
            System.out.println("----------------");
            System.out.println("End of Register");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the employee file.");
            e.printStackTrace();
        }
    }
}
