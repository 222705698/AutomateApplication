package za.ac.cput.Repository;

import za.ac.cput.Domain.VehicleDisc;

import java.util.List;

public interface IVehicleDiscRepository extends IRepository <VehicleDisc ,String> {
    List<VehicleDisc> getAll();
}
