import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCipher {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        // Perform encryption
        int offset = 128;
        encryptFile(inputFilePath, outputFilePath, offset);
        System.out.println("Encryption completed. Result saved in output.txt");

        // Perform decryption
        decryptFile(outputFilePath, inputFilePath, offset);
        System.out.println("Decryption completed. Result saved in input.txt");
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
