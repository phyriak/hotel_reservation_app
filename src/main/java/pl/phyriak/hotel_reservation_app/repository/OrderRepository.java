package pl.phyriak.hotel_reservation_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.phyriak.hotel_reservation_app.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {


            @Query("select t from room_order t where t.room.room_id = :roomId")
            List<Order> findAllOrdersByRoomId(Long roomId);
}
