package pl.phyriak.hotel_reservation_app.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.phyriak.hotel_reservation_app.model.*;
import pl.phyriak.hotel_reservation_app.repository.OrderRepository;
import pl.phyriak.hotel_reservation_app.service.OrderService;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController {
    OrderService orderService;

    @CrossOrigin
    @GetMapping(value = "/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }


    @CrossOrigin
    @GetMapping("/orders/{id}")
    public ResponseEntity<?> getOrdersById(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/ordersByUser/{id}")
    public ResponseEntity<?> getOrdersByUser(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.findByUserId(id), HttpStatus.OK);
    }



    @CrossOrigin
    @PostMapping(value = "/orders")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO order) {
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping(value = "/orders/{id}")
    public ResponseEntity<User> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        orderService.updateOrder(id, orderDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/orders/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable final Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
