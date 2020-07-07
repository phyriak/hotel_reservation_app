package pl.phyriak.hotel_reservation_app.model;

import lombok.NoArgsConstructor;
import lombok.Value;

@Value
public class PasswordDTO {
    String oldPassword;
    String newPassword;
}
