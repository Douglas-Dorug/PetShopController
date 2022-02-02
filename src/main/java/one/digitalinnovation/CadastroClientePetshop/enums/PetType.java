package one.digitalinnovation.CadastroClientePetshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PetType {

    DOG("Cão"),
    CAT("Gato"),
    OTHER("Outro");


    private final String description;
}
