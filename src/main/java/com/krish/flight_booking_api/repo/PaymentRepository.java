package com.krish.flight_booking_api.repo;

import com.krish.flight_booking_api.entity.Payment;
import com.krish.flight_booking_api.utilis.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Latest payment for booking (retry scenario)
    Optional<Payment> findTopByBooking_BookingReferenceOrderByCreatedAtDesc(
            String bookingReference
    );

    // Find payment by transaction ID
    Optional<Payment> findByTransactionId(String transactionId);

    // Get all payments for a booking
    List<Payment> findByBooking_BookingReference(String bookingReference);

    // Get failed payments
    List<Payment> findByPaymentStatus(PaymentStatus status);
}