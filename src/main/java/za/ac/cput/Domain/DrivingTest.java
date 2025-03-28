package za.ac.cput.Domain;
//Sinokholo Singazi 222705698
public class DrivingTest extends TestAppointment {
    private String driverLicenseID;
    private String examiner;
    private TestAppointment test;

    public DrivingTest() {
    }
    private DrivingTest(Builder builder) {
        this.driverLicenseID = builder.driverLicenseID;
        this.examiner = builder.examiner;
    }

    public String getDriverLicenseID() {
        return driverLicenseID;
    }

    public String getExaminer() {
        return examiner;
    }

    public TestAppointment getTest() {
        return test;
    }

    @Override
    public String toString() {
        return "DrivingTest{" +
                "driverLicenseID='" + driverLicenseID + '\'' +
                ", examiner='" + examiner + '\'' +
                ", test=" + test +
                '}';
    }

    public static class Builder {
        private String driverLicenseID;
        private String examiner;
        private TestAppointment test;

        public Builder setDriverLicenseID(String driverLicenseID) {
            this.driverLicenseID = driverLicenseID;
            return this;
        }

        public Builder setExaminer(String examiner) {
            this.examiner = examiner;
            return this;
        }

        public Builder setTest(TestAppointment test) {
            this.test = test;
            return this;
        }
        public DrivingTest.Builder copy(Builder builder) {
            this.driverLicenseID = builder.driverLicenseID;
            this.examiner = builder.examiner;
            this.test = builder.test;
            return this;
        }

        public DrivingTest build() {
            return new DrivingTest(this);
        }
    }
}
