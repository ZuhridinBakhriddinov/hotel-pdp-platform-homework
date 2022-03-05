package uz.pdp.hotelcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Zuhridin Bakhriddinov 3/5/2022 11:46 PM
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDto {

    private Integer number;
    private Integer floor;
    private Integer size;
    private Integer hotelId;


}
