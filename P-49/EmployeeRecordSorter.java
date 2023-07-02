/*
 * There are 100 records present in a file with the following structure:
    struct date
    {
        int d, m, y ;
    } ;
    struct employee
    {
        int empcode[6] ;
        char empname[20] ;
        struct date join_date ;
        float salary ;
    } ;
 * Write a program to read these records, arrange them in ascending order of join_date 
 * Write them in to a target file.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

class Date {
    int d, m, y;

    public Date(int d, int m, int y) {
        this.d = d;
        this.m = m;
        this.y = y;
    }
}

class Employee {
    int[] empcode;
    String empname;
    Date join_date;
    float salary;

    public Employee(int[] empcode, String empname, Date join_date, float salary) {
        this.empcode = empcode;
        this.empname = empname;
        this.join_date = join_date;
        this.salary = salary;
    }
}

public class EmployeeRecordSorter {
    public static void main(String[] args) {
        // Input and output file paths
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // Read records from the input file
        ArrayList<Employee> records = readRecords(inputFile);

        // Sort records in ascending order of join_date
        Collections.sort(records, new Comparator<Employee>() {
            public int compare(Employee emp1, Employee emp2) {
                return compareDates(emp1.join_date, emp2.join_date);
            }
        });

        // Write sorted records to the output file
        writeRecords(records, outputFile);

        System.out.println("Records sorted and written to the output file.");
    }

    // Read records from the input file
    private static ArrayList<Employee> readRecords(String filePath) {
        ArrayList<Employee> records = new ArrayList<>();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                int[] empcode = Arrays.stream(scanner.nextLine().split(","))
                        .mapToInt(Integer::parseInt).toArray();
                String empname = scanner.nextLine();
                int d = Integer.parseInt(scanner.nextLine());
                int m = Integer.parseInt(scanner.nextLine());
                int y = Integer.parseInt(scanner.nextLine());
                float salary = Float.parseFloat(scanner.nextLine());

                Date join_date = new Date(d, m, y);
                Employee employee = new Employee(empcode, empname, join_date, salary);

                records.add(employee);
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        return records;
    }

    // Compare two dates in ascending order
    private static int compareDates(Date date1, Date date2) {
        if (date1.y != date2.y) {
            return date1.y - date2.y;
        } else if (date1.m != date2.m) {
            return date1.m - date2.m;
        } else {
            return date1.d - date2.d;
        }
    }

    // Write records to the output file
    private static void writeRecords(ArrayList<Employee> records, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);

            for (Employee employee : records) {
                fileWriter.write(Arrays.toString(employee.empcode) + "\n");
                fileWriter.write(employee.empname + "\n");
                fileWriter.write(employee.join_date.d + "\n");
                fileWriter.write(employee.join_date.m + "\n");
                fileWriter.write(employee.join_date.y + "\n");
                fileWriter.write(employee.salary + "\n");
            }

            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }
    }
}
