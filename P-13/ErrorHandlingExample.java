import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ErrorHandlingExample {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            // Open the file
            reader = new BufferedReader(new FileReader("example.txt"));

            // Read the file line by line
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle the exception
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            // Close the file in the finally block to ensure it's always closed
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("An error occurred while closing the file: " + e.getMessage());
            }
        }
    }
}
