package za.ac.cput.Repository;
//Sinokholo Singazi 222705698
import za.ac.cput.Domain.DrivingTest;

import java.util.ArrayList;
import java.util.List;

public class DrivingTestRepository implements IDrivingTestRepository {
    private static DrivingTestRepository repository = null;
    private List<DrivingTest> DrivingTestList;

    private DrivingTestRepository() {DrivingTestList = new ArrayList<DrivingTest>();}

    public static DrivingTestRepository getIRepository() {
        if (repository == null) {
            repository = new DrivingTestRepository();
        }
        return repository;
    }
    @Override
    public DrivingTest create(DrivingTest drivingTest){
        boolean success = DrivingTestList.add(drivingTest);
        if(success){
            return drivingTest;
        }
        System.out.println("DrivingTestRepository created");
        return null;
    }
    @Override
    public DrivingTest read(String driverLicenseID) {
        for (DrivingTest drivingTest : DrivingTestList) {
            if (drivingTest.getDriverLicenseID().equals(drivingTest.getDriverLicenseID())) {
                return drivingTest;
            }

        }
        System.out.println("DrivingTestRepository read");
        return null;
    }

    @Override
    public DrivingTest update(DrivingTest drivingTest) {
        for (int i = 0; i <DrivingTestList.size(); i++) {
            DrivingTestList.set(i, drivingTest);
            return drivingTest;
        }
        System.out.println("DrivingTestRepository updated");
        return null;
    }

    @Override
    public boolean delete(String driverLicenseID) {
        for (DrivingTest drivingTest : DrivingTestList) {
            if (drivingTest.getDriverLicenseID().equals(driverLicenseID)) {
                DrivingTestList.remove(drivingTest);
                return true;
            }
        }
        System.out.println("DrivingTestRepository deleted");
        return false;
    }

    @Override
    public List<DrivingTest> getAll() {
        return new ArrayList<>(DrivingTestList);
    }
}


