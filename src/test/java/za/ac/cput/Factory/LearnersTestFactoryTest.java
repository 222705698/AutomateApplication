package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.LearnersTest;
import za.ac.cput.Domain.TestAppointment;

import static org.junit.jupiter.api.Assertions.*;

class LearnersTestFactoryTest {

//    @Test
//    void testCreateLearnersTestFactory() {
//        TestAppointment testAppointment = new TestAppointment();
//        LearnersTest test = LearnersTestFactory.createLearnersTestFactory("85%", testAppointment);
//
//        assertNotNull(test, "LearnersTest should be created successfully");
//        assertNotNull(test.getLearnersTestID(), "LearnersTest ID should not be null");
//       assertEquals(test.getLearnersTestID(), "Test score should be correctly set");
//
//        System.out.println("Created LearnersTest: " + test);
//    }

    @Test
    void testCreateLearnersTestFactory_NullScore() {
        TestAppointment testAppointment = new TestAppointment();
        LearnersTest test = LearnersTestFactory.createLearnersTestFactory(null, testAppointment);

        assertNull(test, "LearnersTest should not be created with null test score");
    }
}
