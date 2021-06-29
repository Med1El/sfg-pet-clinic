package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.models.Owner;
import guru.springframework.sfgpetclinic.models.PetType;
import guru.springframework.sfgpetclinic.models.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCat = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Ismail");
        owner1.setLastName("Ba");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Patrick");
        owner2.setLastName("Parson");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Diego");
        vet1.setLastName("Santos");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Estevan");
        vet2.setLastName("Mandana");
        vetService.save(vet2);

        System.out.println("Bootstrapping complete");

    }
}
