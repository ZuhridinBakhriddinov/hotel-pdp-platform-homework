package uz.pdp.hotelcrud.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hotelcrud.model.Hotel;
import uz.pdp.hotelcrud.model.Room;

// Zuhridin Bakhriddinov 3/5/2022 11:36 PM
public interface HotelRepository extends JpaRepository<Hotel,Integer> {

}
