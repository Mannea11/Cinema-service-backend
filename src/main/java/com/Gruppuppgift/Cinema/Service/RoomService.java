package com.Gruppuppgift.Cinema.Service;

import com.Gruppuppgift.Cinema.Entities.Movie;
import com.Gruppuppgift.Cinema.Entities.Room;

import java.util.Optional;

public interface RoomService {

    Room saveRoom(Room room);

    Optional<Room> findById(int id);
}
