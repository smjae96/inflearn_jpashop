package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jySim
 * @since 2025. 4. 16.
 */
@Entity
@DiscriminatorValue(value = "A")
@Getter
@Setter
public class Album extends Item {

    private String artist;
    private String etc;
}
