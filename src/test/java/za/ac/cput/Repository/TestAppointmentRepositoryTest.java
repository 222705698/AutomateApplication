package za.ac.cput.Repository;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.TestAppointment;
import za.ac.cput.Factory.TestAppointmentFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TestAppointmentRepositoryTest {
    private static ITestAppointmentRepository Repository = TestAppointmentRepository.getIRepository();

    private  TestAppointment testing = TestAppointmentFactory.createTestAppointmentFactory("1567", "10 Dorset street", "Cpe town", LocalDate.of(2025, 3, 7 ), 1500, "98765", true);
    private  TestAppointment test2 = TestAppointmentFactory.createTestAppointmentFactory("135678", "10 Dorset street", "Cpe town", LocalDate.of(2025, 3, 7 ), 1500, "98765", true);


    @Test
    @Order(1)
    void testCreate() {
        TestAppointment TestAppointedObjCreated = Repository.create(testing);
        assertNotNull(TestAppointedObjCreated, "TestAppointment created" );
        System.out.println(TestAppointedObjCreated.toString());

    }
    @Test
    @Order(2)
    void testreadlicenceCode() {
        Repository.create(testing);
        TestAppointment read = Repository.read(testing.getTestID());
        assertNotNull(read);
        assertEquals(testing.getTestID(), read.getTestID(), "TestAppointment read" );
        System.out.println("TestAppointment read" + read.toString());
    }
    @Test
    @Order(3)

    void testUpdatetestAdress() {
        Repository.create(testing);
        TestAppointment TestAppointedObjUpdated = Repository.update(testing);
        assertNotNull(TestAppointedObjUpdated);
        assertEquals(testing.getTestID(), TestAppointedObjUpdated.getTestID(), "TestAppointment updated");
        System.out.println(" " + TestAppointedObjUpdated.toString());
    }

        @Test
        @Order(4)
         void testDeletetetestID() {
         // assertFalse(Repository.delete(testing.getTestID()), "TestAppointment deleted" );
         assertNull(Repository.read(testing.getTestID()), "testID deleted" );
         System.out.println("TestAppointment deleted " + testing.getTestID());




    }
    @Test
    @Order(5)
    void getAll() {
        System.out.println(Repository.getAll());
    }

}