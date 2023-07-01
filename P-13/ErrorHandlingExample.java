import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ErrorHandlingExample {
    public static void main(String[] args) {
        // Declare file paths
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // Attempt to read input from the file
        try {
            // Create a File object
            File file = new File(inputFile);

            // Create a Scanner object to read from the file
            Scanner scanner = new Scanner(file);

            // Read input from the file
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();

            // Perform division operation
            int result = num1 / num2;

            // Close the scanner
            scanner.close();

            // Attempt to write the result to the output file
            try {
                // Create a FileWriter object to write to the file
                FileWriter writer = new FileWriter(outputFile);

                // Write the result to the file
                writer.write("The result of the division is: " + result);

                // Close the writer
                writer.close();

                System.out.println("Result has been written to the output file.");

            } catch (IOException e) {
                System.out.println("An error occurred while writing to the output file.");
                e.printStackTrace();
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading from the input file.");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("An error occurred: Division by zero is not allowed.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An unknown error occurred.");
            e.printStackTrace();
        }
    }
}
