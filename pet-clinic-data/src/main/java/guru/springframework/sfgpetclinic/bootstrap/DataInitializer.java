package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.models.Owner;
import guru.springframework.sfgpetclinic.models.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataInitializer(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

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
