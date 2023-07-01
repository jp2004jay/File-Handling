Write a program to carry out the following:
(a) Read a text file ‘INPUT.TXT’
(b) Print each word in reverse order
Example,
Input: INDIA IS MY COUNTRY
Output: AIDNI SI YM YRTNUOC
Assume that each word length is maximum of 10 characters and each word is separated by
newline/blank characters.


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args) {
        // Read the input file
        String inputFilePath = "INPUT.TXT";
        String inputFileContent = readFile(inputFilePath);

        // Reverse words and print
        reverseAndPrintWords(inputFileContent);
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

    private static void reverseAndPrintWords(String text) {
        Scanner scanner = new Scanner(text);

        while (scanner.hasNext()) {
            String word = scanner.next();
            String reversedWord = reverseWord(word);
            System.out.print(reversedWord + " ");
        }

        scanner.close();
    }

    private static String reverseWord(String word) {
        StringBuilder reversedWord = new StringBuilder();

        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord.append(word.charAt(i));
        }

        return reversedWord.toString();
    }
}
