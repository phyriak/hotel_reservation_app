package pl.phyriak.hotel_reservation_app.service;

import pl.phyriak.hotel_reservation_app.model.Room;
import pl.phyriak.hotel_reservation_app.model.User;
import pl.phyriak.hotel_reservation_app.repository.RoomRepository;
import pl.phyriak.hotel_reservation_app.repository.UserRepository;

public class RoomUtility {
    static Room getRoomUtility(RoomRepository roomRepository, Long id) {
        return roomRepository.findById(id)
                .filter(room -> room.getRoom_id().equals(id))
                .orElseThrow(() -> new IllegalStateException("Room not found"));
    }
}
