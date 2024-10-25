package com.Gruppuppgift.Cinema.DAO;

import com.Gruppuppgift.Cinema.Entities.Booking;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
