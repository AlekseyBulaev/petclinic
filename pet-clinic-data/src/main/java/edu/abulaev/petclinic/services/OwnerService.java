package edu.abulaev.petclinic.services;

import edu.abulaev.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
