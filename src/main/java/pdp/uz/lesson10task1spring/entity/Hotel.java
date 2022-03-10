package pdp.uz.lesson10task1spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pdp.uz.lesson10task1spring.entity.template.AbsLongEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Hulkar,
 * @time чт 9:55.
 * @project 10.03.2022
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hotel extends AbsLongEntity {

    @Column(unique = true)
    private String name;


}
