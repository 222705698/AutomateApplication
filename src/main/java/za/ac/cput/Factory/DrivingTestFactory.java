package za.ac.cput.Factory;
//Sinokholo Singazi 222705698
import za.ac.cput.Domain.DrivingTest;
import za.ac.cput.Domain.TestAppointment;
import za.ac.cput.Util.Helper;

public class DrivingTestFactory {
    public static DrivingTest createDrivingTestFactory(String examiner, TestAppointment test) {
        String driverLicenseID = Helper.gernerateId();
        if (Helper.isNullOrEmpty(examiner))
            return null;

        return new DrivingTest.Builder()
                .setDriverLicenseID(driverLicenseID)
                .setExaminer(examiner)
                .setTest(test)
                .build();
    }
}
