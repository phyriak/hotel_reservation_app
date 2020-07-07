package pl.phyriak.hotel_reservation_app.mapper;

import pl.phyriak.hotel_reservation_app.model.Order;
import pl.phyriak.hotel_reservation_app.model.OrderDTO;
import pl.phyriak.hotel_reservation_app.model.Room;
import pl.phyriak.hotel_reservation_app.model.User;
import pl.phyriak.hotel_reservation_app.repository.OrderRepository;

import java.math.BigDecimal;
import java.time.Duration;


public class OrderMapper {
    public static Order map(User user, Room room, OrderDTO orderDTO) {
        return Order.builder()
                .user(user)
                .room(room)
                .fromDate(orderDTO.getFromDate())
                .toDate(orderDTO.getToDate())
                .totalPrice(room.getPrice().multiply(new BigDecimal(Duration.between(orderDTO.getFromDate(),orderDTO.getToDate()).toDays())))
                //.additionalServicePack(orderDTO.getAdditionalServicePack())
                .additionalInformation(orderDTO.getAdditionalInformation())
                .build();
    }
}
