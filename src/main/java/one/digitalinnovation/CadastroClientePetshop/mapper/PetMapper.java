package one.digitalinnovation.CadastroClientePetshop.mapper;

import one.digitalinnovation.CadastroClientePetshop.dto.request.PetDTO;
import one.digitalinnovation.CadastroClientePetshop.dto.response.PetResponseDTO;
import one.digitalinnovation.CadastroClientePetshop.entity.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PetMapper {

    PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);

    Pet toModel(PetDTO petDTO);
    PetDTO toDTO(Pet pet);
    PetResponseDTO toResponseDTO(Pet pet);
}
