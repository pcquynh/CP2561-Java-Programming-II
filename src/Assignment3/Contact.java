package Assignment3;

import java.io.Serializable;

/**
 * Contact class
 * Assignment 3
 * CP2561 Winter 2022
 * @author Quynh
 */
public class Contact implements Serializable {
    private String name;
    private String phoneNumber;

    /**
     * Constructor creates a contact with a name and a phone number
     * @param name name of contact
     * @param phoneNumber phone number of contact
     */
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the name of a contact
     * @return the name of contact
     */
    public String getName() {
        return name;
    }

    /**
     * Set name for a contact
     * @param name the name to set for contact
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the phone number of a contact
     * @return phone number of a contact
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set phone number for a contact
     * @param phoneNumber phone number to set for contact
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Method which return a string to represent Contact object
     * @return String included name and phone number
     */
    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
