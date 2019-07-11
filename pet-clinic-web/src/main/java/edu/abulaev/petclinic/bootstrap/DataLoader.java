package edu.abulaev.petclinic.bootstrap;

import edu.abulaev.petclinic.model.Owner;
import edu.abulaev.petclinic.model.Vet;
import edu.abulaev.petclinic.services.OwnerService;
import edu.abulaev.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Ivan");
        owner1.setLastName("Ivanov");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Petya");
        owner2.setLastName("Petrov");

        ownerService.save(owner2);

        System.out.println("Loaded owners ...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Doctor");
        vet1.setLastName("Ibolit");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Doctor");
        vet2.setLastName("Kuklachov");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
