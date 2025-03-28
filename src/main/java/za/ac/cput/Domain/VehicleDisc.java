package za.ac.cput.Domain;

import java.time.LocalDate;

public class VehicleDisc {
    private String VehicleDiscID;
    private LocalDate expiryDate;
    private String status;
    private LocalDate issueDate;

    private VehicleDisc() {
    }
    private VehicleDisc (DiscBuilder build){
        this.VehicleDiscID = build.VehicleDiscID;
        this.expiryDate = build.expiryDate;
        this.status = build.status;
        this.issueDate = build.issueDate;

    }
    public String getVehicleDiscID() {
        return VehicleDiscID;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    @Override
    public String toString() {
        return "VehicleDisc{" +
                "VehicleDiscID='" + VehicleDiscID + '\'' +
                ", expiryDate=" + expiryDate +
                ", status='" + status + '\'' +
                ", issueDate=" + issueDate +
                '}';
    }

    public static class DiscBuilder {
        private String VehicleDiscID;
        private LocalDate expiryDate;
        private String status;
        private LocalDate issueDate;

        public DiscBuilder setVehicleDiscID(String vehicleDiscID) {
            VehicleDiscID = vehicleDiscID;
            return this;
        }

        public DiscBuilder setExpiryDate(LocalDate expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public DiscBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public DiscBuilder setIssueDate(LocalDate issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public VehicleDisc build() {
            return new VehicleDisc(this);
        }
    }
}
