package pdp.uz.lesson10task1spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pdp.uz.lesson10task1spring.entity.template.AbsLongEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Hulkar,
 * @time чт 9:56.
 * @project 10.03.2022
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room extends AbsLongEntity {

    //number, floor, size,Hotel

    @Column(unique = true)
    private Integer number;

    private String floor;

    private String size;

    @ManyToOne
    private Hotel hotel;
}
