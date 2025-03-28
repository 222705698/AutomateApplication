package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import za.ac.cput.Domain.License;
import za.ac.cput.Factory.LicenseFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LicenseRepositoryTest {
    private ILicenseRepository licenseRepository;
    private static License license1;
    private static License license2;

    @BeforeEach
    void setUp() {
        licenseRepository = LicenseRepository.getRepository(); // Initialize repository

        // Initialize test licenses
        license1 = LicenseFactory.createLicense("L12345", "0105055616084", LocalDate.parse("2015-12-31"), LocalDate.parse("2025-12-31"));
        license2 = LicenseFactory.createLicense("L67890", "0726268432828", LocalDate.parse("2016-10-20"), LocalDate.parse("2026-10-20"));

        // Ensure licenses are valid before adding them to the repository
        if (license1 != null) {
            licenseRepository.create(license1);
        }
        if (license2 != null) {
            licenseRepository.create(license2);
        }
    }

    @Test
    @Order(1)
    void createLicense() {
        assertNotNull(license1, "License creation failed: fields may be incorrect");
        assertNotNull(licenseRepository.read(license1.getLicenseID()), "License must be added to the repository");
        System.out.println(license1);
    }

    @Test
    @Order(2)
    void readLicense() {
        License readdLicense = licenseRepository.read(license1.getLicenseID());
        assertNotNull(readdLicense, "License should be retrieved using the given license number");
        System.out.println(readdLicense);
    }

    @Test
    @Order(3)
    void updateLicense() {
        License updatedLicense = new License.LicenseBuilder()
                .setLicenseID(license1.getLicenseID())
                .setLicenseType(license1.getLicenseType())
                .setIssueDate(license1.getIssueDate())
                .setExpiry(LocalDate.parse("2030-12-31")) // Updating expiry date
                .build();

        License result = licenseRepository.update(updatedLicense);
        assertNotNull(result, "License should be updated successfully");
        assertEquals(LocalDate.parse("2030-12-31"), result.getExpiryDate(), "License expiry date should be updated");
        System.out.println("Updated License: " + result);
    }

    @Test
   // @Disabled
    @Order(4)
    void deleteLicense() {
        assertTrue(licenseRepository.delete(license1.getLicenseID()), "License should be deleted successfully");
        assertNull(licenseRepository.read(license1.getLicenseID()), "Deleted license should not exist in the repository");
        System.out.println("Deleted License Number: " + license1.getLicenseID());
    }

    @Test
    @Order(5)
    void testCreateLicense_InvalidData_ReturnsNull() {
        License invalidLicense = LicenseFactory.createLicense("", "0105055616084", LocalDate.parse("2015-12-31"), LocalDate.parse("2025-12-31"));
        assertNull(invalidLicense, "License should be null if license number is invalid");
        System.out.println(invalidLicense);
    }
}
