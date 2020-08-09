package pl.phyriak.hotel_reservation_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.phyriak.hotel_reservation_app.exception.ElementNotFoundException;
import pl.phyriak.hotel_reservation_app.mapper.RoomMapper;
import pl.phyriak.hotel_reservation_app.model.Room;
import pl.phyriak.hotel_reservation_app.model.RoomDTO;
import pl.phyriak.hotel_reservation_app.repository.RoomRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {
RoomRepository roomRepository;


    public List<Room> getAllOrders() {
        List<Room> allRooms = roomRepository.findAll();
        return allRooms;
    }

    public Room findById(Long id) {
        return roomRepository.findById(id).orElseThrow(()->new ElementNotFoundException("Not found"));
    }

    public Room createRoom(RoomDTO roomDTO) {
        Room room = RoomMapper.map(roomDTO.getRoomType(), roomDTO.getPrice(), roomDTO.getRate());
            return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(()->new ElementNotFoundException("Not found"));
       roomRepository.delete(room);
    }
}
