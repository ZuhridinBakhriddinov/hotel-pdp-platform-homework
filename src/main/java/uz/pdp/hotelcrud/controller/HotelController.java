package uz.pdp.hotelcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.hotelcrud.model.Hotel;
import uz.pdp.hotelcrud.repo.HotelRepository;

import java.util.List;

// Zuhridin Bakhriddinov 3/5/2022 11:38 PM
@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelRepository hotelRepository;

    @GetMapping
    public List<Hotel> getHotel(){
        return hotelRepository.findAll();
    }

    @PostMapping
    public String addHotel(@RequestBody Hotel hotel){
        hotelRepository.save(hotel);
        return "Added";
    }

}
