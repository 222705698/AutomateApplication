package za.ac.cput.Factory;

import za.ac.cput.Domain.Vehicle;
import za.ac.cput.Util.Helper;

import java.time.LocalDate;

public class VehicleFactory {
    public static Vehicle CreateVehicle(String vehicleID,String vehicleType, String vehicleModel, String vehicleYear,String vehicleColor, String registrationNumber, LocalDate registrationDate) {
        if (Helper.isNullOrEmpty(vehicleType) || Helper.isNullOrEmpty(vehicleModel) || Helper.isNullOrEmpty(vehicleYear) || Helper.isNullOrEmpty(vehicleColor) || Helper.isNullOrEmpty(registrationNumber) ||Helper.isNullOrEmpty(String.valueOf(registrationDate)) ){
            return null;
        }
        //String vehicleID = Helper.generateID("VEH-");
       return new Vehicle.VehicleBuilder().setVehicleID(vehicleID)
               .setVehicleType(vehicleType)
               .setVehicleModel(vehicleModel)
               .setVehicleYear(vehicleYear)
               .setVehicleColor(vehicleColor)
               .setRegistrationNumber(registrationNumber)
               .setRegistrationDate(registrationDate)
               .build();
    }


}
