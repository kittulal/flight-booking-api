package com.krish.flight_booking_api.service;

import com.krish.flight_booking_api.dto.BookingResponse;
import com.krish.flight_booking_api.dto.PassengerResponse;
import com.krish.flight_booking_api.dto.PaymentResponse;
import com.krish.flight_booking_api.entity.Booking;
import com.krish.flight_booking_api.entity.Passenger;
import com.krish.flight_booking_api.entity.Payment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookingMapper {

    public BookingResponse toBookingResponse(Booking booking, Payment latestPayment) {

        BookingResponse response = new BookingResponse();
        response.setBookingReference(booking.getBookingReference());
        response.setFlightNumber(booking.getFlightNumber());
        response.setJourneyDate(booking.getJourneyDate());
        response.setBookingStatus(booking.getBookingStatus());
        response.setBookedAt(booking.getCreatedAt());

        response.setPassengers(mapPassengers(booking.getPassengers()));
        response.setPayment(mapPayment(latestPayment));

        return response;
    }

    private List<PassengerResponse> mapPassengers(List<Passenger> passengers) {
        return passengers.stream()
                .map(this::mapPassenger)
                .collect(Collectors.toList());
    }

    private PassengerResponse mapPassenger(Passenger passenger) {
        PassengerResponse response = new PassengerResponse();
        response.setFirstName(passenger.getFirstName());
        response.setLastName(passenger.getLastName());
        response.setSeatNumber(passenger.getSeatNumber());
        response.setPassengerType(passenger.getPassengerType());
        return response;
    }

    private PaymentResponse mapPayment(Payment payment) {
        PaymentResponse response = new PaymentResponse();
        response.setAmount(payment.getAmount());
        response.setCurrency(payment.getCurrency());
        response.setPaymentMethod(payment.getPaymentMethod());
        response.setPaymentStatus(payment.getPaymentStatus());
        response.setTransactionId(payment.getTransactionId());
        response.setPaidAt(payment.getPaidAt());
        return response;
    }
}