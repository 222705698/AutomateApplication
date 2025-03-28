package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.TestAppointment;
import za.ac.cput.Factory.TestAppointmentFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TestAppointmentFactoryTest {
    private TestAppointment test1;
    private TestAppointment test2;

    @BeforeEach
    void setUp() {
        test1 = TestAppointmentFactory.createTestAppointmentFactory(
                "000361", "Woodstock", "Cape Town",
                LocalDate.of(2025, 5, 1), 1600, "Y5679", true);

        test2 = TestAppointmentFactory.createTestAppointmentFactory(
                "000362", "10 Dorset Street", "Cape Town",
                LocalDate.of(2025, 3, 7), 1500, "X1234", false);

        assertNotNull(test1, "TestAppointment test1 should be created successfully");
        assertNotNull(test2, "TestAppointment test2 should be created successfully");

        System.out.println("TestAppointment 1: " + test1);
        System.out.println("TestAppointment 2: " + test2);
    }

    @Test
    void testCreateTestAppointment_Success() {
        assertNotNull(test1, "TestAppointment should be created successfully");
        assertEquals("000361", test1.getTestID(), "Test ID should match");
        assertEquals("Woodstock", test1.getTestAddress(), "Test address should match");
        assertEquals("Cape Town", test1.getTestVenue(), "Test venue should match");
        assertEquals(LocalDate.of(2025, 5, 1), test1.getTestDate(), "Test date should match");
        assertEquals(1600, test1.getTestAmount(), "Test amount should match");
        assertEquals("Y5679", test1.getLicenceCode(), "Licence code should match");
        assertTrue(test1.getTestResult(), "Test result should be true");
    }

    @Test
    void testCreateTestAppointment_NullValues_ShouldReturnNull() {
        TestAppointment invalidTestAppointment = TestAppointmentFactory.createTestAppointmentFactory("000363", null, "Cape Town", LocalDate.of(2025, 5, 1), 1600, "Y5679", true);

        assertNull(invalidTestAppointment, "Factory should return null when address is null");
    }

    @Test
    void testCreateTestAppointment_EmptyLicenceCode_ShouldReturnNull() {
        TestAppointment invalidTestAppointment = TestAppointmentFactory.createTestAppointmentFactory("000364", "Dorset Street", "Cape Town", LocalDate.of(2025, 5, 1), 1600, null, true);
        //TestAppointment invalidTestAppointment = TestAppointmentFactory.createTestAppointmentFactory("000364", "Dorset Street", "Cape Town", LocalDate.of(2025, 5, 1), 1600, null, true);

        assertNull(invalidTestAppointment, "Factory should return null when licence code is empty");
    }

    @Test
    void testCreateTestAppointment_InvalidDate_ShouldReturnNull() {
        TestAppointment invalidTestAppointment = TestAppointmentFactory.createTestAppointmentFactory("000365", "Dorset Street", "Cape Town", null, 1600, "Y5679", true);

        assertNull(invalidTestAppointment, "Factory should return null when test date is null");
    }
}