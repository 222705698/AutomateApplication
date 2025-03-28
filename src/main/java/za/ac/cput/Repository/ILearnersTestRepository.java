package za.ac.cput.Repository;

import za.ac.cput.Domain.LearnersTest;
import za.ac.cput.Domain.License;

import java.util.List;

public interface ILearnersTestRepository extends IRepository<LearnersTest,String> {


    List<LearnersTest> getAll();
}
