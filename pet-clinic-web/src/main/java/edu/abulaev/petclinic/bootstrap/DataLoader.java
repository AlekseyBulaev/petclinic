package edu.abulaev.petclinic.bootstrap;

import edu.abulaev.petclinic.model.*;
import edu.abulaev.petclinic.services.OwnerService;
import edu.abulaev.petclinic.services.PetTypeService;
import edu.abulaev.petclinic.services.SpecialtyService;
import edu.abulaev.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialityService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count ==0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType =  petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType =  petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();

        owner1.setFirstName("Ivan");
        owner1.setLastName("Ivanov");
        owner1.setAddress("Polezhaevskaya");
        owner1.setCity("Moscow");
        owner1.setTelephone("1234567890");


        Pet ivanovsPet = new Pet();
        ivanovsPet.setPetType(savedCatType);
        ivanovsPet.setOwner(owner1);
        ivanovsPet.setBirthday(LocalDate.now());
        ivanovsPet.setName("ruda");
        owner1.getPets().add(ivanovsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Petya");
        owner2.setLastName("Petrov");
        owner2.setAddress("Nevskiy bulvar");
        owner2.setCity("St.Petersburg");
        owner2.setTelephone("0987654321");

        Pet petrovsPet = new Pet();
        petrovsPet.setPetType(savedDogType);
        petrovsPet.setOwner(owner2);
        petrovsPet.setBirthday(LocalDate.now());
        petrovsPet.setName("Buba");
        owner2.getPets().add(petrovsPet);

        ownerService.save(owner2);

        System.out.println("Loaded owners ...");

        Vet vet1 = new Vet();

        vet1.setFirstName("Meteor");
        vet1.setLastName("Ibolit");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Doctor");
        vet2.setLastName("Kuklachov");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
