package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.models.Pet;
import guru.springframework.sfgpetclinic.models.PetType;
import guru.springframework.sfgpetclinic.services.PetTypeService;

import java.util.Set;

public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

    private Long i=0L;


    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }


    @Override
    public PetType save(PetType petType) {
        super.save(i, petType);
        petType.setId(i++);
        return petType;
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType petType) {
        super.delete(petType);
    }

}
