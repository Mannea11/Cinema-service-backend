package com.Gruppuppgift.Cinema.Service;

import com.Gruppuppgift.Cinema.Entities.Booking;
import com.Gruppuppgift.Cinema.Entities.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    Movie saveMovie(Movie movie);

    List<Movie> findAllMovies();

    Optional<Movie> findById(int id);
    void deleteMovieById(int customerId);
}
