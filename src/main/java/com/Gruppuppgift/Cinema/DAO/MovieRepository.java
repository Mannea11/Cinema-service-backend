package com.Gruppuppgift.Cinema.DAO;

import com.Gruppuppgift.Cinema.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
