package za.ac.cput.Repository;
//Sinokholo Singazi 222705698
import za.ac.cput.Domain.DrivingTest;

import java.util.List;

public interface IDrivingTestRepository extends IRepository <DrivingTest, String>{
    List<DrivingTest> getAll();
}
