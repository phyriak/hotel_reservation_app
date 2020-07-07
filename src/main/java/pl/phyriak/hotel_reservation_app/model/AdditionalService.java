package pl.phyriak.hotel_reservation_app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
public class AdditionalService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long service_id;

    @NotNull
    private String name_s;

    @NotNull
    private BigDecimal price;


    @JsonBackReference
    @ManyToOne
    private AdditionalServicePack additionalServicePack;

    @Builder
    public AdditionalService(Long service_id, String name_s, BigDecimal price,AdditionalServicePack additionalServicePack) {
        this.service_id=service_id;
        this.name_s=name_s;
        this.price=price;
        this.additionalServicePack=additionalServicePack;
    }
}
