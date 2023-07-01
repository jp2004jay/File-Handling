import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentNamesFileHandler {
    public static void main(String[] args) {
        List<String> studentNames = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Read and store student names
        System.out.println("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            studentNames.add(name);
        }

        // Write student names to a file
        File file = new File("student_names.txt");

        try {
            FileWriter writer = new FileWriter(file);

            for (String name : studentNames) {
                writer.write(name + "\n");
            }

            writer.close();
            System.out.println("Student names have been written to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the student names to the file.");
            e.printStackTrace();
        }

        // Display the nth name
        System.out.print("Enter the position of the name you want to display: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        if (n >= 1 && n <= studentNames.size()) {
            String nthName = studentNames.get(n - 1);
            System.out.println("The name at position " + n + " is: " + nthName);
        } else {
            System.out.println("Invalid position. Please enter a valid position.");
        }

        // Display names starting with 'S'
        System.out.println("Names starting with 'S':");
        for (String name : studentNames) {
            if (name.startsWith("S")) {
                System.out.println(name);
            }
        }
    }
}
