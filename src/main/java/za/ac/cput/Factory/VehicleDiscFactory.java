package za.ac.cput.Factory;

import za.ac.cput.Domain.VehicleDisc;
import za.ac.cput.Util.Helper;

import java.time.LocalDate;

public class VehicleDiscFactory {
    public static VehicleDisc CreateVehicleDisc( String VehicleDiscID, LocalDate expiryDate, String status, LocalDate issueDate) {
        if(Helper.isNullOrEmpty(String.valueOf(expiryDate)) || Helper.isNullOrEmpty(status) || Helper.isNullOrEmpty(String.valueOf(issueDate)))
  return null;

        return new VehicleDisc.DiscBuilder()
                .setVehicleDiscID(VehicleDiscID)
                .setExpiryDate(expiryDate)
                .setStatus(status)
                .setIssueDate(issueDate)
                .build();
    }
}
