/*
 * Given a text file, write a program to create another text file 
   deleting the words "a", "the", "an" and replacing each one of 
   them with a blank space.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WordRemover {
    public static void main(String[] args) {
        // Read the input file
        String inputFilePath = "input.txt";
        String inputFileContent = readFile(inputFilePath);

        // Remove words and create the output file
        String outputFileContent = removeWords(inputFileContent);
        String outputFilePath = "output.txt";
        writeFile(outputFilePath, outputFileContent);

        System.out.println("Output file created successfully.");
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
    * Removes specific words from the provided text.
    *
    * @param text The text from which to remove the specified words.
    * @return The text with the specified words removed.
    */
    private static String removeWords(String text) {

        // Remove the word "a" from the text
        text = text.replaceAll("\\ba\\b", " ");

        // Remove the word "the" from the text
        text = text.replaceAll("\\bthe\\b", " ");

        // Remove the word "an" from the text
        text = text.replaceAll("\\ban\\b", " ");

        return text;
    }

    /*
    * Writes the provided content to a file located at the specified path.
    *
    * @param filePath The path of the file to be written.
    * @param content The content to be written to the file.
    */
    private static void writeFile(String filePath, String content) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }
    }
}
