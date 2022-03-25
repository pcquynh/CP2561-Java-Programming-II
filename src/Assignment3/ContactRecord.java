package Assignment3;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ContactRecord class
 * Assignment 3
 * CP2561 Winter 2022
 * @author Quynh
 */
public class ContactRecord {

    public static void main(String[] args) {
        // Prompt the user for a filename for an existing data file
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter filename: ");
        String fileName = scanner.next();
        File inputFile = new File(fileName);
        ArrayList<Contact> contactList = new ArrayList<>();
        // Create a file called error.txt
        File logFile = new File("error.txt");

        // Read contacts from a filename for an existing data file
        readContactsFromTxtFile(contactList, inputFile, logFile);

        // Create a file called contacts.db
        String outputFileName = "contacts.db";
        File outputFile = new File(outputFileName);


        // Write the Contact objects to a file called contacts.db
        writeContactsToDbFiles(outputFile, contactList, logFile);

        // Read the contacts.db objects
        ArrayList<Contact> contactListFromDb = readContactsFromDbFile(outputFile, logFile);

        // Print the contacts information
        printContacts(contactList);

        // Update information
        ArrayList<Contact> updateContactsList = updateContacts(scanner, contactListFromDb);

        // Write the objects back to a file called contactsUpdated.db
        File updatedFile = new File("contactsUpdated.db");
        writeContactsToDbFiles(updatedFile, updateContactsList, logFile);
        printContacts(updateContactsList);

    }

    /**
     * Method that reads the input from data file, create Contact objects,
     * and add contact objects to arraylist contact
     *
     * @param contactList arraylist contains contact objects
     * @param inputFile   file to read
     */
    private static void readContactsFromTxtFile(ArrayList<Contact> contactList, File inputFile, File logFile) {
        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String contactName = line.substring(0, line.indexOf(":"));
                String contactPhone = line.substring(line.indexOf(":") + 1);
                Contact contact = new Contact(contactName, contactPhone);
                contactList.add(contact);
            }
            bufferedReader.close();
            System.setErr(new PrintStream(logFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that writes contacts to db file from arraylist of contacts
     *
     * @param outputFile  name of db file
     * @param contactList arraylist of contacts
     */
    private static void writeContactsToDbFiles(File outputFile, ArrayList<Contact> contactList, File logFile) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(contactList);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
            System.setErr(new PrintStream(logFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that reads contacts from db file
     *
     * @param outputFile name of db file to read
     * @return arraylist of contact objects
     */
    private static ArrayList<Contact> readContactsFromDbFile(File outputFile, File logFile) {
        // Read from contact.db
        ArrayList<Contact> contactObject = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(outputFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            contactObject = (ArrayList<Contact>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.setErr(new PrintStream(logFile));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return contactObject;
    }

    /**
     * Method which prints the contact in contact list
     * @param contactList list of contact
     */
    private static void printContacts(ArrayList<Contact> contactList) {
        for (int i = 0; i < contactList.size(); i++) {
            System.out.printf("%d: %s\n", i + 1, contactList.get(i));
        }
    }

    /**
     * Method which check the phone number
     * @param phoneNumber(String) the phone number entered by user
     * @return if the phone number is in the form of an email address, return false
     * check if the phone number is valid return true, else return false
     */
    private static boolean checkValidPhoneNumber(String phoneNumber) {
        String EMAIL_ADDRESS = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern emailPattern = Pattern.compile(EMAIL_ADDRESS);
        Matcher matcherEmail = emailPattern.matcher(phoneNumber);
        String PHONE_NUMBER = "^[1-9]\\d{2}-\\d{3}-\\d{4}";
        Pattern phonePattern = Pattern.compile(PHONE_NUMBER);
        Matcher matcherPhone = phonePattern.matcher(phoneNumber);
        if (matcherEmail.matches()) {
            System.out.println("Only phone numbers are allowed.");
            return false;
        } else if (matcherPhone.matches()) {
            System.out.println("Valid phone number.");
            return true;
        } else {
            System.out.println("Invalid phone number.");
            return false;
        }
    }

    /**
     * Method which provides the user with an ability to update the name or contact info
     * @param sc scanner
     * @param contactList list of contact objects
     * @return un updated contact list
     */
    private static ArrayList<Contact> updateContacts(Scanner sc, ArrayList<Contact> contactList) {
        if (contactList.size() == 0){
            System.out.println("No contact in the list.");
            System.exit(0);
        }else {
            System.out.println("\nEnter number of contact to edit: ");
            int changedContact = sc.nextInt();
            System.out.println("Do you want to update name or phone number? (n/p): ");
            String choice = sc.next();
            if (choice.equals("n")) {
                System.out.println("Enter updated name: ");
                String updatedName = sc.next();
                contactList.get(changedContact - 1).setName(updatedName);
            } else {
                while (true) {
                    System.out.println("Enter updated phone number: ");
                    String updatedPhoneNumber = sc.next();
                    if (checkValidPhoneNumber(updatedPhoneNumber)) {
                        contactList.get(changedContact - 1).setPhoneNumber(updatedPhoneNumber);
                        break;
                    }
                }
            }
        }
        return contactList;
    }
}
