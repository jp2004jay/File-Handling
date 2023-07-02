/* 
 * Write a program to find smallest integer from the N integer stored in file “INT”
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SmallestIntegerFinder {
    public static void main(String[] args) {
        File file = new File("INT.txt");

        try {
            Scanner scanner = new Scanner(file);

            int smallest = Integer.MAX_VALUE;

            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();

                if (num < smallest) {
                    smallest = num;
                }
            }

            scanner.close();

            if (smallest == Integer.MAX_VALUE) {
                System.out.println("The file is empty or does not contain any valid integers.");
            } else {
                System.out.println("The smallest integer in the file is: " + smallest);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'INT' could not be found.");
            e.printStackTrace();
        }
    }
}
