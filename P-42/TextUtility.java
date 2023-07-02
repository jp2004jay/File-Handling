/* 
 * Write a menu driven text utility program. The program will have following capabilities:
 * 1. Copy a user named file to a new file.
 * 2. Change the file format to a double space
 * 3. Remove all blank lines
 * 4. Display the content of file as a series of 60 character 
   lines with no words split between lines.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextUtility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        String fileName = scanner.nextLine();

        File inputFile = new File(fileName);

        if (!inputFile.exists()) {
            System.out.println("File not found.");
            return;
        }

        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the new file: ");
                    String newFileName = scanner.nextLine();
                    copyFile(fileName, newFileName);
                    System.out.println("File copied successfully.");
                    break;
                case 2:
                    System.out.print("Enter the name of the new file: ");
                    String doubleSpacedFileName = scanner.nextLine();
                    doubleSpaceFile(fileName, doubleSpacedFileName);
                    System.out.println("File formatted to double space successfully.");
                    break;
                case 3:
                    System.out.print("Enter the name of the new file: ");
                    String noBlankLinesFileName = scanner.nextLine();
                    removeBlankLines(fileName, noBlankLinesFileName);
                    System.out.println("Blank lines removed successfully.");
                    break;
                case 4:
                    displayContent(fileName);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nText Utility Menu");
        System.out.println("1. Copy the file to a new file");
        System.out.println("2. Change the file format to double space");
        System.out.println("3. Remove all blank lines");
        System.out.println("4. Display the content as 60-character lines");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void copyFile(String sourceFileName, String destFileName) {
        try {
            File sourceFile = new File(sourceFileName);
            File destFile = new File(destFileName);

            Scanner scanner = new Scanner(sourceFile);
            FileWriter writer = new FileWriter(destFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                writer.write(line + "\n");
            }

            scanner.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while copying the file.");
            e.printStackTrace();
        }
    }

    private static void doubleSpaceFile(String sourceFileName, String destFileName) {
        try {
            File sourceFile = new File(sourceFileName);
            File destFile = new File(destFileName);

            Scanner scanner = new Scanner(sourceFile);
            FileWriter writer = new FileWriter(destFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                writer.write(line + "\n\n");
            }

            scanner.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while formatting the file to double space.");
            e.printStackTrace();
        }
    }

    private static void removeBlankLines(String sourceFileName, String destFileName) {
        try {
            File sourceFile = new File(sourceFileName);
            File destFile = new File(destFileName);

            Scanner scanner = new Scanner(sourceFile);
            FileWriter writer = new FileWriter(destFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.trim().isEmpty()) {
                    writer.write(line + "\n");
                }
            }

            scanner.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while removing blank lines from the file.");
            e.printStackTrace();
        }
    }

    private static void displayContent(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.length() >= 60) {
                    System.out.println(line);
                }
            }

            scanner.close();
            System.out.println();
        } catch (IOException e) {
            System.out.println("An error occurred while displaying the file content.");
            e.printStackTrace();
        }
    }
}
