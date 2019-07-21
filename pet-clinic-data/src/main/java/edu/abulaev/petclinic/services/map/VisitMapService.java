package edu.abulaev.petclinic.services.map;

import edu.abulaev.petclinic.model.Visit;
import edu.abulaev.petclinic.services.VisitService;

import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit, Long>
        implements VisitService {


    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {

        if(object.getPet() == null
                || object.getPet().getOwner() == null
                || object.getPet().getId() == null
                || object.getPet().getOwner().getId() == null)
            throw new RuntimeException("Invalid visit");

        return super.save(object);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
