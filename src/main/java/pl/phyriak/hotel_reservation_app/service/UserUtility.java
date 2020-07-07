package pl.phyriak.hotel_reservation_app.service;

import pl.phyriak.hotel_reservation_app.model.User;
import pl.phyriak.hotel_reservation_app.repository.UserRepository;

public class UserUtility {
    static User getUserUtility(UserRepository userRepository,Long id) {
        return userRepository.findById(id)
                .filter(user -> user.getUser_id().equals(id))
                .orElseThrow(() -> new IllegalStateException("User not found"));
    }
}
