package ua.goit.gojava;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your message ->");
        String message = scanner.nextLine();

        System.out.print("Enter key for encryption ->");
        int key = scanner.nextInt();

        System.out.print("Enter file name ->");
        String fileName = scanner.next();

        System.out.println("You message:\n" + message + "\nwill be encrypted and saved to file \"" + fileName + "\"\nCheck it!");

        message = SuperCiphers.Caesar(message, key, true);

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(message);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Encrypted message:\n" + message + "\nsaved to file!");
        System.out.println("Press <ENTER> for open last saved file \"" + fileName + "\" and decrypt him");

        scanner = new Scanner(System.in);
        scanner.nextLine();

        message = "";

        try (FileReader reader = new FileReader(fileName)) {
            int c;
            while ((c = reader.read()) != -1) {
                message += (char) c;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        message = SuperCiphers.Caesar(message, key, false);

        System.out.println("File \"" + fileName + "\" successfully opened and decrypted: \n" + message+"\nAll done!!!");
    }
}
