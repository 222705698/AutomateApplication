package za.ac.cput.Repository;
//Sinokholo Singazi 222705698
import za.ac.cput.Domain.TestAppointment;

import java.util.ArrayList;
import java.util.List;

public class TestAppointmentRepository implements ITestAppointmentRepository {
    private static TestAppointmentRepository repository = null;
    private List<TestAppointment> testAppointmentList;

    private TestAppointmentRepository() {
        this.testAppointmentList = new ArrayList<>();
    }

    public static TestAppointmentRepository getIRepository() {
        if (repository == null) {
            repository = new TestAppointmentRepository();
        }
        return repository;
    }

    @Override
    public TestAppointment create(TestAppointment testAppointment) {
        this.testAppointmentList.add(testAppointment);
        return testAppointment;
    }

    @Override
    public TestAppointment read(String testID) {
        for (TestAppointment testAppointment : testAppointmentList) {
            if (testAppointment.getTestID().equals(testID)) {
                return testAppointment;
            }
        }
        return null;
    }

    @Override
    public TestAppointment update(TestAppointment testAppointment) {
        for (int i = 0; i < testAppointmentList.size(); i++) {
            if (testAppointmentList.get(i).getTestID().equals(testAppointment.getTestID())) {
                testAppointmentList.set(i, testAppointment);
                return testAppointment;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String testID) {
        for (TestAppointment TestAppointment : testAppointmentList) {
            if (TestAppointment.getTestID().equals(testAppointmentList)) {
                testAppointmentList.remove(TestAppointment);
                return true;
            }
        }
        System.out.println("TestAppointmentTestRepository deleted");
        return false;
    }
    @Override
    public List<TestAppointment> getAll() {
        return new ArrayList<>(testAppointmentList);
    }
}
