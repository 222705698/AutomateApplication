package za.ac.cput.Factory;

import za.ac.cput.Domain.Booking;
import za.ac.cput.Util.Helper;

import java.time.LocalDate;

public class BookingFactory {
    public static Booking createBooking(String bookId, String bookingType,LocalDate date,double amount,String description,String bookingStatus ) {
        if (Helper.isNullOrEmpty(bookId) || Helper.isNullOrEmpty(bookingType) || Helper.isNullOrEmpty(String.valueOf(date)) || Helper.isNullOrEmpty(String.valueOf(amount)) || Helper.isNullOrEmpty(description)
                || Helper.isNullOrEmpty(bookingStatus)){
            return null;
        }

        return new Booking.BookBuilder()
                .setBookingID(bookId)
                .setBookingType(bookingType)
                .setBookingDate(date)
                .setBookingAmount(amount)
                .setBookingDescription(description)
                .setBookingStatus(bookingStatus)
                .build();
    }
}
