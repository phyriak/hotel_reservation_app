package pl.phyriak.hotel_reservation_app.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
public final class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private  Long room_id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @NotNull
    private BigDecimal price;

    @NotNull
    private int rate;


    @Builder
    public Room(Long room_id, RoomType roomType, BigDecimal price, int rate){
        this.room_id=room_id;
        this.roomType=roomType;
        this.price=price;
        this.rate=rate;
    }

}
