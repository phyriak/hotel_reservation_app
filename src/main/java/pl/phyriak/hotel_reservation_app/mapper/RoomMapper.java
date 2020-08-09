package pl.phyriak.hotel_reservation_app.mapper;

import pl.phyriak.hotel_reservation_app.model.Room;
import pl.phyriak.hotel_reservation_app.model.RoomType;
import pl.phyriak.hotel_reservation_app.model.User;
import pl.phyriak.hotel_reservation_app.model.UserType;

import java.math.BigDecimal;

public class RoomMapper {
    public static Room map(RoomType roomType, BigDecimal price, int rate){
        return Room.builder()
                .roomType(roomType)
                .price(price)
                .rate(rate)
                .build();
    }
}
