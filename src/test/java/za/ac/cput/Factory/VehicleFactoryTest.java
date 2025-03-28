package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Vehicle;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class VehicleFactoryTest {
    private static Vehicle v1 = VehicleFactory.CreateVehicle("VEH34546","BMW","S3BMW","2023","RED","S23457" , LocalDate.parse("2027-05-03"));

    @Test
    public void CreateVehicle() {
        assertNotNull(v1);
        System.out.println(v1.toString());
    }
  
}
