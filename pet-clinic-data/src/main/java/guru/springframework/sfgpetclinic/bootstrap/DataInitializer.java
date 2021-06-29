package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.models.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;

    @Autowired
    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) loadData();

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCat = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Ismail");
        owner1.setLastName("Ba");
        owner1.setAddress("13 Berkley");
        owner1.setCity("Ohio");
        owner1.setTelephone("0524422112");

        Pet rosco = new Pet();
        rosco.setName("Rosco");
        rosco.setBirthDate(LocalDate.now());
        rosco.setPetType(savedDog);
        rosco.setOwner(owner1);
        owner1.getPets().add(rosco);

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Patrick");
        owner2.setLastName("Parson");
        owner2.setAddress("45 Beverley");
        owner2.setCity("Miami");
        owner2.setTelephone("0524422915");

        Pet mimi = new Pet();
        mimi.setName("Mimi");
        mimi.setBirthDate(LocalDate.now());
        mimi.setPetType(savedCat);
        mimi.setOwner(owner2);
        owner1.getPets().add(mimi);

        ownerService.save(owner2);


        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Diego");
        vet1.setLastName("Santos");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Estevan");
        vet2.setLastName("Mandana");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Bootstrapping complete");
    }
}
