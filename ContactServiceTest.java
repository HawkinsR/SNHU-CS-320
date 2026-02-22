package contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    private ContactService service;

    // Valid test data
    private static final String VALID_ID = "1234567890";
    private static final String VALID_FIRST_NAME = "John";
    private static final String VALID_LAST_NAME = "Doe";
    private static final String VALID_PHONE = "5551234567";
    private static final String VALID_ADDRESS = "123 Main Street";

    @BeforeEach
    void setUp() {
        // Arrange - Create a fresh service instance for each test
        service = new ContactService();
    }

    private Contact createValidContact() {
        return new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
    }

    private Contact createValidContact(String id) {
        return new Contact(id, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
    }

    // ==================== Add Contact Tests ====================

    @Test
    @DisplayName("Add contact with unique ID should succeed")
    void testAddContact() {
        // Arrange
        Contact contact = createValidContact();

        // Act
        service.addContact(contact);

        // Assert
        Contact retrieved = service.getContact(VALID_ID);
        assertNotNull(retrieved);
        assertEquals(VALID_ID, retrieved.getContactId());
        assertEquals(VALID_FIRST_NAME, retrieved.getFirstName());
    }

    @Test
    @DisplayName("Add multiple contacts with unique IDs should succeed")
    void testAddMultipleContacts() {
        // Arrange
        Contact contact1 = createValidContact("001");
        Contact contact2 = createValidContact("002");

        // Act
        service.addContact(contact1);
        service.addContact(contact2);

        // Assert
        assertNotNull(service.getContact("001"));
        assertNotNull(service.getContact("002"));
    }

    @Test
    @DisplayName("Add contact with duplicate ID should throw exception")
    void testAddDuplicateContact() {
        // Arrange
        Contact contact1 = createValidContact();
        Contact contact2 = createValidContact(); // Same ID
        service.addContact(contact1);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    @DisplayName("Add null contact should throw exception")
    void testAddNullContact() {
        // Arrange
        Contact nullContact = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(nullContact);
        });
    }

    // ==================== Delete Contact Tests ====================

    @Test
    @DisplayName("Delete contact by ID should succeed")
    void testDeleteContact() {
        // Arrange
        Contact contact = createValidContact();
        service.addContact(contact);
        assertNotNull(service.getContact(VALID_ID)); // Verify contact exists

        // Act
        service.deleteContact(VALID_ID);

        // Assert
        assertNull(service.getContact(VALID_ID));
    }

    @Test
    @DisplayName("Delete nonexistent contact should throw exception")
    void testDeleteNonexistentContact() {
        // Arrange
        String nonexistentId = "NONEXISTENT";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact(nonexistentId);
        });
    }

    // ==================== Update First Name Tests ====================

    @Test
    @DisplayName("Update first name should succeed")
    void testUpdateFirstName() {
        // Arrange
        Contact contact = createValidContact();
        service.addContact(contact);
        String newFirstName = "Jane";

        // Act
        service.updateFirstName(VALID_ID, newFirstName);

        // Assert
        assertEquals("Jane", service.getContact(VALID_ID).getFirstName());
    }

    @Test
    @DisplayName("Update first name of nonexistent contact should throw exception")
    void testUpdateFirstNameNonexistent() {
        // Arrange
        String nonexistentId = "NONEXISTENT";
        String newFirstName = "Jane";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName(nonexistentId, newFirstName);
        });
    }

    @Test
    @DisplayName("Update first name with invalid value should throw exception")
    void testUpdateFirstNameInvalid() {
        // Arrange
        Contact contact = createValidContact();
        service.addContact(contact);
        String invalidFirstName = "TooLongFirstName"; // 16 chars

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName(VALID_ID, invalidFirstName);
        });
    }

    // ==================== Update Last Name Tests ====================

    @Test
    @DisplayName("Update last name should succeed")
    void testUpdateLastName() {
        // Arrange
        Contact contact = createValidContact();
        service.addContact(contact);
        String newLastName = "Smith";

        // Act
        service.updateLastName(VALID_ID, newLastName);

        // Assert
        assertEquals("Smith", service.getContact(VALID_ID).getLastName());
    }

    @Test
    @DisplayName("Update last name of nonexistent contact should throw exception")
    void testUpdateLastNameNonexistent() {
        // Arrange
        String nonexistentId = "NONEXISTENT";
        String newLastName = "Smith";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateLastName(nonexistentId, newLastName);
        });
    }
        
    @Test
    @DisplayName("Update last name with invalid value should throw exception")
    void testUpdateLastNameInvalid() {
        // Arrange
        Contact contact = createValidContact();
        service.addContact(contact);
        String invalidLastName = "TooLongLastName"; // 15 chars

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateLastName(VALID_ID, invalidLastName);
        });
    }

    // ==================== Update Phone Tests ====================

    @Test
    @DisplayName("Update phone should succeed")
    void testUpdatePhone() {
        // Arrange
        Contact contact = createValidContact();
        service.addContact(contact);
        String newPhone = "9876543210";

        // Act
        service.updatePhone(VALID_ID, newPhone);

        // Assert
        assertEquals("9876543210", service.getContact(VALID_ID).getPhone());
    }

    @Test
    @DisplayName("Update phone of nonexistent contact should throw exception")
    void testUpdatePhoneNonexistent() {
        // Arrange
        String nonexistentId = "NONEXISTENT";
        String newPhone = "9876543210";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone(nonexistentId, newPhone);
        });
    }

    @Test
    @DisplayName("Update phone with invalid value should throw exception")
    void testUpdatePhoneInvalid() {
        // Arrange
        Contact contact = createValidContact();
        service.addContact(contact);
        String invalidPhone = "123"; // Not 10 digits

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone(VALID_ID, invalidPhone);
        });
    }

    // ==================== Update Address Tests ====================

    @Test
    @DisplayName("Update address should succeed")
    void testUpdateAddress() {
        // Arrange
        Contact contact = createValidContact();
        service.addContact(contact);
        String newAddress = "456 Oak Avenue";

        // Act
        service.updateAddress(VALID_ID, newAddress);

        // Assert
        assertEquals("456 Oak Avenue", service.getContact(VALID_ID).getAddress());
    }

    @Test
    @DisplayName("Update address of nonexistent contact should throw exception")
    void testUpdateAddressNonexistent() {
        // Arrange
        String nonexistentId = "NONEXISTENT";
        String newAddress = "456 Oak Avenue";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateAddress(nonexistentId, newAddress);
        });
    }

    @Test
    @DisplayName("Update address with invalid value should throw exception")
    void testUpdateAddressInvalid() {
        // Arrange
        Contact contact = createValidContact();
        service.addContact(contact);
        String invalidAddress = "This address is way too long for the 30 character limit";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateAddress(VALID_ID, invalidAddress);
        });
    }
}
