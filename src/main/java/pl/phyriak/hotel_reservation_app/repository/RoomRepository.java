package pl.phyriak.hotel_reservation_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.phyriak.hotel_reservation_app.model.Room;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room,Long> {

}
