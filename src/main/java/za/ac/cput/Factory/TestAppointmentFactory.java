package za.ac.cput.Factory;
//Sinokholo Singazi 222705698
import za.ac.cput.Domain.TestAppointment;

import java.time.LocalDate;

public class TestAppointmentFactory {
    public static TestAppointment createTestAppointmentFactory(String testID, String testAddress, String testVenue, LocalDate testDate, int testAmount, String licenceCode, boolean testResult) {
       //String testID = Helper.gernerateId();

        if (testAddress == null || testVenue == null || testDate == null || licenceCode == null  ) {
            return null;
        }
        return new TestAppointment.Builder()
                .setTestID(testID)
                .setTestAddress(testAddress)
                .setTestVenue(testVenue)
                .setTestDate(testDate)
                .setTestResult(testResult)
                .setLicenceCode(licenceCode)
                .setTestAmount(testAmount)
                .build();
    }
}
