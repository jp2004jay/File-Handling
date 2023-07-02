/* 
 * Read and Write records to a file using structure.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    double marks;

    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
}

public class RecordFileReadWrite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a file to store the records
        File file = new File("student_records.txt");

        try {
            FileWriter writer = new FileWriter(file, true);

            // Write records to the file
            System.out.println("Enter the number of student records to enter: ");
            int numRecords = scanner.nextInt();

            for (int i = 0; i < numRecords; i++) {
                System.out.println("Enter details for student " + (i + 1) + ":");
                System.out.print("Name: ");
                String name = scanner.next();
                System.out.print("Roll number: ");
                int rollNumber = scanner.nextInt();
                System.out.print("Marks: ");
                double marks = scanner.nextDouble();

                Student student = new Student(name, rollNumber, marks);

                writer.write(student.name + "," + student.rollNumber + "," + student.marks + "\n");
            }

            writer.close();
            System.out.println("Student records have been written to the file successfully.");

            // Read records from the file
            System.out.println("Reading student records from the file:");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] record = line.split(",");

                String name = record[0];
                int rollNumber = Integer.parseInt(record[1]);
                double marks = Double.parseDouble(record[2]);

                Student student = new Student(name, rollNumber, marks);
                System.out.println("Name: " + student.name + ", Roll Number: " + student.rollNumber + ", Marks: " + student.marks);
            }

            fileScanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing the records.");
            e.printStackTrace();
        }
    }
}
