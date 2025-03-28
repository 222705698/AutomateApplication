package za.ac.cput.Repository;

import za.ac.cput.Domain.Vehicle;

import java.util.List;

public interface IVehicleRepository extends IRepository<Vehicle ,String >{
    List<Vehicle> getAll();
}
