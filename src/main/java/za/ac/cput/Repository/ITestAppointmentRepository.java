package za.ac.cput.Repository;

import za.ac.cput.Domain.TestAppointment;

import java.util.List;

public interface ITestAppointmentRepository extends IRepository<TestAppointment, String >{
    List<TestAppointment> getAll();
}
