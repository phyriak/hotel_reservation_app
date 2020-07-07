package pl.phyriak.hotel_reservation_app.mapper;

import pl.phyriak.hotel_reservation_app.model.User;
import pl.phyriak.hotel_reservation_app.model.UserType;

public class UserMapper {
    public static User map(String username,String password, int phone){
        return User.builder()
                .username(username)
                .password(password)
                .userType(UserType.ROLE_CLIENT)
//                .userType(UserType.valueOf(userType))
                .phone(phone)
                .active(true)
                .build();
    }
}
