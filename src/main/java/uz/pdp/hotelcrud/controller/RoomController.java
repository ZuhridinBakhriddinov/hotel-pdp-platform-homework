package uz.pdp.hotelcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.pdp.hotelcrud.dto.RoomDto;
import uz.pdp.hotelcrud.model.Hotel;
import uz.pdp.hotelcrud.model.Room;
import uz.pdp.hotelcrud.repo.HotelRepository;
import uz.pdp.hotelcrud.repo.RoomRepository;

import java.util.Optional;

// Zuhridin Bakhriddinov 3/5/2022 11:38 PM
@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    HotelRepository hotelRepository;

    @PostMapping
    public String addRoom(@RequestBody RoomDto roomDto) {

        Optional<Hotel> optionalHotel = hotelRepository.findById(roomDto.getHotelId());
        if (!optionalHotel.isPresent()) {
            return "wrong";
        }
        Room room = new Room(roomDto.getNumber(), roomDto.getFloor(), roomDto.getSize(), optionalHotel.get());
        roomRepository.save(room);
        return "saved";

    }

    @GetMapping("/{hotelId}")
    public Page<Room> getRoom(@PathVariable Integer hotelId,
                              @RequestParam int page) {

        Pageable pageable = PageRequest.of(page, 10);
        return roomRepository.findAllByHotelId(hotelId, pageable);

    }

    @PostMapping("/{roomId}")
    public String editRoom(@RequestBody RoomDto roomDto, @PathVariable Integer roomId) {
        Optional<Room> roomOptional = roomRepository.findById(roomId);
        if (!roomOptional.isPresent()) {
            return "wrong";
        }
        Room room = roomOptional.get();
        room.setFloor(roomDto.getFloor());
        room.setNumber(roomDto.getNumber());
        room.setSize(roomDto.getSize());
        Optional<Hotel> hotelOptional = hotelRepository.findById(roomDto.getHotelId());
        if (!hotelOptional.isPresent()) {
            return "wrong";
        }
        room.setHotel(hotelOptional.get());

        roomRepository.save(room);
        return "edited";

    }


    @DeleteMapping("/{room_id}")
    public String deleteRoom(@PathVariable Integer room_id){
       roomRepository.deleteById(room_id);
        return "deleted!";
    }

}
