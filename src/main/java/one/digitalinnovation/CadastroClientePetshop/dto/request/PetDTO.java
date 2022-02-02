package one.digitalinnovation.CadastroClientePetshop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.CadastroClientePetshop.entity.Costumer;
import one.digitalinnovation.CadastroClientePetshop.enums.PetType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PetDTO {
    private Long id;

    @Enumerated(EnumType.STRING)
    private PetType type;

    private String nome;

    private String idade;

    private String raca;

    private Long idCliente;


}
