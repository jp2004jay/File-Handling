/*
 * Write a program that writes the multiple of number between lowlimit and highlimit to a text file.
 * Assume that lowlimit < highlimit and number is not equal to zero.
*/

import java.io.FileWriter;
import java.io.IOException;

public class MultiplesToFile {
    public static void writeMultiplesToFile(int number, int lowLimit, int highLimit, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);

            for (int i = lowLimit; i <= highLimit; i++) {
                if (i % number == 0) {
                    writer.write(i + "\n");
                }
            }

            writer.close();
            System.out.println("Multiples written to " + fileName + " successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int number = 5; // The number whose multiples will be written to the file
        int lowLimit = 1; // The lower limit
        int highLimit = 9999; // The upper limit
        String fileName = "multiples.txt"; // The name of the output file

        writeMultiplesToFile(number, lowLimit, highLimit, fileName);
    }
}
