package edu.abulaev.petclinic.repositories;

import edu.abulaev.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitService extends CrudRepository<Visit, Long> {

}
