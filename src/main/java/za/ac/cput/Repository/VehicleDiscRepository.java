package za.ac.cput.Repository;

import za.ac.cput.Domain.Vehicle;
import za.ac.cput.Domain.VehicleDisc;

import java.util.ArrayList;
import java.util.List;

public class VehicleDiscRepository implements IVehicleDiscRepository {
    private static IVehicleDiscRepository repository = null;
    private List<VehicleDisc> vehiclesDiscList;

    private VehicleDiscRepository() {
        vehiclesDiscList= new ArrayList<VehicleDisc>();
    }

    public static IVehicleDiscRepository getIRepository() {
        if (repository == null){
            repository = new VehicleDiscRepository();
        }
        return repository;
    }



    @Override
    public VehicleDisc create(VehicleDisc vehicleDisc) {
        boolean sucess = vehiclesDiscList.add(vehicleDisc);
        if (sucess) {
            return vehicleDisc;
        }
        //System.out.println("not sucessfully added to the list");
        return null;
    }

    @Override
    public VehicleDisc read(String vehicleDiscId) {
        for(VehicleDisc vehicleDisc : vehiclesDiscList){
            if(vehicleDisc.getVehicleDiscID().equals(vehicleDiscId)){
                return vehicleDisc;
            }
        }
        //System.out.println("not sucessfully read from the list");
        return null;
    }

    @Override
    public VehicleDisc update(VehicleDisc vehicleDisc) {
        String id = vehicleDisc.getVehicleDiscID();
        VehicleDisc oldVehicleDisc = read(id);
        if(oldVehicleDisc == null)
            return null;
        boolean sucess = delete(id) ;
        if (sucess) {
            if(vehiclesDiscList.add(vehicleDisc))
                return vehicleDisc;

        }
        return null;
    }

    @Override
    public boolean delete(String vehicleDiscId) {
        VehicleDisc vehicleDiscToDelete = read(vehicleDiscId);  // Find the vehicle
        if (vehicleDiscToDelete == null) {
            return false;  // Return false if the vehicle is not found
        }
        return (vehiclesDiscList.remove(vehicleDiscToDelete));  // Remove and return the result

    }
    @Override
    public List<VehicleDisc> getAll() {
        return vehiclesDiscList;
    }
}
