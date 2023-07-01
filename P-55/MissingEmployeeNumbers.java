import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Employee {
    int empno;
    String name;
    int basic;
    int grade;

    public Employee(int empno, String name, int basic, int grade) {
        this.empno = empno;
        this.name = name;
        this.basic = basic;
        this.grade = grade;
    }
}

public class MissingEmployeeNumbers {
    public static void main(String[] args) {
        try {
            File file = new File("EMPLOYEE.txt");
            Scanner scanner = new Scanner(file);

            int previousEmpNo = 0;
            int currentEmpNo;
            FileWriter writer = new FileWriter("MissingEmployeeNumbers.txt");

            while (scanner.hasNext()) {

                String[] record = scanner.nextLine().split("\t");
                int empno = Integer.parseInt(record[0]);
                String name = record[1];
                int basic = Integer.parseInt(record[2]);
                int grade = Integer.parseInt(record[3]);

                currentEmpNo = empno;

                if (currentEmpNo - previousEmpNo > 1) {
                    for (int i = previousEmpNo + 1; i < currentEmpNo; i++) {
                        writer.write(String.valueOf(i) + "\n");
                    }
                }

                previousEmpNo = currentEmpNo;
            }

            scanner.close();
            writer.close();

            System.out.println("Missing employee numbers are saved to MissingEmployeeNumbers.txt file.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the EMPLOYEE.DAT file or writing to the output file.");
            e.printStackTrace();
        }
    }
}