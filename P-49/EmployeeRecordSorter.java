import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Date {
    int day;
    int month;
    int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
}

class Employee {
    int[] empCode = new int[6];
    char[] empName = new char[20];
    Date joinDate;
    float salary;

    public Employee(int[] empCode, char[] empName, Date joinDate, float salary) {
        this.empCode = empCode;
        this.empName = empName;
        this.joinDate = joinDate;
        this.salary = salary;
    }

    public String getFormattedJoinDate() {
        return String.format("%02d-%02d-%04d", joinDate.day, joinDate.month, joinDate.year);
    }

    @Override
    public String toString() {
        return "Employee Code: " + new String(empCode) +
                ", Employee Name: " + new String(empName) +
                ", Join Date: " + getFormattedJoinDate() +
                ", Salary: " + salary;
    }
}

public class EmployeeRecordSorter {
    public static void main(String[] args) {
        File inputFile = new File("employee_records.txt");
        File outputFile = new File("sorted_employee_records.txt");

        List<Employee> employeeList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(inputFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                int[] empCode = new int[6];
                char[] empName = new char[20];
                int day, month, year;
                float salary;

                // Parse the line and extract the values for each field
                // You may need to modify this part based on the actual format of your input file
                // This assumes the fields are space-separated
                String[] fields = line.split(" ");
                for (int i = 0; i < 6; i++) {
                    empCode[i] = Integer.parseInt(fields[i]);
                }
                for (int i = 6; i < 26; i++) {
                    empName[i - 6] = fields[i].charAt(0);
                }
                day = Integer.parseInt(fields[26]);
                month = Integer.parseInt(fields[27]);
                year = Integer.parseInt(fields[28]);
                salary = Float.parseFloat(fields[29]);

                Date joinDate = new Date(day, month, year);
                Employee employee = new Employee(empCode, empName, joinDate, salary);
                employeeList.add(employee);
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the employee records.");
            e.printStackTrace();
        }

        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                if (emp1.joinDate.year != emp2.joinDate.year) {
                    return Integer.compare(emp1.joinDate.year, emp2.joinDate.year);
                } else if (emp1.joinDate.month != emp2.joinDate.month) {
                    return Integer.compare(emp1.joinDate.month, emp2.joinDate.month);
                } else {
                    return Integer.compare(emp1.joinDate.day, emp2.joinDate.day);
                }
            }
        });

        try {
            FileWriter writer = new FileWriter(outputFile);

            for (Employee employee : employeeList) {
                writer.write(employee.toString() + "\n");
            }

            writer.close();
            System.out.println("Employee records have been sorted and written to the target file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the sorted employee records.");
            e.printStackTrace();
        }
    }
}
