package com.krish.flight_booking_api.dto;

import com.krish.flight_booking_api.utilis.BookingStatus;

public class BookingStatusResponse {

    private String bookingReference;
    private BookingStatus bookingStatus;

    public String getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
