package pl.phyriak.hotel_reservation_app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.phyriak.hotel_reservation_app.model.PasswordDTO;
import pl.phyriak.hotel_reservation_app.model.User;
import pl.phyriak.hotel_reservation_app.model.UserDTO;
import pl.phyriak.hotel_reservation_app.service.UserService;
import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @CrossOrigin
    @GetMapping(value = "/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    @CrossOrigin
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUsersById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/users")
    public ResponseEntity<User> createUser(@RequestBody UserDTO user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping(value = "/users/{id}/password")
    public ResponseEntity<User>updateUserPassword(@PathVariable Long id,@RequestBody PasswordDTO passwordDTO){
        userService.updateUserPassword(id,passwordDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUsers(@PathVariable final Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
