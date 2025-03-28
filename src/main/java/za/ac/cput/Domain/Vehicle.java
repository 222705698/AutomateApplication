package za.ac.cput.Domain;

import java.time.LocalDate;

public class Vehicle {
    private String vehicleID;
    private String vehicleType;
    private String vehicleModel;
    private String vehicleYear;
    private String vehicleColor;
    private String registrationNumber;
    private LocalDate registrationDate;

    private Vehicle() {
    }

    //will contract a builder constructor
    private Vehicle(VehicleBuilder build) {
        this.vehicleID = build.vehicleID;
        this.vehicleType = build.vehicleType;
        this.vehicleModel = build.vehicleModel;
        this.vehicleYear = build.vehicleYear;
        this.vehicleColor = build.vehicleColor;
        this.registrationNumber = build.registrationNumber;
        this.registrationDate = build.registrationDate;


    }

    public String getVehicleID() {
        return vehicleID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleYear() {
        return vehicleYear;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID='" + vehicleID + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleYear='" + vehicleYear + '\'' +
                ", vehicleColor='" + vehicleColor + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }

    public static class VehicleBuilder {
        private String vehicleID;
        private String vehicleType;
        private String vehicleModel;
        private String vehicleYear;
        private String vehicleColor;
        private String registrationNumber;
        private LocalDate registrationDate;

        public VehicleBuilder setVehicleID(String vehicleID) {
            this.vehicleID = vehicleID;
            return this;
        }

        public VehicleBuilder setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
            return this;
        }

        public VehicleBuilder setVehicleYear(String vehicleYear) {
            this.vehicleYear = vehicleYear;
            return this;
        }

        public VehicleBuilder setVehicleModel(String vehicleModel) {
            this.vehicleModel = vehicleModel;
            return this;
        }

        public VehicleBuilder setVehicleColor(String vehicleColor) {
            this.vehicleColor = vehicleColor;
            return this;
        }

        public VehicleBuilder setRegistrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
            return this;
        }

        public VehicleBuilder setRegistrationDate(LocalDate registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }
        public VehicleBuilder copy(Vehicle vehicle) {
            this.vehicleID = vehicle.vehicleID;
            this.vehicleType = vehicle.vehicleType;
            this.vehicleModel = vehicle.vehicleModel;
            this.vehicleYear = vehicle.vehicleYear;
            this.vehicleColor = vehicle.vehicleColor;
            this.registrationNumber = vehicle.registrationNumber;
            this.registrationDate = vehicle.registrationDate;
            return this;
        }
        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}
