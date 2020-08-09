package pl.phyriak.hotel_reservation_app.service;

import org.springframework.stereotype.Service;
import pl.phyriak.hotel_reservation_app.model.Order;
import pl.phyriak.hotel_reservation_app.model.Room;
import pl.phyriak.hotel_reservation_app.repository.RoomRepository;

import java.util.List;

@Service
public class RoomService {
RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllOrders() {
        List<Room> allRooms = roomRepository.findAll();
        return allRooms;
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(()-> new RuntimeException("Not exist"));
    }
}
