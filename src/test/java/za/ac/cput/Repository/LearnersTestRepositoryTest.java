package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import za.ac.cput.Domain.LearnersTest;
import za.ac.cput.Domain.TestAppointment;
import za.ac.cput.Factory.LearnersTestFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LearnersTestRepositoryTest {
    private static LearnersTestRepository repository = LearnersTestRepository.getRepository();
    private static TestAppointment testAppointment = new TestAppointment();

    private static LearnersTest test1 = LearnersTestFactory.createLearnersTestFactory("85%", testAppointment);
    private static LearnersTest test2 = LearnersTestFactory.createLearnersTestFactory("90%", testAppointment);

    @Test
    @Order(1)
    void testCreate() {
        LearnersTest createdTest = repository.create(test1);
        assertNotNull(createdTest, "LearnersTest should be created");
        System.out.println("Created LearnersTest: " + createdTest);
    }

    @Test
    @Order(2)
    void testRead() {
        repository.create(test1);
        LearnersTest readTest = repository.read(test1.getLearnersTestID());
        assertNotNull(readTest, "LearnersTest should be read successfully");
        assertEquals(test1.getLearnersTestID(), readTest.getLearnersTestID(), "LearnersTest ID should match");
        System.out.println("Read LearnersTest: " + readTest);
    }

    @Test
    @Order(3)
    void testUpdate() {
        repository.create(test1);

        LearnersTest updatedTest = new LearnersTest.Builder()
                .setLearnersTestID(test1.getLearnersTestID())
                .settestScore("95%")
                .setTest(test1.getTest())
                .build();

        LearnersTest result = repository.update(updatedTest);
        assertNotNull(result, "LearnersTest should be updated successfully");
        assertEquals("95%", result.gettestScore(), "LearnersTest score should be updated");
        System.out.println("Updated LearnersTest: " + result);
    }

    @Test
    @Order(4)
    void testDelete() {
        repository.create(test1);
        assertTrue(repository.delete(test1.getLearnersTestID()), "LearnersTest should be deleted successfully");
       // assertNull(repository.read(test1.getLearnersTestID()), "Deleted LearnersTest should not exist in repository");
        System.out.println("Deleted LearnersTest ID: " + test1.getLearnersTestID());
    }

    @Test
    @Order(5)
    void testGetAll() {
        repository.create(test1);
        repository.create(test2);
        System.out.println("All LearnersTests: " + repository.getAll());
        assertTrue(repository.getAll().size() >= 2, "Should have at least 2 LearnersTests in repository");
    }
}
