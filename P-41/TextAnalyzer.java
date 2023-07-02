/* 
 * Write a text analyser program that reads the text file. 
 * The program prints a menu that gives the user the options of 
   counting lines, words, characters or sentences or all of the 
   above provide a separate function for each option. 
 * At the end of analysis write an appropriate report.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextAnalyzer {
    public static void main(String[] args) {
        String filePath = "text.txt";

        // Read the text file
        String fileContent = readFile(filePath);

        // Print the menu and perform analysis
        printMenu();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                int lineCount = countLines(fileContent);
                System.out.println("Number of lines: " + lineCount);
                break;
            case 2:
                int wordCount = countWords(fileContent);
                System.out.println("Number of words: " + wordCount);
                break;
            case 3:
                int charCount = countCharacters(fileContent);
                System.out.println("Number of characters: " + charCount);
                break;
            case 4:
                int sentenceCount = countSentences(fileContent);
                System.out.println("Number of sentences: " + sentenceCount);
                break;
            case 5:
                int totalLines = countLines(fileContent);
                int totalWords = countWords(fileContent);
                int totalChars = countCharacters(fileContent);
                int totalSentences = countSentences(fileContent);
                System.out.println("Number of lines: " + totalLines);
                System.out.println("Number of words: " + totalWords);
                System.out.println("Number of characters: " + totalChars);
                System.out.println("Number of sentences: " + totalSentences);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }

        scanner.close();

        // Write analysis report to a file
        writeReport(filePath, fileContent);
        System.out.println("Analysis report written to report.txt");
    }

    private static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                content.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        return content.toString();
    }

    private static void printMenu() {
        System.out.println("Text Analyzer");
        System.out.println("1. Count lines");
        System.out.println("2. Count words");
        System.out.println("3. Count characters");
        System.out.println("4. Count sentences");
        System.out.println("5. Count all");
        System.out.print("Enter your choice: ");
    }

    private static int countLines(String text) {
        String[] lines = text.split("\n");
        return lines.length;
    }

    private static int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }

    private static int countCharacters(String text) {
        return text.length();
    }

    private static int countSentences(String text) {
        String[] sentences = text.split("[.!?]+");
        return sentences.length;
    }

    private static void writeReport(String filePath, String fileContent) {
        try {
            File reportFile = new File("report.txt");
            FileWriter writer = new FileWriter(reportFile);

            writer.write("File Path: " + filePath + "\n");
            writer.write("File Content:\n" + fileContent + "\n");

            int lineCount = countLines(fileContent);
            writer.write("Number of lines: " + lineCount + "\n");

            int wordCount = countWords(fileContent);
            writer.write("Number of words: " + wordCount + "\n");

            int charCount = countCharacters(fileContent);
            writer.write("Number of characters: " + charCount + "\n");

            int sentenceCount = countSentences(fileContent);
            writer.write("Number of sentences: " + sentenceCount + "\n");

            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing the report.");
            e.printStackTrace();
        }
    }
}
