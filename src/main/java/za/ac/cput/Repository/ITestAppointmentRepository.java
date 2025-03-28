package za.ac.cput.Repository;
//Sinokholo Singazi 222705698
import za.ac.cput.Domain.TestAppointment;

import java.util.List;

public interface ITestAppointmentRepository extends IRepository<TestAppointment, String >{
    List<TestAppointment> getAll();
}
