package za.ac.cput.Domain;

import java.time.LocalDate;

public class Booking {
    private String bookingID;
    private String bookingType;
    private LocalDate bookingDate;
    private double bookingAmount;
    private String bookingDescription;
    private String bookingStatus;

    private Booking(BookBuilder bookBuilder){
        this.bookingID = bookBuilder.bookingID;
        this.bookingType = bookBuilder.bookingType;
        this.bookingDate = bookBuilder.bookingDate;
        this.bookingAmount = bookBuilder.bookingAmount;
        this.bookingDescription = bookBuilder.bookingDescription;
        this.bookingStatus = bookBuilder.bookingStatus;
    }


    public static class BookBuilder {
        private String bookingID;
        private String bookingType;
        private LocalDate bookingDate;
        private double bookingAmount;
        private String bookingDescription;
        private String bookingStatus;

        public BookBuilder setBookingID(String bookingID) {
            this.bookingID = bookingID;
            return this;
        }

        public BookBuilder setBookingType(String bookingType) {
            this.bookingType = bookingType;
            return this;
        }

        public BookBuilder setBookingDate(LocalDate bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        public BookBuilder setBookingAmount(double bookingAmount) {
            this.bookingAmount = bookingAmount;
            return this;
        }

        public BookBuilder setBookingDescription(String bookingDescription) {
            this.bookingDescription = bookingDescription;
            return this;
        }

        public BookBuilder setBookingStatus(String bookingStatus) {
            this.bookingStatus = bookingStatus;
            return this;
        }

        public Booking build(){
            return new Booking(this);
        }

        public Booking.BookBuilder copy(Booking booking) {
            this.bookingID = booking.bookingID;
            this.bookingType = booking.bookingType;
            this.bookingDate = booking.bookingDate;
            this.bookingAmount = booking.bookingAmount;
            this.bookingDescription = booking.bookingDescription;
            this.bookingStatus = booking.bookingStatus;
            return this;
        }
    }

    public String getBookingID() {
        return bookingID;
    }

    public String getBookingType() {
        return bookingType;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public double getBookingAmount() {
        return bookingAmount;
    }

    public String getBookingDescription() {
        return bookingDescription;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID='" + bookingID + '\'' +
                ", bookingType='" + bookingType + '\'' +
                ", bookingDate=" + bookingDate +
                ", bookingAmount='" + bookingAmount + '\'' +
                ", bookingDescription='" + bookingDescription + '\'' +
                ", bookingStatus='" + bookingStatus + '\'' +
                '}';
    }
}
