package guru.springframework.sfgpetclinic.models;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class PetType extends BaseEntity {

    private String name;

}
