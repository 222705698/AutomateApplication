package za.ac.cput.Factory;
import za.ac.cput.Domain.License;
import za.ac.cput.Util.Helper;

import java.time.LocalDate;

public class LicenseFactory {

    public static License createLicense(String licenseID, String licenseType, LocalDate issueDate, LocalDate expiryDate) {
        String LicenseID = Helper.generateID("LIC");

        if( Helper.isNullOrEmpty(licenseID)
                || Helper.isNullOrEmpty(licenseType)
                || Helper.isNullOrEmpty(String.valueOf(issueDate))
                || Helper.isNullOrEmpty(String.valueOf(expiryDate)))
            return null;
        return new License.LicenseBuilder()
                .setLicenseID(LicenseID)
                .setLicenseType(licenseType)
                .setIssueDate(issueDate)
                .setExpiry(expiryDate).build();


    }}












