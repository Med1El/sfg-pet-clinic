package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.models.Visit;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    private Long i=0L;

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }


    @Override
    public Visit save(Visit visit) {
        if(visit.getPet()==null || visit.getPet().getOwner()==null
                || visit.getPet().getId()==null || visit.getPet().getOwner().getId()==null ) {
            throw new RuntimeException("Invalid Visit");
        }
        super.save(i, visit);
        visit.setId(i++);
        return visit;
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

}