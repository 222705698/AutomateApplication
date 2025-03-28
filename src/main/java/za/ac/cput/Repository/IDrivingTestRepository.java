package za.ac.cput.Repository;

import za.ac.cput.Domain.DrivingTest;

import java.util.List;

public interface IDrivingTestRepository extends IRepository <DrivingTest, String>{
    List<DrivingTest> getAll();
}
