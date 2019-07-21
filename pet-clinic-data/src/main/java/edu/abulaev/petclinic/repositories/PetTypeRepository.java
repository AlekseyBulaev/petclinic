package edu.abulaev.petclinic.repositories;

import edu.abulaev.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
