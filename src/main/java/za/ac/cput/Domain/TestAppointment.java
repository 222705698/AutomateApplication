package za.ac.cput.Domain;

import java.time.LocalDate;

public class TestAppointment {
    private String testID;
    private String testAddress;
    private String testVenue;
    private LocalDate testDate;
    private Boolean testResult;
    private String licenceCode;
    private int testAmount;

    public TestAppointment() {
    }
    private TestAppointment(Builder builder) {
        this.testID = builder.testID;
        this.testAddress = builder.testAddress;
        this.testVenue = builder.testVenue;
        this.testDate = builder.testDate;
        this.testResult = builder.testResult;
        this.licenceCode = builder.licenceCode;
        this.testAmount = builder.testAmount;

    }

    public String getLicenceCode() {
        return licenceCode;
    }

    public String getTestAddress() {
        return testAddress;
    }

    public int getTestAmount() {
        return testAmount;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public String getTestID() {
        return testID;
    }

    public Boolean getTestResult() {
        return testResult;
    }

    public String getTestVenue() {
        return testVenue;
    }


    @Override
    public String toString() {
        return "Test{" +
                "licenceCode='" + licenceCode + '\'' +
                ", testID='" + testID + '\'' +
                ", testAddress='" + testAddress + '\'' +
                ", testVenue='" + testVenue + '\'' +
                ", testDate=" + testDate +
                ", testResult=" + testResult +
                ", testAmount=" + testAmount +
                '}';
    }
    public static class Builder{
        private String testID;
        private String testAddress;
        private String testVenue;
        private LocalDate testDate;
        private Boolean testResult;
        private String licenceCode;
        private int testAmount;

        public Builder setLicenceCode(String licenceCode) {
            this.licenceCode = licenceCode;
            return this;
        }

        public Builder setTestAddress(String testAddress) {
            this.testAddress = testAddress;
            return this;
        }

        public Builder setTestAmount(int testAmount) {
            this.testAmount = testAmount;
            return this;
        }

        public Builder setTestDate(LocalDate testDate) {
            this.testDate = testDate;
            return this;
        }

        public Builder setTestID(String testID) {
            this.testID = testID;
            return this;
        }

        public Builder setTestResult(Boolean testResult) {
            this.testResult = testResult;
            return this;
        }

        public Builder setTestVenue(String testVenue) {
            this.testVenue = testVenue;
            return this;
        }
        public TestAppointment build() {
            return new TestAppointment(this);

        }

    }
}