package za.ac.cput.Repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Domain.Booking;
import za.ac.cput.Factory.BookingFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class BookingRepositoryTest {

    private static IBookingRepository repository = BookingRepository.getRepository();
    private static Booking booking = BookingFactory.createBooking("hdhw","Learner's Test", LocalDate.now(),1000,"husdhuwwhu","Pending");

    @Test
    void a_create() {
        Booking createdBooking = repository.create(booking);
        assertNotNull(createdBooking);
        System.out.println(createdBooking.toString());
    }

    @Test
    void b_read() {
        Booking read = repository.read(booking.getBookingID());
        assertNotNull(read);
        System.out.println(read.toString());
    }

    @Test
    void c_update() {
        Booking updatedBooking = new Booking.BookBuilder().copy(booking).setBookingType("Driver's License").build();
        Booking updated = repository.update(updatedBooking);
        assertNotNull(updated);
        System.out.println(updated.toString());
    }

    @Test
    @Disabled
    void d_delete() {
        assertTrue(repository.delete(booking.getBookingID()));
        System.out.println("Successfully deleted");
    }

    @Test
    void e_getAllBookings() {
        System.out.println(repository.getAllBookings());
    }
}
