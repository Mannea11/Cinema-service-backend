package com.Gruppuppgift.Cinema.DAO;

import com.Gruppuppgift.Cinema.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
}
