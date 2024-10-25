package com.Gruppuppgift.Cinema.Service;

import com.Gruppuppgift.Cinema.Entities.Booking;

import java.util.Optional;

public interface BookingService {

    Booking saveBooking(Booking booking);
    Optional<Booking> findById(int id);
    int calculateTotalPrice(Booking booking);
}
