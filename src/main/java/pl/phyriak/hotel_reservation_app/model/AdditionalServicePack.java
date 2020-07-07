package pl.phyriak.hotel_reservation_app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class AdditionalServicePack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long service_pack_id;


    @JoinColumn(nullable = false, updatable = false)
    @OneToMany
    @JsonManagedReference
    private List<AdditionalService> additionalServiceList=new ArrayList<>();

    public AdditionalServicePack(Long service_pack_id,List<AdditionalService> additionalServiceList) {
        this.service_pack_id=service_pack_id;
        this.additionalServiceList=additionalServiceList;
    }
}
