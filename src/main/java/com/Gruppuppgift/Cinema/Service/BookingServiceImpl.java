package com.Gruppuppgift.Cinema.Service;

import com.Gruppuppgift.Cinema.DAO.BookingRepository;
import com.Gruppuppgift.Cinema.Entities.Booking;
import com.Gruppuppgift.Cinema.Entities.Movie;
import com.Gruppuppgift.Cinema.Entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;


    @Override
    public int calculateTotalPrice(Booking booking) {
       int numberOfGuests = booking.getGuests();
       Movie selectedMovie = booking.getMovie();
        Room selectedRoom = booking.getRoom();
       int moviePrice = selectedMovie.getPrice();
        int roomPrice = selectedRoom.getPrice();
       int totalprice = (moviePrice * numberOfGuests) + roomPrice;

        return totalprice;
    }


    public Booking saveBooking(Booking booking) {
        System.out.println("Customer saved a booking");
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> findById(int id) {
        return bookingRepository.findById(id);
    }

}
