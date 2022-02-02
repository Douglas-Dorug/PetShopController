package one.digitalinnovation.CadastroClientePetshop.repository;

import one.digitalinnovation.CadastroClientePetshop.entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CostumerRepository extends JpaRepository<Costumer, Long> {

}
