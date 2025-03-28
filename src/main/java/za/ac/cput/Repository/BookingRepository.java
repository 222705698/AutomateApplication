package za.ac.cput.Repository;

import za.ac.cput.Domain.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingRepository implements IBookingRepository{

    private static IBookingRepository repository = null;
    private List<Booking> bookingList;

    private BookingRepository(){
        bookingList = new ArrayList<Booking>();
    }

    public static IBookingRepository getRepository(){
        if(repository == null){
            repository = new BookingRepository();
        }
        return repository;
    }


    @Override
    public Booking create(Booking booking) {
        boolean success = bookingList.add(booking);
        if(success){
            return booking;
        }
        return null;
    }

    @Override
    public Booking read(String id) {
        for(Booking booking : bookingList){
            if(booking.getBookingID().equals(id)){
                return booking;
            }
        }
        return null;
    }

    @Override
    public Booking update(Booking booking) {
        String id = booking.getBookingID();
        Booking updatedBooking = read(id);
        if(updatedBooking == null)
            return null;

        boolean success = delete(id);
        if(success){
            if(bookingList.add(booking))
                return booking;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Booking booking = read(id);
        if(booking == null)
            return false;

        return (bookingList.remove(booking));
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingList;
    }
}