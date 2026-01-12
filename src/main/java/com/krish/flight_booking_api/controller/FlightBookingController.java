package com.krish.flight_booking_api.controller;

import com.krish.flight_booking_api.dto.BookingResponse;
import com.krish.flight_booking_api.dto.FlightBookingRequest;
import com.krish.flight_booking_api.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class FlightBookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping("/bookings")
    public ResponseEntity<BookingResponse> createBooking(
            @RequestBody FlightBookingRequest request) {
        return ResponseEntity.ok(bookingService.createBooking(request));
    }
}
