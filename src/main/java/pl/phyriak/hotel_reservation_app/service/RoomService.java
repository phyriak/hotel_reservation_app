package pl.phyriak.hotel_reservation_app.service;

import org.springframework.stereotype.Service;
import pl.phyriak.hotel_reservation_app.mapper.RoomMapper;
import pl.phyriak.hotel_reservation_app.mapper.UserMapper;
import pl.phyriak.hotel_reservation_app.model.Order;
import pl.phyriak.hotel_reservation_app.model.Room;
import pl.phyriak.hotel_reservation_app.model.RoomDTO;
import pl.phyriak.hotel_reservation_app.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

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

    public Object findById(Long id) {
        if (roomRepository.findById(id).isPresent()) return roomRepository.findById(id);
        else throw new RuntimeException("Not exist");
    }

    public Room createRoom(RoomDTO roomDTO) {
        Room room = RoomMapper.map(roomDTO.getRoomType(), roomDTO.getPrice(), roomDTO.getRate());
            return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(()->new RuntimeException("not exist"));
       roomRepository.delete(room);
    }
}
