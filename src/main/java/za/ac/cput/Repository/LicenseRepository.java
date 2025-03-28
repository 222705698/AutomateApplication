package za.ac.cput.Repository;

import za.ac.cput.Domain.License;
import java.util.ArrayList;
import java.util.List;

public class LicenseRepository implements ILicenseRepository {
    private static LicenseRepository repository = null;
    private List<License> licenseList;

    private LicenseRepository() {
        licenseList = new ArrayList<>();
    }

    public static LicenseRepository getRepository() {
        if (repository == null) {
            repository = new LicenseRepository();
        }
        return repository;
    }

    @Override
    public License create(License license) {
        boolean success = licenseList.add(license);
        if (success) {
            return license;
        }
        System.out.println("License not successfully added");
        return null;
    }

    @Override
    public License read(String licenseId) {
        for (License license : licenseList) {
            if (license.getLicenseID().equals(licenseId)) {
                return license;
            }
        }
        System.out.println("License not found");
        return null;
    }

    @Override
    public License update(License license) {
        for (int i = 0; i < licenseList.size(); i++) {
            if (licenseList.get(i).getLicenseID().equals(license.getLicenseID())) {
                licenseList.set(i, license);
                return license;
            }
        }
        System.out.println("License not found for update");
        return null;
    }

    @Override
    public boolean delete(String licenseId) {
        for (License license : licenseList) {
            if (license.getLicenseID().equals(licenseId)) {
                licenseList.remove(license);
                return true;
            }
        }
        System.out.println("License not successfully deleted");
        return false;
    }

    @Override
    public List<License> getAll() {
        return new ArrayList<>(licenseList);
    }
}