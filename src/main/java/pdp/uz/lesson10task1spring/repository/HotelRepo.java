package pdp.uz.lesson10task1spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.lesson10task1spring.entity.Hotel;

/**
 * @author Hulkar,
 * @time чт 9:57.
 * @project 10.03.2022
 */
public interface HotelRepo extends JpaRepository<Hotel,Integer> {

}
