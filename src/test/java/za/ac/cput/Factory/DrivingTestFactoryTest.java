package za.ac.cput.Factory;

import org.junit.jupiter.api.*;
import za.ac.cput.Domain.DrivingTest;
import za.ac.cput.Domain.TestAppointment;

import java.time.LocalDate;

//import static com.sun.tools.classfile.Attribute.Code;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DrivingTestFactoryTest {
    private TestAppointment testAppointment;

    @BeforeEach
    void setUp() {
        // Initialize a valid Test instance before each test
        testAppointment = TestAppointmentFactory.createTestAppointmentFactory("0016789695494",
                "123 Main Street",     // Test Address
                "CPUT Testing Center", // Test Venue
                LocalDate.of(2025, 5, 10), // Test Date
                1500, //Test Result (Passed)
                "B", //Licence Code
                true  // Test Amount
        );
    }

    @Test
    @Order(1)
    void createDrivingTestFactory() {
        // Arrange
        String examiner = "John Doe";

        // Act
        DrivingTest drivingTest = DrivingTestFactory.createDrivingTestFactory(examiner, testAppointment);

        // Assert
        assertNotNull(drivingTest, "DrivingTest should not be null");
        assertNotNull(drivingTest.getDriverLicenseID(), "Driver License ID should be generated");
        assertEquals(examiner, drivingTest.getExaminer(), "Examiner should match");
        // assertEquals(testAppointment, drivingTest.getTest(), "Test object should match");

        System.out.println(drivingTest);
    }



}