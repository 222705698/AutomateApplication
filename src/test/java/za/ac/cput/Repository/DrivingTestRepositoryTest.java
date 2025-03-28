package za.ac.cput.Repository;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.DrivingTest;
import za.ac.cput.Domain.DrivingTest;
import za.ac.cput.Domain.TestAppointment;
import za.ac.cput.Factory.DrivingTestFactory;

import static org.junit.jupiter.api.Assertions.*;

class DrivingTestRepositoryTest {
    private static IDrivingTestRepository repository =DrivingTestRepository.getIRepository();

    public TestAppointment testAppointment = new TestAppointment();
    private DrivingTest test1 = DrivingTestFactory.createDrivingTestFactory("Sinokholo", testAppointment);
    private DrivingTest test2 = DrivingTestFactory.createDrivingTestFactory("Sinokholo", testAppointment);

    @Test
    @Order(1)
    void testCreate() {
        DrivingTest TestAppointedObjCreated = repository.create(test1);
        assertNotNull(TestAppointedObjCreated, "DrivingTest created" );
        System.out.println(TestAppointedObjCreated.toString());

    }
    @Test
    @Order(2)
    void testreadexaminer() {
        repository.create(test1);
        DrivingTest read = repository.read(test1.getExaminer());
        assertNotNull(read);
        assertEquals(test1.getExaminer(), read.getExaminer(), "DrivingTest read" );
        System.out.println("DrivingTest read" + read.toString());
    }
    @Test
    @Order(3)

    void testUpdatetest() {
        repository.create(test1);
        DrivingTest DrivingTestObjUpdate = repository.update(test1);
        assertNotNull(DrivingTestObjUpdate);
        assertEquals(test1.getTest(), DrivingTestObjUpdate.getTest(), "DrivingTest updated");
        System.out.println(" " + DrivingTestObjUpdate.toString());
    }

    @Test
    @Order(4)
    void testDeletetestID() {
         assertFalse(repository.delete(test1.getTestID()), "DrivingTest deleted" );
        assertNull(repository.read(test1.getTestID()), "testID deleted" );
        System.out.println("DrivingTest deleted " + test1.getTestID());

    }
    @Order(5)
    void testgetAll() {
        System.out.println(repository.getAll());
    }


}