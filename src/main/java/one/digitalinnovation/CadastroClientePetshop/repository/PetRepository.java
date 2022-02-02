package one.digitalinnovation.CadastroClientePetshop.repository;

import one.digitalinnovation.CadastroClientePetshop.entity.Costumer;
import one.digitalinnovation.CadastroClientePetshop.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByCostumer(Costumer costumer);


}
