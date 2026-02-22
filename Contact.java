package contact;

/**
 * Contact Class
 */
public class Contact {
    
    private final String contactId;  // Immutable - no setter
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    
    /**
     * Creates a new Contact with all required fields.
     * 
     * @param contactId Unique ID, max 10 characters, cannot be null
     * @param firstName First name, max 10 characters, cannot be null
     * @param lastName Last name, max 10 characters, cannot be null
     * @param phone Phone number, exactly 10 digits, cannot be null
     * @param address Address, max 30 characters, cannot be null
     * @throws IllegalArgumentException if any validation fails
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate contactId
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID cannot be null and must be 10 characters or less");
        }
        
        // Validate and set other fields using setters
        this.contactId = contactId;
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }
    
    // Getters
    
    public String getContactId() {
        return contactId;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getAddress() {
        return address;
    }
    
    // Setters (no setter for contactId - it's immutable)
    
    /**
     * Sets the first name.
     * @param firstName First name, max 10 characters, cannot be null
     * @throws IllegalArgumentException if validation fails
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be null and must be 10 characters or less");
        }
        this.firstName = firstName;
    }
    
    /**
     * Sets the last name.
     * @param lastName Last name, max 10 characters, cannot be null
     * @throws IllegalArgumentException if validation fails
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be null and must be 10 characters or less");
        }
        this.lastName = lastName;
    }
    
    /**
     * Sets the phone number.
     * @param phone Phone number, exactly 10 digits, cannot be null
     * @throws IllegalArgumentException if validation fails
     */
    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits");
        }
        this.phone = phone;
    }
    
    /**
     * Sets the address.
     * @param address Address, max 30 characters, cannot be null
     * @throws IllegalArgumentException if validation fails
     */
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be null and must be 30 characters or less");
        }
        this.address = address;
    }
}
