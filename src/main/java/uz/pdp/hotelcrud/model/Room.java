package uz.pdp.hotelcrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Zuhridin Bakhriddinov 3/5/2022 11:22 PM
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer number;
    private Integer floor;
    private Integer size;

    @ManyToOne
    private Hotel hotel;

    public Room(Integer number, Integer floor, Integer size, Hotel hotel) {
        this.number = number;
        this.floor = floor;
        this.size = size;
        this.hotel = hotel;
    }

    /*number,
    floor,
    size,
    Hotel*/
}
