package pl.phyriak.hotel_reservation_app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.phyriak.hotel_reservation_app.model.Order;
import pl.phyriak.hotel_reservation_app.model.Room;
import pl.phyriak.hotel_reservation_app.service.RoomService;

import java.util.List;

@RestController
public class RoomController {
    RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @CrossOrigin
    @GetMapping(value = "/rooms")
    public List<Room> getAllRooms() {
        return roomService.getAllOrders();
    }

}
