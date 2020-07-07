package pl.phyriak.hotel_reservation_app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@Entity(name="room_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @NotNull
    @OneToOne
    @JoinColumn(nullable = false)
    private Room room;

    @NotNull
    private LocalDateTime fromDate;

    @NotNull
    private LocalDateTime toDate;

    @NotNull
    private BigDecimal totalPrice;


    @OneToOne
    private AdditionalServicePack additionalServicePack;

    private String additionalInformation;

    @Builder
    public Order(Long order_id, @NotNull User user, @NotNull Room room, LocalDateTime fromDate, LocalDateTime toDate, BigDecimal totalPrice,AdditionalServicePack additionalServicePack, String additionalInformation){
        this.order_id=order_id;
        this.user=user;
        this.room=room;
        this.fromDate=fromDate;
        this.toDate=toDate;
        this.totalPrice=totalPrice;
        this.additionalServicePack=additionalServicePack;
        this.additionalInformation=additionalInformation;
    }

}
