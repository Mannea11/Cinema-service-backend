package com.Gruppuppgift.Cinema.Service;

import com.Gruppuppgift.Cinema.DAO.RoomRepository;
import com.Gruppuppgift.Cinema.Entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Override
    public Room saveRoom(Room room) {
        System.out.println("Saved room");
        return roomRepository.save(room);
    }

    @Override
    public Optional<Room> findById(int id) {
        return roomRepository.findById(id);
    }
}
