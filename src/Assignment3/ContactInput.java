package Assignment3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * ContactInput class
 * Assignment 3
 * CP2561 Winter 2022
 * @author Quynh
 */
public class ContactInput {
    public static void main(String[] args) {
        // Prompt user for a file name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name: (e.g.contact.txt) ");
        String fileName = scanner.next();
        File file = new File(fileName);

        char c;
        // The application will prompt a user for a name and a phone number.
        // Keep Prompting the user for a contact until they choose to end the program.
        do{
            printMenu();
            System.out.println("Enter contact name: ");
            String name = scanner.next();
            // If the name is matched, continue to ask user for a phone number
            // If name and number are matched, write in the file
            if(checkValidName(name)){
                System.out.println("Valid name");
                while (true) {
                    System.out.println("Enter contact phone number: ");
                    String phoneNumber = scanner.next();
                    if (checkValidPhoneNumber(phoneNumber)) {
                        System.out.println("Valid phone number");
                        writeContactToFile(file, name, phoneNumber);
                        break;
                    } else {
                        System.out.println("Invalid phone number. Phone number should be in format: 999-999-9999");
                    }
                }
            }
            else{
                System.out.println("Invalid name. Name should be at least 4 characters " +
                        "and should start with a capital letter\n.");
            }
            c = Character.toUpperCase(name.charAt(0));
        }while(c != '!');

        // Output the name of the file, the absolute path to the file, and the file length
        displayFileInfo(file);
    }

    /**
     * Method that writes name and phone number to file
     * @param file file
     * @param name (String) name
     * @param phoneNumber (String) phone number
     */
    private static void writeContactToFile(File file, String name, String phoneNumber) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(name + ":" + phoneNumber + "\n");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method which check if the name match with pattern
     * @param name name
     * @return true if name matches with pattern, else false
     */
    private static boolean checkValidName(String name){
        // Create patterns for name and phone number using regular expression
        // A name has to be at least 4 characters and should start with a capital letter.
        String NAME = "^[A-Z][a-z]{3}[a-z]*";
        Pattern namePattern = Pattern.compile(NAME);
        return namePattern.matcher(name).matches();
    }

    /**
     * Method which check if the phone number match with pattern
     * @param phoneNumber phone number
     * @return true if phone number matches with pattern, else false
     */
    private static boolean checkValidPhoneNumber(String phoneNumber){
        // A phone number should be in an appropriate format,
        // with a 3 digit area code, and 7 digit phone number
        String PHONE_NUMBER ="^[1-9]\\d{2}-\\d{3}-\\d{4}";
        Pattern phonePattern = Pattern.compile(PHONE_NUMBER);
        return phonePattern.matcher(phoneNumber).matches();
    }



    /**
     * Method which displays the information of file:
     * the name of the file, the absolute path to the file, and the file length
     * @param file file
     */
    private static void displayFileInfo(File file) {
        if (file.exists()){
            System.out.println("File exists!");
            System.out.println("File name:" + file.getName());
            System.out.println("Absolute path:" + file.getAbsolutePath());
            System.out.println("File length:" + file.length());
        }
        else {
            System.out.println("No file: (");
        }
    }

    /**
     * Method print the information for the user when enter a contact
     * Enter ! if they wish to end the program
     */
    public static void printMenu(){
        System.out.println("Enter contact including name and phone number");
        System.out.println("Enter ! to quit");
    }
}
