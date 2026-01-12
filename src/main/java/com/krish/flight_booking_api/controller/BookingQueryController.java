package com.krish.flight_booking_api.controller;

import com.krish.flight_booking_api.dto.BookingResponse;
import com.krish.flight_booking_api.dto.BookingStatusResponse;
import com.krish.flight_booking_api.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingQueryController {

    private final BookingService bookingService;

    public BookingQueryController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/{bookingReference}")
    public ResponseEntity<BookingResponse> getBooking(
            @PathVariable String bookingReference) {

        return ResponseEntity.ok(
                bookingService.getBookingDetails(bookingReference)
        );
    }

    @GetMapping("/{bookingReference}/status")
    public ResponseEntity<BookingStatusResponse> getBookingStatus(
            @PathVariable String bookingReference) {

        return ResponseEntity.ok(
                bookingService.getBookingStatus(bookingReference)
        );
    }
}