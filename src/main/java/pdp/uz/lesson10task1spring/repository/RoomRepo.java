package pdp.uz.lesson10task1spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.lesson10task1spring.entity.Room;

import java.util.List;

/**
 * @author Hulkar,
 * @time чт 9:58.
 * @project 10.03.2022
 */
public interface RoomRepo extends JpaRepository<Room,Integer> {

}
