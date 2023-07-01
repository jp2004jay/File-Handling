/*
 * Write a program to carry out the following:
    => To read a text file TRIAL.TXT consisting of a maximum of 50 lines of text, each line with a maximum of 80 characters.
    => Count and display the number of words contained in the file.
    => Display the total number of four letter words in the text file.
 * Assume that the end of a word may be a space, comma or a full-stop followed by one or more spaces or a newline character.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        // Read the text file
        String filePath = "TRIAL.txt";
        String fileContent = readFile(filePath);

        // Count and display the number of words
        int wordCount = countWords(fileContent);
        System.out.println("Number of words in the file: " + wordCount);

        // Count and display the total number of four-letter words
        int fourLetterWordCount = countFourLetterWords(fileContent);
        System.out.println("Number of four-letter words in the file: " + fourLetterWordCount);
    }

    /*
    * Reads the contents of a file located at the specified path and returns the content as a string.
    *
    * @param filePath The path of the file to be read.
    * @return A string representation of the content read from the file.
    */
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

    /*
    * Counts the number of words in the provided text.
    *
    * @param text The text in which to count the words.
    * @return The total number of words in the text.
    */
    private static int countWords(String text) {
        Scanner scanner = new Scanner(text);
        int wordCount = 0;

        while (scanner.hasNext()) {
            scanner.next();
            wordCount++;
        }

        scanner.close();

        return wordCount;
    }

    /*
    * Counts the number of four-letter words in the provided text.
    *
    * @param text The text in which to count the four-letter words.
    * @return The total number of four-letter words in the text.
    */
    private static int countFourLetterWords(String text) {
        Scanner scanner = new Scanner(text);
        int fourLetterWordCount = 0;

        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.length() == 4) {
                fourLetterWordCount++;
            }
        }

        scanner.close();

        return fourLetterWordCount;
    }
}
