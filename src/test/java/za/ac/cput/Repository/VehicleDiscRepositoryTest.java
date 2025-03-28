package za.ac.cput.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Domain.Vehicle;
import za.ac.cput.Domain.VehicleDisc;
import za.ac.cput.Factory.VehicleDiscFactory;
import za.ac.cput.Factory.VehicleFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class VehicleDiscRepositoryTest {
    private static IVehicleDiscRepository repository = VehicleDiscRepository.getIRepository();
    private VehicleDisc vehicle = VehicleDiscFactory.CreateVehicleDisc("DSC23456" , LocalDate.parse("2025-06-01") ,"Valid", LocalDate.parse("2024-05-03"));

    @Test
    void a_create() {
    }

    @Test
    void b_read() {
    }

    @Test
    void c_update() {
    }

    @Test
    void d_delete() {
    }

    @Test
    void e_getAll() {
    }
}