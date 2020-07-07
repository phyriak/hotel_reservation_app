package pl.phyriak.hotel_reservation_app.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.phyriak.hotel_reservation_app.mapper.UserMapper;
import pl.phyriak.hotel_reservation_app.model.PasswordDTO;
import pl.phyriak.hotel_reservation_app.model.User;
import pl.phyriak.hotel_reservation_app.model.UserDTO;
import pl.phyriak.hotel_reservation_app.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    public User createUser(UserDTO user) throws RuntimeException {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException(user.getUsername() + " already exist!");
        } else ;
        {
            return userRepository.save(UserMapper.map(user.getUsername(), user.getPassword(), user.getPhone()));
        }
    }

    public Optional<User> findById(Long id) throws RuntimeException {
        if (userRepository.findById(id).isPresent()) return userRepository.findById(id);
        else throw new RuntimeException("Not exist");
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateUserPassword(Long id, PasswordDTO passwordDTO) {
        log.info("update");
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        if (user.getPassword().equals(passwordDTO.getOldPassword())) {
            userRepository.updateUserPassword(id, passwordDTO.getNewPassword());
        } else { throw new RuntimeException("Bad password"); }
    }

    @Transactional
    public void deleteUser(Long id) {
        log.info("delete");
        User user = userRepository.findByUser_id(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}
