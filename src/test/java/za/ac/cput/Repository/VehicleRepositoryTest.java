package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import za.ac.cput.Domain.Vehicle;
import za.ac.cput.Factory.VehicleFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class VehicleRepositoryTest {
   private static IVehicleRepository repository = VehicleRepository.getIRepository();

   private Vehicle vehicle = VehicleFactory.CreateVehicle("VH1209876","BMW","S3BMW","2024","RED","B09876", LocalDate.parse("2020-06-03"));
    @Test
    void a_create() {
        Vehicle reactedVehicle = repository.create(vehicle);
        assertNotNull(reactedVehicle);
        System.out.println( "My vehicle succefully Created: " +reactedVehicle.toString());
    }

    @Test
    void b_read() {
     Vehicle read = repository.read(vehicle.getVehicleID());
     assertNotNull(read);
      System.out.println(" Reading My vehicle: " +read.toString());
    }

    @Test
    void c_update() {
        Vehicle newVehicle = new Vehicle.VehicleBuilder().copy(vehicle).setVehicleType("POLO").build();
        Vehicle updatedVehicle = repository.update(newVehicle);
        assertNotNull(updatedVehicle);
        System.out.println("Updated Vehicle: " +updatedVehicle.toString());
    }

    @Test
    @Disabled
    void d_delete() {
        assertFalse(repository.delete(vehicle.getVehicleID()));
        System.out.println("sucessuly deleted a Vehicle");
    }

    @Test
    void e_getAll() {
        System.out.println(repository.getAll());
    }
}