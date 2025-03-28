package za.ac.cput.Domain;

import java.time.LocalDate;

public class License {
    private String licenseID;
    private String licenseType;
    private LocalDate issueDate;
    private LocalDate expiryDate;

    public License() {}

    private License (LicenseBuilder builder){

        this.licenseID = builder.licenseID;
        this.licenseType= builder.licenseType;
        this.expiryDate = builder.expiryDate;
        this.issueDate = builder.issueDate;
    }

    public String getLicenseID() {
        return licenseID;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public LocalDate getIssueDate() {
        return issueDate;

    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }


    @Override
    public String toString() {
        return "LicenseID{" +
                "licenseID='" + licenseID + '\'' +
                ", licenseType='" + licenseType + '\'' +
                ", issueDate=" + issueDate +
                ", expiryDate='" + expiryDate + '\'' +
                '}';
    }
    public static class LicenseBuilder {

        private String licenseID;
        private String licenseType;
        private LocalDate issueDate;
        private LocalDate expiryDate;

        public LicenseBuilder  setLicenseID(String licenseID) {
            this.licenseID = licenseID;
            return this;
        }

        public LicenseBuilder  setLicenseType(String licenseType) {
            this.licenseType = licenseType;
            return this;


        }

        public LicenseBuilder  setIssueDate(LocalDate issueDate) {
            this.issueDate = issueDate;
            return this;

        }

        public LicenseBuilder  setExpiry(LocalDate expiryDate) {
            this.expiryDate = expiryDate;
            return this;

        }
        public License build() {
            return new License (this);
        }
    }

}
