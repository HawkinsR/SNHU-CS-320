package contact;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    // Valid test data
    private static final String VALID_ID = "1234567890";
    private static final String VALID_FIRST_NAME = "John";
    private static final String VALID_LAST_NAME = "Doe";
    private static final String VALID_PHONE = "5551234567";
    private static final String VALID_ADDRESS = "123 Main Street";

    // ==================== Contact Creation Tests ====================

    @Test
    @DisplayName("Contact creation with valid data should succeed")
    void testContactCreationValid() {
        // Arrange
        String id = VALID_ID;
        String firstName = VALID_FIRST_NAME;
        String lastName = VALID_LAST_NAME;
        String phone = VALID_PHONE;
        String address = VALID_ADDRESS;

        // Act
        Contact contact = new Contact(id, firstName, lastName, phone, address);

        // Assert
        assertEquals(VALID_ID, contact.getContactId());
        assertEquals(VALID_FIRST_NAME, contact.getFirstName());
        assertEquals(VALID_LAST_NAME, contact.getLastName());
        assertEquals(VALID_PHONE, contact.getPhone());
        assertEquals(VALID_ADDRESS, contact.getAddress());
    }

    // ==================== Contact ID Tests ====================

    @Test
    @DisplayName("Contact ID cannot be null")
    void testContactIdNull() {
        // Arrange
        String nullId = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(nullId, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    @DisplayName("Contact ID cannot be longer than 10 characters")
    void testContactIdTooLong() {
        // Arrange
        String longId = "12345678901"; // 11 characters

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(longId, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    @DisplayName("Contact ID with exactly 10 characters should be valid")
    void testContactIdExactlyTenChars() {
        // Arrange
        String tenCharId = "1234567890"; // 10 characters

        // Act
        Contact contact = new Contact(tenCharId, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);

        // Assert
        assertEquals(tenCharId, contact.getContactId());
    }

    // ==================== First Name Tests ====================

    @Test
    @DisplayName("First name cannot be null")
    void testFirstNameNull() {
        // Arrange
        String nullFirstName = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_ID, nullFirstName, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    @DisplayName("First name cannot be longer than 10 characters")
    void testFirstNameTooLong() {
        // Arrange
        String longFirstName = "JohnJohnJoh"; // 11 characters

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_ID, longFirstName, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    @DisplayName("First name with exactly 10 characters should be valid")
    void testFirstNameExactlyTenChars() {
        // Arrange
        String tenCharName = "JohnJohnJo"; // 10 characters

        // Act
        Contact contact = new Contact(VALID_ID, tenCharName, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);

        // Assert
        assertEquals(tenCharName, contact.getFirstName());
    }

    @Test
    @DisplayName("First name can be updated with valid value")
    void testSetFirstNameValid() {
        // Arrange
        Contact contact = new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        String newFirstName = "Jane";

        // Act
        contact.setFirstName(newFirstName);

        // Assert
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    @DisplayName("Setting first name to null should throw exception")
    void testSetFirstNameNull() {
        // Arrange
        Contact contact = new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    // ==================== Last Name Tests ====================

    @Test
    @DisplayName("Last name cannot be null")
    void testLastNameNull() {
        // Arrange
        String nullLastName = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_ID, VALID_FIRST_NAME, nullLastName, VALID_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    @DisplayName("Last name cannot be longer than 10 characters")
    void testLastNameTooLong() {
        // Arrange
        String longLastName = "DoeDoeDoeD1"; // 11 characters

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_ID, VALID_FIRST_NAME, longLastName, VALID_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    @DisplayName("Last name with exactly 10 characters should be valid")
    void testLastNameExactlyTenChars() {
        // Arrange
        String tenCharName = "DoeDoeDoeD"; // 10 characters

        // Act
        Contact contact = new Contact(VALID_ID, VALID_FIRST_NAME, tenCharName, VALID_PHONE, VALID_ADDRESS);

        // Assert
        assertEquals(tenCharName, contact.getLastName());
    }

    @Test
    @DisplayName("Last name can be updated with valid value")
    void testSetLastNameValid() {
        // Arrange
        Contact contact = new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        String newLastName = "Smith";

        // Act
        contact.setLastName(newLastName);

        // Assert
        assertEquals("Smith", contact.getLastName());
    }

    // ==================== Phone Tests ====================

    @Test
    @DisplayName("Phone cannot be null")
    void testPhoneNull() {
        // Arrange
        String nullPhone = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, nullPhone, VALID_ADDRESS);
        });
    }

    @Test
    @DisplayName("Phone must be exactly 10 digits - too short")
    void testPhoneTooShort() {
        // Arrange
        String shortPhone = "123456789"; // 9 digits

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, shortPhone, VALID_ADDRESS);
        });
    }

    @Test
    @DisplayName("Phone must be exactly 10 digits - too long")
    void testPhoneTooLong() {
        // Arrange
        String longPhone = "12345678901"; // 11 digits

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, longPhone, VALID_ADDRESS);
        });
    }

    @Test
    @DisplayName("Phone can be updated with valid value")
    void testSetPhoneValid() {
        // Arrange
        Contact contact = new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        String newPhone = "9876543210";

        // Act
        contact.setPhone(newPhone);

        // Assert
        assertEquals("9876543210", contact.getPhone());
    }

    // ==================== Address Tests ====================

    @Test
    @DisplayName("Address cannot be null")
    void testAddressNull() {
        // Arrange
        String nullAddress = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, nullAddress);
        });
    }

    @Test
    @DisplayName("Address cannot be longer than 30 characters")
    void testAddressTooLong() {
        // Arrange
        String longAddress = "1234567890123456789012345678901"; // 31 characters

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, longAddress);
        });
    }

    @Test
    @DisplayName("Address with exactly 30 characters should be valid")
    void testAddressExactlyThirtyChars() {
        // Arrange
        String thirtyCharAddress = "123456789012345678901234567890"; // 30 characters

        // Act
        Contact contact = new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, thirtyCharAddress);

        // Assert
        assertEquals(thirtyCharAddress, contact.getAddress());
    }

    @Test
    @DisplayName("Address can be updated with valid value")
    void testSetAddressValid() {
        // Arrange
        Contact contact = new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
        String newAddress = "456 Oak Avenue";

        // Act
        contact.setAddress(newAddress);

        // Assert
        assertEquals("456 Oak Avenue", contact.getAddress());
    }
}
