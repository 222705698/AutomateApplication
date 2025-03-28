package za.ac.cput.Repository;

import za.ac.cput.Domain.Booking;
import za.ac.cput.Domain.License;

import java.util.List;

public interface IBookingRepository extends IRepository<Booking, String>{
    List<Booking> getAllBookings();
}
