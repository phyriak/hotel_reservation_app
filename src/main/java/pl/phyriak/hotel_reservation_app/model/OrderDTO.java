package pl.phyriak.hotel_reservation_app.model;

import lombok.Value;
import java.time.LocalDateTime;

@Value
public class OrderDTO {
    private Long userId;
    private Long roomId;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    //private AdditionalServicePack additionalServicePack;
    private String additionalInformation;
}
