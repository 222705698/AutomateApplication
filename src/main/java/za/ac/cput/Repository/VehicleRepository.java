package za.ac.cput.Repository;

import za.ac.cput.Domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository implements IVehicleRepository {
   private static IVehicleRepository repository = null;
   private List<Vehicle> vehiclesList;

   private VehicleRepository() {

       vehiclesList = new ArrayList<Vehicle>();
   }

   public static IVehicleRepository getIRepository() {
       if (repository == null){
           repository = new VehicleRepository();
       }
       return repository;
   }
    @Override
    public Vehicle create(Vehicle vehicle) {
       boolean sucess = vehiclesList.add(vehicle);
       if (sucess) {
           return vehicle;
       }
        //System.out.println("not sucessfully added to the list");
        return null;
   }

    @Override
    public Vehicle read(String vehicleId) {
        for(Vehicle vehicle : vehiclesList){
            if(vehicle.getVehicleID().equals(vehicleId)){
                return vehicle;
            }
        }
        //System.out.println("not sucessfully read from the list");
        return null;
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
      String id = vehicle.getVehicleID();
      Vehicle oldVehicle = read(id);
      if(oldVehicle == null)
          return null;
       boolean sucess = delete(id) ;
       if (sucess) {
           if(vehiclesList.add(vehicle))
               return vehicle;

       }
       return null;

    }

    @Override
    public boolean delete(String vehicleId) {
        Vehicle vehicleToDelete = read(vehicleId);  // Find the vehicle
        if (vehicleToDelete == null)
            return false;  // Return false if the vehicle is not found

        return (vehiclesList.remove(vehicleToDelete));  // Remove and return the result
    }

    @Override
    public List<Vehicle> getAll() {
       return vehiclesList;
    }
}
