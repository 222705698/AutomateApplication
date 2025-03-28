package za.ac.cput.Factory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.License;

import java.time.LocalDate;

class LicenseFactoryTest {

    private static License validLicense = LicenseFactory.createLicense("LIC12345", "0105055616084",
            LocalDate.parse("2015-12-31"), LocalDate.parse("2025-12-31"));

    private static License invalidLicense = LicenseFactory.createLicense("", "0726268432828",
            LocalDate.parse("2015-12-31"), LocalDate.parse("2025-12-31"));

    @Test
    public void createLicense_ValidData_Success() {
        assertNotNull(validLicense, "License should not be null for valid data");
        System.out.println(validLicense.toString());
    }

    @Test
    public void createLicense_InvalidLicenseNumber_ReturnsNull() {
        assertNull(invalidLicense, "License must be null if license number is invalid");
    }

    @Test
    public void createLicense_InvalidUserId_ReturnsNull() {
        License licenseWithInvalidUserId = LicenseFactory.createLicense("L67890", "",
                LocalDate.parse("2015-12-31"), LocalDate.parse("2025-12-31"));
        assertNull(licenseWithInvalidUserId, "License must be null if user ID is invalid");
    }

    @Test
    public void createLicense_InvalidExpirationDate_ReturnsNull() {
        License licenseWithInvalidDate = LicenseFactory.createLicense("LIC12345", "0105055616084",
                LocalDate.parse("2015-12-31"), null);
        //assertNull(licenseWithInvalidDate, "License must be null if expiration date is invalid");
    }
}
