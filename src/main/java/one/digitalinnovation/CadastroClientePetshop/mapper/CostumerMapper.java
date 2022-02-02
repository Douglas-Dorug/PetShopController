package one.digitalinnovation.CadastroClientePetshop.mapper;

import one.digitalinnovation.CadastroClientePetshop.dto.request.CostumerDTO;
import one.digitalinnovation.CadastroClientePetshop.entity.Costumer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CostumerMapper {

    CostumerMapper INSTANCE = Mappers.getMapper(CostumerMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Costumer toModel(CostumerDTO costumerDTO);
    CostumerDTO toDTO(Costumer costumer);
}
