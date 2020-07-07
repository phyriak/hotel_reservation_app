package pl.phyriak.hotel_reservation_app.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
public final class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private  Long user_id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String username;

    @NotNull
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @NotNull
    private int phone;

    @NotNull
    private boolean active;

    @Builder
    public User( String username, String password, UserType userType, int phone, boolean active){
        this.username=username;
        this.password=password;
        this.userType=userType;
        this.phone=phone;
        this.active=active;
    }
}
