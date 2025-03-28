package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Vehicle;
import za.ac.cput.Domain.VehicleDisc;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VehicleDiscFactoryTest {
    private static VehicleDisc disc = VehicleDiscFactory.CreateVehicleDisc("D12865433",LocalDate.parse("2023-06-03"),"Valid",LocalDate.parse("2022-03-01"));


    @Test
    public void CreateVehicleDisc() {
        assertNotNull(disc);
        System.out.println(disc.toString());
    }

}