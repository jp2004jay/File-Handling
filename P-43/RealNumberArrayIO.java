/*
 * Write a program to store an array of real numbers in file and read them.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RealNumberArrayIO {

    public static void main(String[] args) {

        double[] numbers = { 3.14, 2.71, 1.618, 0.577, 4.669 };

        // Write array to file
        writeArrayToFile("numbers.txt", numbers);
        System.out.println("Array written to file.");

        // Read array from file
        double[] readNumbers = readArrayFromFile("numbers.txt");
        System.out.println("Array read from file:");

        // Display the read numbers
        for (double number : readNumbers) {
            System.out.println(number);
        }
    }

    /*
    * Writes an array of double numbers to a file.
    *
    * @param fileName The name of the file to write to.
    * @param numbers  The array of double numbers to write.
    */
    private static void writeArrayToFile(String fileName, double[] numbers) {

        try {

            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);

            for (double number : numbers) {
                writer.write(Double.toString(number) + "\n");
            }

            writer.close();
        } 

        catch (IOException e) {
            System.out.println("An error occurred while writing the array to file.");
            e.printStackTrace();
        }
    }

    /*
    * Reads an array of double numbers from a file.
    *
    * @param fileName The name of the file to read from.
    * @return The array of double numbers read from the file.
    */
    private static double[] readArrayFromFile(String fileName) {

        double[] numbers = null;

        try {

            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            int count = 0;

            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }

            scanner.close();

            numbers = new double[count];
            scanner = new Scanner(file);

            for (int i = 0; i < count; i++) {
                String line = scanner.nextLine();
                numbers[i] = Double.parseDouble(line);
            }

            scanner.close();
        } 

        catch (IOException e) {
            System.out.println("An error occurred while reading the array from file.");
            e.printStackTrace();
        }

        return numbers;
    }
}
