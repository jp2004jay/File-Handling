Write a program to encrypt/decrypt a file using:
(1) An offset cipher: In an offset cipher each character from the source file is offset with a fixed
value and then written to the target file.
For example, if character read from the source file is ‘A’, then convert this into a new character by
offsetting ‘A’ by a fixed value, say 128, and then writing the new character to the target file.
(2) A substitution cipher: In this each character read from the source file is substituted by a
corresponding predetermined character and this character is written to the target file.
For example, if character ‘A’ is read from the source file, and if we have decided that every ‘A’ is
to be substituted by ‘!’, then a ‘!’ would be written to the target file in place of every ‘A’ Similarly,
every ‘B’ would be substituted by ‘5’ and so on.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCipher {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";
        String decryptOutputFile = "decryptOutput.txt";
        // Perform encryption
        int offset = 128;
        encryptFile(inputFilePath, outputFilePath, offset);
        System.out.println("Encryption completed. Result saved in output.txt");

        // Perform decryption
        decryptFile(outputFilePath, decryptOutputFile, offset);
        System.out.println("Decryption completed. Result saved in decryptOutput.txt");
    }

    private static void encryptFile(String inputFilePath, String outputFilePath, int offset) {
        try {
            File inputFile = new File(inputFilePath);
            File outputFile = new File(outputFilePath);

            Scanner scanner = new Scanner(inputFile);
            FileWriter writer = new FileWriter(outputFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String encryptedLine = encryptLine(line, offset);
                writer.write(encryptedLine + "\n");
            }

            scanner.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred during encryption.");
            e.printStackTrace();
        }
    }

    private static String encryptLine(String line, int offset) {
        StringBuilder encryptedLine = new StringBuilder();
        for (char ch : line.toCharArray()) {
            char encryptedChar = (char) (ch + offset);
            encryptedLine.append(encryptedChar);
        }
        return encryptedLine.toString();
    }

    private static void decryptFile(String inputFilePath, String outputFilePath, int offset) {
        try {
            File inputFile = new File(inputFilePath);
            File outputFile = new File(outputFilePath);

            Scanner scanner = new Scanner(inputFile);
            FileWriter writer = new FileWriter(outputFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String decryptedLine = decryptLine(line, offset);
                writer.write(decryptedLine + "\n");
            }

            scanner.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred during decryption.");
            e.printStackTrace();
        }
    }

    private static String decryptLine(String line, int offset) {
        StringBuilder decryptedLine = new StringBuilder();
        for (char ch : line.toCharArray()) {
            char decryptedChar = (char) (ch - offset);
            decryptedLine.append(decryptedChar);
        }
        return decryptedLine.toString();
    }
}
