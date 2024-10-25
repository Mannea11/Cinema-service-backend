package com.Gruppuppgift.Cinema.Controller;

import com.Gruppuppgift.Cinema.Entities.Booking;
import com.Gruppuppgift.Cinema.Entities.Movie;
import com.Gruppuppgift.Cinema.Entities.Room;
import com.Gruppuppgift.Cinema.Service.BookingServiceImpl;
import com.Gruppuppgift.Cinema.Service.CurrencyConverterService;
import com.Gruppuppgift.Cinema.Service.MovieServiceImpl;
import com.Gruppuppgift.Cinema.Service.RoomServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

    private static final Logger logger = LogManager.getLogger("MyLogger");

    @Autowired
    private BookingServiceImpl bookingService;

    @Autowired
    private MovieServiceImpl movieService;

    @Autowired
    private RoomServiceImpl roomService;
    @PostMapping("/bookings")
    public Booking saveBooking(@RequestBody Booking booking) {
        booking.setId(0);
        Optional<Movie> movieOptional = movieService.findById(booking.getMovie().getId());
        Optional<Room> roomOptional = roomService.findById(booking.getRoom().getId());
        if (movieOptional.isPresent()) {
            Movie movie = movieOptional.get();
            booking.getMovie().setTitle(movie.getTitle());
            booking.getMovie().setAgelimit(movie.getAgelimit());
            booking.getMovie().setGenre(movie.getGenre());
            booking.getMovie().setLength(movie.getLength());
            booking.getMovie().setPrice(movie.getPrice());
        }
        if (roomOptional.isPresent()) {
            Room room = roomOptional.get();
            booking.getRoom().setTitle(room.getTitle());
            booking.getRoom().setPrice(room.getPrice());
            booking.getRoom().setTech(room.getTech());
            booking.getRoom().setMaxGuests(room.getMaxGuests());
            }

        int totalPrice = bookingService.calculateTotalPrice(booking);
        booking.setTotalprice(totalPrice);
        try {
            double totalPriceUSD = CurrencyConverterService.convertCurrency("SEK", "USD", totalPrice);
            booking.setTotalpriceusd((int) totalPriceUSD);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Booking savedBooking = bookingService.saveBooking(booking);
        logger.info("Customer saved a booking with id: " + savedBooking.getId());
        return savedBooking;
    }


    @PutMapping("bookings/{id}")
    public Booking updateBooking(@PathVariable int id, @RequestBody Booking s){
        logger.info("Customer updated booking with ID " + id);
        Booking booking = saveBooking(s);
        s.setId(id);
        return booking;
    }
    @GetMapping("/bookings/{id}")
    public Optional<Booking> getBooking(@PathVariable int id) {
        return bookingService.findById(id);
    }
}
