/*
 * Write a program that writes the multiple of number between lowlimit and highlimit to a text file.
 * Assume that lowlimit < highlimit and number is not equal to zero.
*/

import java.io.FileWriter;
import java.io.IOException;

public class MultiplesToFile {

    /*
    * Writes the multiples of a given number within a specified range to a file.
    *
    * @param number    The number whose multiples will be written to the file.
    * @param lowLimit  The lower limit of the range (inclusive).
    * @param highLimit The upper limit of the range (inclusive).
    * @param fileName  The name of the output file.
    */
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
        } 

        catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }

    }

    public static void main(String[] args) {

        // The number whose multiples will be written to the file
        int number = 5; 

        // The lower limit
        int lowLimit = 1; 

        // The upper limit
        int highLimit = 9999; 

        // The name of the output file
        String fileName = "multiples.txt"; 

        // Call the writeMultiplesToFile method with the specified parameters
        writeMultiplesToFile(number, lowLimit, highLimit, fileName);
    }
}
