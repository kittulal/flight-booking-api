package com.krish.flight_booking_api.controller;

import com.krish.flight_booking_api.dto.PassengerResponse;
import com.krish.flight_booking_api.service.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightQueryController {

    private final PassengerService passengerService;

    public FlightQueryController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping("/{flightNumber}/passengers")
    public ResponseEntity<List<PassengerResponse>> getPassengersByFlight(
            @PathVariable String flightNumber,
            @RequestParam LocalDate journeyDate) {

        return ResponseEntity.ok(
                passengerService.getPassengersByFlight(flightNumber, journeyDate)
        );
    }
}