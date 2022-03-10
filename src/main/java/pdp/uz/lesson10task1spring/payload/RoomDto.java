package pdp.uz.lesson10task1spring.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pdp.uz.lesson10task1spring.entity.Hotel;

/**
 * @author Hulkar,
 * @time чт 10:45.
 * @project 10.03.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {

    private Integer id;
    private Integer number;
    private String floor;
    private String size;
    private Hotel hotel;
}
