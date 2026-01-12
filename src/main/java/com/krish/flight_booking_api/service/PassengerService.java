package com.krish.flight_booking_api.service;

import com.krish.flight_booking_api.dto.PassengerResponse;
import com.krish.flight_booking_api.entity.Booking;
import com.krish.flight_booking_api.entity.Passenger;
import com.krish.flight_booking_api.repo.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PassengerService {
    @Autowired BookingRepository  bookingRepository;

    @Transactional
    public List<PassengerResponse> getPassengersByFlight(
            String flightNumber,
            LocalDate journeyDate) {
        System.out.println();
        List<Booking> bookings =
                bookingRepository.findByFlightNumberAndJourneyDate(
                        flightNumber, journeyDate);

        return bookings.stream()
                .flatMap(b -> b.getPassengers().stream())
                .map(this::mapToPassengerResponse)
                .toList();
    }

    private PassengerResponse mapToPassengerResponse(Passenger passenger) {

        PassengerResponse response = new PassengerResponse();
        response.setFirstName(passenger.getFirstName());
        response.setLastName(passenger.getLastName());
        response.setSeatNumber(passenger.getSeatNumber());
        response.setPassengerType(passenger.getPassengerType());

        return response;
    }
}
