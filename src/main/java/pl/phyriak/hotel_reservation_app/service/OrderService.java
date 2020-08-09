package pl.phyriak.hotel_reservation_app.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.phyriak.hotel_reservation_app.model.Order;
import pl.phyriak.hotel_reservation_app.model.OrderDTO;
import pl.phyriak.hotel_reservation_app.model.User;
import pl.phyriak.hotel_reservation_app.repository.OrderRepository;
import pl.phyriak.hotel_reservation_app.repository.RoomRepository;
import pl.phyriak.hotel_reservation_app.repository.UserRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static pl.phyriak.hotel_reservation_app.mapper.OrderMapper.map;
import static pl.phyriak.hotel_reservation_app.service.RoomUtility.getRoomUtility;
import static pl.phyriak.hotel_reservation_app.service.UserUtility.getUserUtility;

@Service
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, RoomRepository roomRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }

    public List<Order> getAllOrders() {
        List<Order> allOrders = orderRepository.findAll();
        return allOrders;
    }

    public Optional<Order> findById(Long id) {
        if (orderRepository.findById(id).isPresent())
            return orderRepository.findById(id);
        else throw new RuntimeException("Element not found");
    }

    public List<Order> findByUserId(Long id) {
       if(orderRepository.findByUserId(id).isEmpty()){
           return Collections.EMPTY_LIST;
       }else return orderRepository.findByUserId(id);
    }

    public boolean checkAvailabilityOfRoom(OrderDTO orderDTO) {
        List<Order> allOrdersByRoomId = orderRepository.findAllOrdersByRoomId(orderDTO.getRoomId());
        boolean available = false;
        if (allOrdersByRoomId.isEmpty()) {
            available = true;
            log.info("finding room in order when room is not founded");
        } else {
            for (Order t : allOrdersByRoomId) {
                if (t.getToDate().getDayOfYear() <= orderDTO.getFromDate().getDayOfYear() || t.getFromDate().getDayOfYear() > orderDTO.getToDate().getDayOfYear()) {
                    available = true;
                    log.info("cos tam");
                }
            }
        }
        return available;
    }

    public Order createOrder(OrderDTO orderDTO) {
        if (checkAvailabilityOfRoom(orderDTO)) {
            Order order = orderRepository.save(map(getUserUtility(userRepository, orderDTO.getUserId()), getRoomUtility(roomRepository, orderDTO.getRoomId()), orderDTO));
            return order;
        } else throw new RuntimeException("Term is already booked");
    }

    public Order updateOrder(Long id, OrderDTO orderDTO) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        //TODO
        //poprawic update by updateowac fragmentami
        if (!orderDTO.getUserId().equals(null))
            order.setUser(getUserUtility(userRepository, orderDTO.getUserId()));
        if (!orderDTO.getRoomId().equals(null))
            order.setRoom(getRoomUtility(roomRepository, orderDTO.getRoomId()));
        if (!orderDTO.getToDate().equals(null))
            order.setToDate(orderDTO.getToDate());
        if (!orderDTO.getFromDate().equals(null))
            order.setFromDate(orderDTO.getFromDate());
        if (!orderDTO.getAdditionalInformation().equals(null))
            order.setAdditionalInformation(orderDTO.getAdditionalInformation());
        orderRepository.save(order);
        return order;
    }

    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Element not found"));
        orderRepository.delete(order);
    }


}
