package pl.phyriak.hotel_reservation_app.model;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class RoomDTO {
    private RoomType roomType;
    private BigDecimal price;
    private int rate;
}