package uz.pdp.hotelcrud.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hotelcrud.model.Hotel;
import uz.pdp.hotelcrud.model.Room;

// Zuhridin Bakhriddinov 3/5/2022 11:36 PM
public interface RoomRepository extends JpaRepository<Room,Integer> {
    Page<Room> findAllByHotelId(Integer hotel_id, Pageable pageable);
}
