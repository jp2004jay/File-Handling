/* 
 * Write a program to find smallest integer from the N integer stored in file "INT"
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SmallestIntegerFinder {

    public static void main(String[] args) {

        File file = new File("INT.txt");

        try {

            // Create a Scanner to read from the file
            Scanner scanner = new Scanner(file);

            int smallest = Integer.MAX_VALUE;

            // Iterate through each integer in the file
            while (scanner.hasNextInt()) {

                int num = scanner.nextInt();

                // Update the smallest value if a smaller integer is found
                if (num < smallest) {
                    smallest = num;
                }

            }

            scanner.close();
 
            // Check if the smallest value remains unchanged, indicating an empty file
            if (smallest == Integer.MAX_VALUE) {
                System.out.println("The file is empty or does not contain any valid integers.");
            } 
            else {
                System.out.println("The smallest integer in the file is: " + smallest);
            }

        } 

        catch (FileNotFoundException e) {
            // Handle the case where the file is not found 
            System.out.println("The file 'INT' could not be found.");
            e.printStackTrace();
        }
    }
}
