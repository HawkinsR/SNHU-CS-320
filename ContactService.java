package contact;

import java.util.HashMap;
import java.util.Map;

/**
 * ContactService class
 */
public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    /**
     * Adds a new contact to the service.
     * 
     * @param contact The contact to add
     * @throws IllegalArgumentException if a contact with the same ID already exists
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact with ID " + contact.getContactId() + " already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    /**
     * Deletes a contact by ID.
     * 
     * @param contactId The ID of the contact to delete
     * @throws IllegalArgumentException if no contact with the given ID exists
     */
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with ID " + contactId + " not found");
        }
        contacts.remove(contactId);
    }

    /**
     * Updates the first name of a contact.
     * 
     * @param contactId The ID of the contact to update
     * @param firstName The new first name
     * @throws IllegalArgumentException if no contact with the given ID exists
     */
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = getContactOrThrow(contactId);
        contact.setFirstName(firstName);
    }

    /**
     * Updates the last name of a contact.
     * 
     * @param contactId The ID of the contact to update
     * @param lastName  The new last name
     * @throws IllegalArgumentException if no contact with the given ID exists
     */
    public void updateLastName(String contactId, String lastName) {
        Contact contact = getContactOrThrow(contactId);
        contact.setLastName(lastName);
    }

    /**
     * Updates the phone number of a contact.
     * 
     * @param contactId The ID of the contact to update
     * @param phone     The new phone number
     * @throws IllegalArgumentException if no contact with the given ID exists
     */
    public void updatePhone(String contactId, String phone) {
        Contact contact = getContactOrThrow(contactId);
        contact.setPhone(phone);
    }

    /**
     * Updates the address of a contact.
     * 
     * @param contactId The ID of the contact to update
     * @param address   The new address
     * @throws IllegalArgumentException if no contact with the given ID exists
     */
    public void updateAddress(String contactId, String address) {
        Contact contact = getContactOrThrow(contactId);
        contact.setAddress(address);
    }

    /**
     * Gets a contact by ID.
     * 
     * @param contactId The ID of the contact to retrieve
     * @return The contact with the given ID, or null if not found
     */
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    /**
     * Helper method to get a contact or throw an exception if not found.
     */
    private Contact getContactOrThrow(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact with ID " + contactId + " not found");
        }
        return contact;
    }
}
