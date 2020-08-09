package pl.phyriak.hotel_reservation_app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.phyriak.hotel_reservation_app.model.*;
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

    @CrossOrigin
    @GetMapping("/rooms/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable Long id) {
        return new ResponseEntity<>(roomService.findById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/rooms")
    public ResponseEntity<Room> createUser(@RequestBody RoomDTO room){
        return new ResponseEntity<>(roomService.createRoom(room), HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable final Long id) {
        roomService.deleteRoom(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
