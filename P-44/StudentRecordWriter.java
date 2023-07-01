import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentRecordWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of student records to enter: ");
        int numRecords = scanner.nextInt();

        // Create a binary file to store the student records
        File file = new File("student_records.bin");

        try {
            FileWriter writer = new FileWriter(file, true);

            for (int i = 0; i < numRecords; i++) {
                System.out.println("Enter details for student " + (i + 1) + ":");
                System.out.print("Name: ");
                String name = scanner.next();
                System.out.print("Roll number: ");
                int rollNumber = scanner.nextInt();
                System.out.print("Marks: ");
                double marks = scanner.nextDouble();

                // Write the student record to the binary file
                writer.write(name + "\n");
                writer.write(rollNumber + "\n");
                writer.write(marks + "\n");
            }

            writer.close();
            System.out.println("Student records have been written to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the student records to the file.");
            e.printStackTrace();
        }
    }
}
