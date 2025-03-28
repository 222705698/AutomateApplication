package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Booking;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookingFactoryTest {

    @Test
    void testCreateBooking_Success() {
        Booking booking = BookingFactory.createBooking(
                "B001",
                "Hotel",
                LocalDate.of(2025, 5, 10),
                1200.50,
                "Luxury suite booking",
                "Confirmed"
        );

        assertNotNull(booking, "Booking should not be null");
        assertEquals("B001", booking.getBookingID());
        assertEquals("Hotel", booking.getBookingType());
        assertEquals(LocalDate.of(2025, 5, 10), booking.getBookingDate());
        assertEquals(1200.50, booking.getBookingAmount());
        assertEquals("Luxury suite booking", booking.getBookingDescription());
        assertEquals("Confirmed", booking.getBookingStatus());
    }

    @Test
    void testCreateBooking_Fail_EmptyValues() {
        Booking booking = BookingFactory.createBooking(
                "", "", LocalDate.now(), 0, "", "");

        assertNull(booking, "Booking should be null when required fields are empty");
    }

}