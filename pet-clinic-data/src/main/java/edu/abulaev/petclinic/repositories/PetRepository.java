package edu.abulaev.petclinic.repositories;

import edu.abulaev.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
